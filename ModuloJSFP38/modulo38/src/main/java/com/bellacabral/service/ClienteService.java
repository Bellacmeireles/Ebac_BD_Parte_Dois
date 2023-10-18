package com.bellacabral.service;

import java.util.List;

import javax.inject.Inject;

import com.bellacabral.dao.IClienteDAO;
import com.bellacabral.domain.Cliente;
import com.bellacabral.exceptions.DAOException;
import com.bellacabral.exceptions.MaisDeUmRegistroException;
import com.bellacabral.exceptions.TableException;
import com.bellacabral.services.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    private IClienteDAO clienteDAO;
	
	@Inject
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
		this.clienteDAO = clienteDAO;
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Cliente> filtrarClientes(String query) {
		return clienteDAO.filtrarClientes(query);
	}

    
}
