package ExemploVendasMod30.main.services.generic;

import java.io.Serializable;
import java.util.Collection;

import ExemploVendasMod30.main.dao.Persistente;
import ExemploVendasMod30.main.dao.generics.IGenericDAO;
import ExemploVendasMod30.main.exceptions.DAOException;
import ExemploVendasMod30.main.exceptions.MaisDeUmRegistroException;
import ExemploVendasMod30.main.exceptions.TableException;
import ExemploVendasMod30.main.exceptions.TipoChaveNaoEncontradaException;

public abstract class GenericService<T extends Persistente, E extends Serializable>
    implements IGenericService<T, E> {
	
	protected IGenericDAO<T,E> dao;
	
	public GenericService(IGenericDAO<T,E> dao) {
		this.dao = dao;
	} 

    @Override
	public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		return this.dao.cadastrar(entity);
	}

	@Override
	public void excluir(E valor) throws DAOException {
		this.dao.excluir(valor);
	}

	@Override
	public void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		this.dao.alterar(entity);
	}

	@Override
	public T consultar(E valor) throws DAOException {
		try {
			return this.dao.consultar(valor);
		} catch (MaisDeUmRegistroException | TableException e) {
            // TODO Auto-generated catch block
			//TODO levantar um erro genérico
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Collection<T> buscarTodos() throws DAOException {
		return this.dao.buscarTodos();
	}

    
}
