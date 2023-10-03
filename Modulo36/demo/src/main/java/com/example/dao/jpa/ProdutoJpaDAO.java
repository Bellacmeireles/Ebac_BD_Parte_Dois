package com.example.dao.jpa;

//import com.example.dao.generic.GenericJpaDAO;
import com.example.dao.generic.GenericJpaDB1DAO;
import com.example.domain.jpa.ProdutoJpa;

public class ProdutoJpaDAO extends GenericJpaDB1DAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}
    
}
