package Modulo30.ExemploVendasMod30.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Modulo30.ExemploVendasMod30.main.dao.IClienteDAO;
import Modulo30.ExemploVendasMod30.main.domain.Cliente;
import Modulo30.ExemploVendasMod30.main.exceptions.DAOException;
import Modulo30.ExemploVendasMod30.main.exceptions.TipoChaveNaoEncontradaException;
import Modulo30.ExemploVendasMod30.main.services.ClienteService;
import Modulo30.ExemploVendasMod30.main.services.IClienteService;
import Modulo30.ExemploVendasMod30.test.dao.ClienteDaoMock;

public class ClienteServiceTest {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest() {

        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);

    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Bella");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        //clienteService.salvar(cliente);
    }

    @Test
    public void pesquisarCliente() throws DAOException {

        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException {
        Boolean retorno = clienteService.cadastrar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() throws DAOException {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
        cliente.setNome("Bella Cabral");
        clienteService.alterar(cliente);

        Assert.assertEquals("Bella Cabral", cliente.getNome());
    }

}
