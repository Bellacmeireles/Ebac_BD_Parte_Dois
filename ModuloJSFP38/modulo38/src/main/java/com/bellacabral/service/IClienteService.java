package com.bellacabral.service;

import java.util.List;

import com.bellacabral.domain.Cliente;
import com.bellacabral.exceptions.DAOException;
import com.bellacabral.service.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

    Cliente buscarPorCPF(Long cpf) throws DAOException;

	List<Cliente> filtrarClientes(String query);
    
}
