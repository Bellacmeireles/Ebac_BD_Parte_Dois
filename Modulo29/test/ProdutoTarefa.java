package Modulo29.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import Modulo29.main.dao.IProdutoDAO;
import Modulo29.main.dao.ProdutoDAO;
import Modulo29.main.domain.Produto;

public class ProdutoTarefa {
    
    private IProdutoDAO produtoDAO;

    @Test
    public void cadastrarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto prod = new Produto();
        prod.setNomeProd("Skate Black");
        prod.setIdProd("777");

        
        Integer qtd = produtoDAO.cadastrar(prod);
        assertTrue(qtd == 1);

        Integer qtdDel = produtoDAO.excluir(prod);
        assertNotNull(qtdDel == 1);

    }

    @Test
    public void consultarTest() throws Exception {
        produtoDAO = new ProdutoDAO();
        Produto prod = new Produto();

        prod.setNomeProd("Bicicleta Eletrica");
        prod.setIdProd("2");
        
        Integer qtdc = produtoDAO.cadastrar(prod);
        assertTrue(qtdc == 1);

        Produto prodBD = produtoDAO.consultar("2");
        assertNotNull(prodBD);
        assertNotNull(prodBD.getNomeProd());
        assertEquals(prod.getIdProd(), prodBD.getIdProd());
		assertEquals(prod.getNomeProd(), prodBD.getNomeProd());

        Integer qtdDel = produtoDAO.excluir(prodBD);
        assertNotNull(qtdDel == 1);

    }

    @Test
	public void excluirTest() throws Exception {
		produtoDAO = new ProdutoDAO();
        Produto prod = new Produto();
		prod.setIdProd("5");
		prod.setNomeProd("Bicicleta Eletrica");
		Integer qtd = produtoDAO.cadastrar(prod);
		assertTrue(qtd == 1);

		Produto produtoBD = produtoDAO.consultar(prod.getIdProd());

		Integer qtdDel = produtoDAO.excluir(produtoBD);
		assertNotNull(qtdDel == 1);
	}

    @Test
    public void atualizarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto prod = new Produto();
        prod.setIdProd("10");
        prod.setNomeProd("Brinquedo 1");
        Integer qda = produtoDAO.cadastrar(prod);
        assertTrue(qda == 1);

        Produto prodBD = produtoDAO.consultar("10");
        assertNotNull(prodBD);
        assertEquals(prod.getIdProd(), prodBD.getIdProd());
        assertEquals(prod.getNomeProd(), prodBD.getNomeProd());

        prodBD.setIdProd("20");
        prodBD.setNomeProd("Brinquedo 2");
        Integer count = produtoDAO.atualizar(prodBD);
        assertTrue(count == 1);

        Produto prodBD1 = produtoDAO.consultar("10");
        assertNotNull(prodBD1);

        Produto prodBD2 = produtoDAO.consultar("10");
        assertNotNull(prodBD2);
        assertEquals(prod.getIdProd(), prodBD2.getIdProd());
        assertEquals(prod.getNomeProd(), prodBD2.getNomeProd());

        List<Produto> list = produtoDAO.buscarTodos();
		for (Produto cli : list) {
			produtoDAO.excluir(cli);
		}

    }

}
