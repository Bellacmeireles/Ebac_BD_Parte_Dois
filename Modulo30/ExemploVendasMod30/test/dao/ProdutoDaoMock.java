package ExemploVendasMod30.test.dao;



import java.util.Collection;

import ExemploVendasMod30.main.dao.IProdutoDao;
import ExemploVendasMod30.main.domain.Produto;
import ExemploVendasMod30.main.exceptions.TipoChaveNaoEncontradaException;

public class ProdutoDaoMock implements IProdutoDao {

    @Override
    public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public void excluir(String valor) {
        
    }

    @Override
    public void alterar(Produto entity) throws TipoChaveNaoEncontradaException {
        
    }

    @Override
    public Produto consultar(String valor) {
        Produto produto = new Produto();
		produto.setCodigo(valor);
		return produto;
    }

    @Override
    public Collection<Produto> buscarTodos() {
        return null;
    }



}
