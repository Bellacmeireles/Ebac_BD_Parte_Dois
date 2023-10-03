package com.example.dao.generic;

import java.io.Serializable;

import com.example.dao.Persistente;

public class GenericJpaDB2DAO<T extends Persistente, E extends Serializable>
	extends GenericJpaDAO<T,E> {

	public GenericJpaDB2DAO(Class<T> persistenteClass) {
		super(persistenteClass, "Postgre2");
	}

}
