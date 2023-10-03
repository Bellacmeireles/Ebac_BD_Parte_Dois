package com.example.dao.jpa;

//import com.example.dao.generic.GenericJpaDAO;
import com.example.dao.generic.GenericJpaDB1DAO;
import com.example.domain.jpa.ClienteJpa;

public class ClienteJpaDAO extends GenericJpaDB1DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

    public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}
    
}
