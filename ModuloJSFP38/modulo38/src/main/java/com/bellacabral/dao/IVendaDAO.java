package com.bellacabral.dao;

import com.bellacabral.dao.generic.IGenericDAO;
import com.bellacabral.domain.Venda;

public interface IVendaDAO extends IGenericDAO<Venda, Long> {

	void finalizarVenda(Venda venda);

	void cancelarVenda(Venda venda);

	Venda consultarComCollection(Long id);

}
