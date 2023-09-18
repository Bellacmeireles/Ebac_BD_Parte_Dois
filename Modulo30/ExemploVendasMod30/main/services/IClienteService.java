package ExemploVendasMod30.main.services;

import ExemploVendasMod30.main.domain.Cliente;
import ExemploVendasMod30.main.exceptions.DAOException;
import ExemploVendasMod30.main.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

    //Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException;

    Cliente buscarPorCPF(Long cpf) throws DAOException;

    //void excluir(Long cpf);

    //void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;
    
}
