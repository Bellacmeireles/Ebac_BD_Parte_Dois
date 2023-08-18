package Testando.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Testando.main.domain.Produto;
import Testando.main.jdbc.Conexao;

public class ProdutoDAO implements IProdutoDAO {

    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = Conexao.getConnection();
            String sql = "insert into tb_produto_test (ID, CODIGO, NOME) VALUES (nextval('sq_produto'),?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getCodigoP());
            stm.setString(2, produto.getNomeP());
            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

    }

    @Override
    public Produto consultar(String codigoP) throws Exception {
        Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
        Produto produto = null;
        try {
            connection = Conexao.getConnection();
            String sql = "select * from tb_produto_test where codigo = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, codigoP);
            rs = stm.executeQuery();
            if (rs.next()) {
                produto = new Produto();
                produto.setIdP(rs.getLong("id"));
                produto.setCodigoP(rs.getString("codigo"));
                produto.setNomeP(rs.getString("nome"));
            }
            return produto;
        } catch(Exception e) {
           throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer excluir(Produto produtoBD) throws Exception {
        Connection connection = null;
		PreparedStatement stm = null;
        try {
            connection = Conexao.getConnection();
            String sql = "DELETE FROM tb_produto_test WHERE CODIGO = ? ";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produtoBD.getCodigoP());
            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public List<Produto> buscarTodos() throws Exception {
        Connection connection = null;
		PreparedStatement stm = null;
        ResultSet rs = null;

        List<Produto> list = new ArrayList<>();
        Produto produto = null;

        try {
            connection = Conexao.getConnection();
            String sql = getSqlSelectAll();
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                produto = new Produto();
                Long id = rs.getLong("ID");
                String nome = rs.getString("NOME");
                String cd = rs.getString("CODIGO");
                produto.setIdP(id);
                produto.setNomeP(nome);
                produto.setCodigoP(cd);
                list.add(produto);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, rs);
        }
        return list;
    }

    @Override
    public Integer atualizar(Produto produtoBD) throws Exception {
        Connection connection = null;
		PreparedStatement stm = null;
        try {
            connection = Conexao.getConnection();
            String sql = getSqlUpdate();
            stm = connection.prepareStatement(sql);
            addParamUpdate(stm, produtoBD);
            return stm.executeUpdate();       
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    

    private void addParamUpdate(PreparedStatement stm, Produto produtoBD) throws SQLException {
        stm.setString(1, produtoBD.getNomeP());
        stm.setString(2, produtoBD.getCodigoP());
        stm.setLong(3, produtoBD.getIdP());
    }

    private String getSqlUpdate() {
        StringBuilder sbupdate = new StringBuilder();
        sbupdate.append("UPDATE tb_produto_test ");
        sbupdate.append("SET NOME = ?, CODIGO = ? ");
        sbupdate.append("WHERE ID = ?");
        return sbupdate.toString();
    }

    private void closeConnection(Connection connection, PreparedStatement stm, ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    private String getSqlSelectAll() {
        StringBuilder sbu = new StringBuilder();
		sbu.append("select * from tb_produto_test");
		return sbu.toString();
    }

    
}
