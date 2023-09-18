package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import main.dao.ClienteDAO;
import main.dao.IClienteDAO;
import main.domain.Cliente;

public class ClienteTestNovo {

	private IClienteDAO clienteDAO;

	/* test pra cadastrar */
	@Test
	public void cadastrarTest() throws Exception {

		IClienteDAO dao = new ClienteDAO();

		Cliente cliente = new Cliente();
		cliente.setCodigo("10");
		cliente.setNome("Bella");
		
		Integer qtd = dao.cadastrar(cliente);
		assertTrue(qtd == 1);

		Cliente clienteBD = dao.consultar(cliente.getCodigo());
		assertNotNull(clienteBD);
		assertNotNull(clienteBD.getId());
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		assertEquals(cliente.getNome(), clienteBD.getNome());
		
		Integer qtdDel = dao.excluir(clienteBD);
		assertNotNull(qtdDel);

	};

	
	/* test pra consultar */
	@Test
	public void consultarTest() throws Exception {
		clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();

		cliente.setCodigo("10");
		cliente.setNome("Bella");
		Integer qtd = clienteDAO.cadastrar(cliente);
		assertTrue(qtd == 1);

		Cliente clienteBD = clienteDAO.consultar(cliente.getCodigo());
		assertNotNull(clienteBD);
		assertNotNull(clienteBD.getId());
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		assertEquals(cliente.getNome(), clienteBD.getNome());

		Integer qtdDel = clienteDAO.excluir(clienteBD);
		assertNotNull(qtdDel == 1);

	}

	/* test pra excluir */

	@Test
	public void excluirTest() throws Exception {

		clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();
		cliente.setCodigo("10");
		cliente.setNome("Bella");
		Integer qtd = clienteDAO.cadastrar(cliente);
		assertTrue(qtd == 1);

		Cliente clienteBD = clienteDAO.consultar("10");
		 assertNotNull(clienteBD);
		 assertNotNull(clienteBD.getId());
		 assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		 assertEquals(cliente.getNome(), clienteBD.getNome());
		 

		Integer qtdDel = clienteDAO.excluir(clienteBD);
		assertNotNull(qtdDel == 1);
	}

	/* test pra buscarTodos */
	@Test
	public void buscarTodosTest() throws Exception {
		clienteDAO = new ClienteDAO();

		Cliente cliente = new Cliente();
		cliente.setCodigo("10");
		cliente.setNome("Bella");
		Integer qtd = clienteDAO.cadastrar(cliente);
		assertTrue(qtd == 1);

		cliente.setCodigo("20");
		cliente.setNome("Teste");
		Integer countCad2 = clienteDAO.cadastrar(cliente);
		assertTrue(countCad2 == 1);

		List<Cliente> list = clienteDAO.buscarTodos();
		assertNotNull(list);
		assertEquals(2, list.size());

		int qtdDel = 0;
		for (Cliente cli : list) {
			clienteDAO.excluir(cli);
			qtdDel++;
		}
		assertEquals(list.size(), qtdDel);

		list = clienteDAO.buscarTodos();
		assertEquals(list.size(), 0);
	}

	/* test pra atualizar */
	@Test
	public void atualizarTest() throws Exception {
		
		clienteDAO = new ClienteDAO();

		Cliente cliente = new Cliente();
		cliente.setCodigo("10");
		cliente.setNome("Rodrigo Pires");
		Integer countCad = clienteDAO.cadastrar(cliente);
		assertTrue(countCad == 1);

		Cliente clienteBD = clienteDAO.consultar("10");
		assertNotNull(clienteBD);
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		assertEquals(cliente.getNome(), clienteBD.getNome());

		clienteBD.setCodigo("20");
		clienteBD.setNome("Outro nome");
		Integer countUpdate = clienteDAO.atualizar(clienteBD);
		assertTrue(countUpdate == 1);

		Cliente clienteBD1 = clienteDAO.consultar("10");
		assertNull(clienteBD1);

		Cliente clienteBD2 = clienteDAO.consultar("20");
		assertNotNull(clienteBD2);
		assertEquals(clienteBD.getId(), clienteBD2.getId());
		assertEquals(clienteBD.getCodigo(), clienteBD2.getCodigo());
		assertEquals(clienteBD.getNome(), clienteBD2.getNome());

		List<Cliente> list = clienteDAO.buscarTodos();
		for (Cliente cli : list) {
			clienteDAO.excluir(cli);
		}
	} 

}