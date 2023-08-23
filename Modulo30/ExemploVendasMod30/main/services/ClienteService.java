package Modulo30.ExemploVendasMod30.main.services;

import Modulo30.ExemploVendasMod30.main.dao.IClienteDAO;
import Modulo30.ExemploVendasMod30.main.domain.Cliente;
import Modulo30.ExemploVendasMod30.main.exceptions.DAOException;
import Modulo30.ExemploVendasMod30.main.exceptions.MaisDeUmRegistroException;
import Modulo30.ExemploVendasMod30.main.exceptions.TableException;
import Modulo30.ExemploVendasMod30.main.services.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    //private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);
        //this.clienteDAO = clienteDAO;
    }

    /* @Override
    public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        return clienteDAO.cadastrar(cliente);
    } */

    @Override
    public Cliente buscarPorCPF(Long cpf) throws DAOException {
        try {
            return this.dao.consultar(cpf);
        } catch (MaisDeUmRegistroException | TableException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

    /* @Override
    public void excluir(Long cpf) {
        clienteDAO.excluir(cpf);
        
    }

    @Override
    public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        clienteDAO.alterar(cliente);
        
    } */

}
