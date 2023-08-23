package Modulo30.ExemploVendasMod30.test;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Modulo30.ExemploVendasMod30.main.dao.IProdutoDao;
import Modulo30.ExemploVendasMod30.main.domain.Produto;
import Modulo30.ExemploVendasMod30.main.exceptions.DAOException;
import Modulo30.ExemploVendasMod30.main.exceptions.TipoChaveNaoEncontradaException;
import Modulo30.ExemploVendasMod30.main.services.IProdutoService;
import Modulo30.ExemploVendasMod30.main.services.ProdutoService;
import Modulo30.ExemploVendasMod30.test.dao.ProdutoDaoMock;



public class ProdutoServiceTest {
    private IProdutoService produtoService;
	
	private Produto produto;
	
	public ProdutoServiceTest() {
		IProdutoDao dao = new ProdutoDaoMock();
		produtoService = new ProdutoService(dao);
	}
	
	@Before
	public void init() {
		produto = new Produto();
		produto.setCodigo("A1");
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
	}
	
	@Test
	public void pesquisar() throws DAOException {
		Produto produtor = this.produtoService.consultar(produto.getCodigo());
		Assert.assertNotNull(produtor);
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = produtoService.cadastrar(produto);
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluir() throws DAOException {
		produtoService.excluir(produto.getCodigo());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		produto.setNome("Rodrigo Pires");
		produtoService.alterar(produto);
		
		Assert.assertEquals("Rodrigo Pires", produto.getNome());
	}

}
