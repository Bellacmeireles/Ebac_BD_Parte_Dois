package com.example.dao.jpa;

import com.example.dao.generic.GenericJpaDB2DAO;
import com.example.domain.jpa.ClienteJpa;

public class ClienteJpaDB2DAO extends GenericJpaDB2DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

    public ClienteJpaDB2DAO() {
		super(ClienteJpa.class);
	}
    
}
