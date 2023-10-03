package com.example.dao.jpa;

//import com.example.dao.generic.GenericJpaDB2DAO;
import com.example.dao.generic.GenericJpaDB3DAO;
//import com.example.domain.jpa.ClienteJpa;
import com.example.domain.jpa.ClienteJpa2;

public class ClienteJpaDB3DAO extends GenericJpaDB3DAO<ClienteJpa2, Long> implements IClienteJpaDAO<ClienteJpa2> {

	public ClienteJpaDB3DAO() {
		super(ClienteJpa2.class);
	}

}
