package com.example;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.example.dao.IProdutoDao;
import com.example.dao.ProdutoDao;
import com.example.domain.Produto;

public class ProdutoTest {

    public IProdutoDao produtoDao;

    public ProdutoTest() {
        produtoDao = new ProdutoDao();
    }

    @Test
    public void cadastrar() {
        Produto prod = new Produto();
        prod.setCodigo("Lenovo3i");
        prod.setNome("Computador");
        prod.setValor(250d);

        prod = produtoDao.cadastrar(prod);

        assertNotNull(prod);
        assertNotNull(prod.getId());
    }
    
}
