package com.bellacabral.service;

import java.util.List;

import com.bellacabral.domain.Produto;
import com.bellacabral.service.generic.IGenericService;

public interface IProdutoService extends IGenericService<Produto, String> {

	List<Produto> filtrarProdutos(String query);

}
