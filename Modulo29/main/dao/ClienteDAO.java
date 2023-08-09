package Modulo29.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modulo29.main.domain.Cliente;
import Modulo29.main.jdbc.ExConexao;

/**
 * @author bella.c.meireles
 *
 */

public class ClienteDAO implements IClienteDAO {
	@Override
    public Integer cadastrar(Cliente cliente) throws Exception {
        Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = ExConexao.getConnection();
			String sql = "insert into tb_cliente_2 (ID, CODIGO, NOME) VALUES (nextval('sql_cliente'),?,?)";
			stm = connection.prepareStatement(sql);
			stm.setString(1, cliente.getCodigo());
			stm.setString(2, cliente.getNome());
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
    public Cliente consultar(String codigo) throws Exception {
        Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Cliente cliente = null;
		try {
			connection = ExConexao.getConnection();
			String sql = "select * from tb_cliente_2 where codigo = ?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, codigo);
			rs = stm.executeQuery();
			if (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setCodigo(rs.getString("codigo"));
				cliente.setNome(rs.getString("nome"));
			}
			return cliente;
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
	public Integer excluir(Cliente cliente) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = ExConexao.getConnection();
			String sql = "DELETE FROM TB_CLIENTE_2 WHERE CODIGO = ?	";
			stm = connection.prepareStatement(sql);
			stm.setString(1, cliente.getCodigo());
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
	public List<Cliente> buscarTodos() throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		List<Cliente> list = new ArrayList<>();
		Cliente cliente = null;

		try {
			connection = ExConexao.getConnection();
			String sql = getSqlSelectAll();
			stm = connection.prepareStatement(sql);	
			rs = stm.executeQuery();

			while (rs.next()) {
				cliente = new Cliente();
				Long id = rs.getLong("ID");
				String nome = rs.getString("NOME");
				String cd = rs.getString("CODIGO");
				cliente.setId(id);
				cliente.setNome(nome);
				cliente.setCodigo(cd);
				list.add(cliente);
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			closeConnection(connection, stm, rs);
		}
		return list;
	}

	@Override
	public Integer atualizar(Cliente clienteBD) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = ExConexao.getConnection();
			String sql = getSqlUpdate();
			stm = connection.prepareStatement(sql);	
			addParamUpdate(stm, clienteBD);
			return stm.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			closeConnection(connection, stm, null);
		}
	}

	private void addParamUpdate(PreparedStatement stm, Cliente cliente) throws SQLException {
		stm.setString(1, cliente.getNome());
		stm.setString(2, cliente.getCodigo());
		stm.setLong(3, cliente.getId());
	}

	private String getSqlUpdate() {
		StringBuilder sbupdate = new StringBuilder();
		sbupdate.append("UPDATE TB_CLIENTE_2 ");
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
		sbu.append("select * from tb_cliente_2");
		return sbu.toString();
	}

    
}
