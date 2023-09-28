package com.example.dao.jpa;

import com.example.dao.generic.GenericJpaDAO;
import com.example.domain.jpa.ProdutoJpa;

public class ProdutoJpaDAO extends GenericJpaDAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}
    
}
