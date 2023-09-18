package ExemploVendasMod30.main.services;

import ExemploVendasMod30.main.dao.IClienteDAO;
import ExemploVendasMod30.main.domain.Cliente;
import ExemploVendasMod30.main.exceptions.DAOException;
import ExemploVendasMod30.main.exceptions.MaisDeUmRegistroException;
import ExemploVendasMod30.main.exceptions.TableException;
import ExemploVendasMod30.main.services.generic.GenericService;

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
