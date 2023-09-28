package com.example.dao.jpa;

import com.example.dao.generic.GenericJpaDAO;
import com.example.domain.jpa.ClienteJpa;

public class ClienteJpaDAO extends GenericJpaDAO<ClienteJpa, Long> implements IClienteJpaDAO {

    public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}
    
}
