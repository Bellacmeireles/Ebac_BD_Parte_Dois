package com.example.dao.generic;

import java.io.Serializable;

import com.example.dao.Persistente;

public class GenericJpaDB3DAO<T extends Persistente, E extends Serializable>
	extends GenericJpaDAO<T,E> {

	public GenericJpaDB3DAO(Class<T> persistenteClass) {
		super(persistenteClass, "Mysql1");
	}

}
