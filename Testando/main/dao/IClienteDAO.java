package main.dao;
import java.util.List;

import main.domain.Cliente;

public interface IClienteDAO {

    public Integer cadastrar(Cliente cliente) throws Exception;

    /* consultar seria o "buscar" */
    public Cliente consultar(String codigo) throws Exception;

    public Integer excluir(Cliente clienteBD) throws Exception;

    public List<Cliente> buscarTodos() throws Exception;

    public Integer atualizar(Cliente clienteBD) throws Exception;

    
}