package com.bellacabral.dao;

import java.util.List;

import com.bellacabral.dao.generic.IGenericDAO;
import com.bellacabral.domain.Cliente;

public interface IClienteDAO extends IGenericDAO<Cliente, Long> {

	List<Cliente> filtrarClientes(String query);

}
