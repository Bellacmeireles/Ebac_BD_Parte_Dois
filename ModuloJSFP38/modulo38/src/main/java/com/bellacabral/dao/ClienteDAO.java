package com.bellacabral.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import com.bellacabral.dao.generic.GenericDAO;
import com.bellacabral.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {
    
    public ClienteDAO() {
		super(Cliente.class);
	}

    @Override
	public List<Cliente> filtrarClientes(String query) {
		TypedQuery<Cliente> tpQuery = 
				this.entityManager.createNamedQuery("Cliente.findByNome", this.persistenteClass);
		tpQuery.setParameter("nome", "%" + query + "%");
        return tpQuery.getResultList();
		
	}
    
}
