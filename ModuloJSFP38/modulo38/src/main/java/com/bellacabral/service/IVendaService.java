package com.bellacabral.service;

import com.bellacabral.dao.generic.IGenericDAO;
import com.bellacabral.domain.Venda;

public interface IVendaService extends IGenericDAO<Venda, Long> {

	public void finalizarVenda(Venda venda);

	public void cancelarVenda(Venda venda);

	public Venda consultarComCollection(Long id);

}
