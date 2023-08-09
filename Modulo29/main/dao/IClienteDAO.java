package Modulo29.main.dao;

import java.util.List;

import Modulo29.main.domain.Cliente;

/**
 * IClienteDAO
 */
public interface IClienteDAO {

    public Integer cadastrar(Cliente cliente) throws Exception;

    /* consultar seria o "buscar" */
    public Cliente consultar(String codigo) throws Exception;

    public Integer excluir(Cliente clienteBD) throws Exception;

    public List<Cliente> buscarTodos() throws Exception;

    public Integer atualizar(Cliente clienteBD) throws Exception;

    
}