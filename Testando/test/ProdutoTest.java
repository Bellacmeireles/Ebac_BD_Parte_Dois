package Testando.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import Testando.main.dao.IProdutoDAO;
import Testando.main.dao.ProdutoDAO;
import Testando.main.domain.Produto;

public class ProdutoTest {
    
    private IProdutoDAO produtoDAO;

    @Test
    public void cadastrarTest() throws Exception {

        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigoP("2402");
        produto.setNomeP("Perfume 212");

        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = dao.consultar(produto.getCodigoP());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getIdP());
        assertEquals(produto.getCodigoP(), produtoBD.getCodigoP());
        assertEquals(produto.getNomeP(), produtoBD.getNomeP());

        Integer qtdDel = dao.excluir(produtoBD);
        assertNotNull(qtdDel);

    }

    /* test para consultar */
    @Test
    public void consultarTest() throws Exception {
        produtoDAO = new ProdutoDAO();
        Produto produto = new Produto();

        produto.setCodigoP("1024");
        produto.setNomeP("Boneco do São Paulo");
        Integer qtd = produtoDAO.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = produtoDAO.consultar(produto.getCodigoP());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getIdP());
        assertEquals(produto.getCodigoP(), produtoBD.getCodigoP());
        assertEquals(produto.getNomeP(), produtoBD.getNomeP());

        Integer qtdDel = produtoDAO.excluir(produtoBD);
        assertNotNull(qtdDel == 1);

    }

    /* test para excluir */
    @Test
    public void excluirTest() throws Exception {
        produtoDAO = new ProdutoDAO();
        Produto produto = new Produto();

        produto.setCodigoP("1024");
        produto.setNomeP("Boneco do São Paulo");
        Integer qtd = produtoDAO.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = produtoDAO.consultar("1024");
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getIdP());
        assertEquals(produto.getCodigoP(), produtoBD.getCodigoP());
        assertEquals(produto.getNomeP(), produtoBD.getNomeP());

        Integer qtdDel = produtoDAO.excluir(produtoBD);
        assertNotNull(qtdDel == 1);
    }

    /* test para buscar todos */
    @Test
    public void buscarTodosTest() throws Exception {
        produtoDAO = new ProdutoDAO();
        Produto produto = new Produto();

        produto.setCodigoP("1024");
        produto.setNomeP("Boneco do São Paulo");
        Integer qtd = produtoDAO.cadastrar(produto);
        assertTrue(qtd == 1);

        produto.setCodigoP("2435");
        produto.setNomeP("Bola");
        Integer qtd2 = produtoDAO.cadastrar(produto);
        assertTrue(qtd2 == 1);

        List<Produto> list = produtoDAO.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        int qtdDel = 0;
        for (Produto prod : list) {
            produtoDAO.excluir(prod);
            qtdDel++;
        }
        assertEquals(list.size(), qtdDel);

        list = produtoDAO.buscarTodos();
         assertEquals(list.size(), 0);

    }

    /* test para atualizar */
    @Test
    public void atualizarTest() throws Exception {

        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigoP("10");
        produto.setNomeP("Boneco do São Paulo");
        Integer qtd = produtoDAO.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = produtoDAO.consultar("10");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigoP(), produtoBD.getCodigoP());
        assertEquals(produto.getNomeP(), produtoBD.getNomeP());

        produtoBD.setCodigoP("20");
        produtoBD.setNomeP("Bola");
        Integer qtdUpDate = produtoDAO.atualizar(produtoBD);
        assertTrue(qtdUpDate == 1);

        Produto produtoBD1 = produtoDAO.consultar("10");
        assertNull(produtoBD1);

        Produto produtoBD2 = produtoDAO.consultar("20");
        assertNotNull(produtoBD2);
        assertEquals(produtoBD.getIdP(), produtoBD2.getIdP());
        assertEquals(produtoBD.getCodigoP(), produtoBD2.getCodigoP());
        assertEquals(produtoBD.getNomeP(), produtoBD2.getNomeP());

    }

}
