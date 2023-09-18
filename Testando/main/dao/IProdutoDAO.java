package main.dao;

import java.util.List;

import main.domain.Produto;

public interface IProdutoDAO {

    public Integer cadastrar(Produto produto) throws Exception;

    public Produto consultar(String codigoP) throws Exception;

    public Integer excluir(Produto produtoBD) throws Exception;

    public List<Produto> buscarTodos() throws Exception;

    public Integer atualizar(Produto produtoBD) throws Exception;

    
    
}
