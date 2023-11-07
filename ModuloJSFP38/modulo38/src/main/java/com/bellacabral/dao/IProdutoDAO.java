package com.bellacabral.dao;

import java.util.List;

import com.bellacabral.dao.generic.IGenericDAO;
import com.bellacabral.domain.Produto;

public interface IProdutoDAO extends IGenericDAO<Produto, String> {

	List<Produto> filtrarProdutos(String query);

}
