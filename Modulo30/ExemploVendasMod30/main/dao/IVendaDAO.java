package Modulo30.ExemploVendasMod30.main.dao;

import Modulo30.ExemploVendasMod30.main.dao.generics.IGenericDAO;
import Modulo30.ExemploVendasMod30.main.domain.Venda;
import Modulo30.ExemploVendasMod30.main.exceptions.DAOException;
import Modulo30.ExemploVendasMod30.main.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

}
