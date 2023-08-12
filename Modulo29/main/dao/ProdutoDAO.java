package Modulo29.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modulo29.main.domain.Produto;
import Modulo29.main.jdbc.ExConexao;

public class ProdutoDAO implements IProdutoDAO {

    @Override
    public Integer cadastrar(Produto prod) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ExConexao.getConnection();
            String sqlP = "insert into tb_produto_tarefa (ID, NOME) VALUES (nextval('sql_prod'),?)";
            stm = connection.prepareStatement(sqlP);
            stm.setString(1, prod.getIdProd());
            stm.setString(1, prod.getNomeProd());
            return stm.executeUpdate();
        } catch (Exception e) {
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
    public Produto consultar(String idProd) throws Exception {
        Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Produto produto = null;
		try {
			connection = ExConexao.getConnection();
			String sqlP = "select * from tb_produto_tarefa where id = ?";
			stm = connection.prepareStatement(sqlP);
			stm.setString(1, idProd);
			rs = stm.executeQuery();
			if (rs.next()) {
				produto = new Produto();
				produto.setIdProd(rs.getString("id"));
				produto.setNomeProd(rs.getString("nome"));
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
    public Integer excluir(Produto produto) throws Exception {
        Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = ExConexao.getConnection();
			String sqlP = "DELETE FROM tb_produto_tarefa WHERE id = ?";
			stm = connection.prepareStatement(sqlP);
            stm.setString(1, produto.getNomeProd());
			return stm.executeUpdate();
		} catch (Exception e) {
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
			connection = ExConexao.getConnection();
			String sql = getSqlSelectAll();
			stm = connection.prepareStatement(sql);	
			rs = stm.executeQuery();

			while (rs.next()) {
				produto = new Produto();
				
				String nome = rs.getString("nome");
				String id = rs.getString("id");
				produto.setIdProd(id);
				produto.setNomeProd(nome);
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
	public Integer atualizar(Produto prod) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = ExConexao.getConnection();
			String sql = getSqlUpdate();
			stm = connection.prepareStatement(sql);
			addParamUpdate(stm, prod);
			return stm.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			closeConnection(connection, stm, null);
		}
	}

	private String getSqlUpdate() {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("UPDATE tb_produto_tarefa ");
		sBuilder.append("set id = ? ");
		sBuilder.append("where nome = ?");
		return sBuilder.toString();

	}

	private void addParamUpdate(PreparedStatement stm, Produto prod) throws SQLException {
		stm.setString(1, prod.getNomeProd());
		stm.setString(2, prod.getIdProd());
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
		sbu.append("select * from tb_produto_tarefa");
		return sbu.toString();
	}

    
    
}
