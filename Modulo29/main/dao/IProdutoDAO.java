package Modulo29.main.dao;

import java.util.List;

import Modulo29.main.domain.Produto;

public interface IProdutoDAO {

	public Integer cadastrar(Produto prod) throws Exception;

    public Produto consultar(String idProd) throws Exception;

    public Integer excluir(Produto produto) throws Exception;

    public Integer atualizar(Produto prod) throws Exception;

    public List<Produto> buscarTodos() throws Exception;
    
}
