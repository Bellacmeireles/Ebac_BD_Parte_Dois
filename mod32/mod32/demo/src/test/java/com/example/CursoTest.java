package com.example;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.example.dao.CursoDao;
import com.example.dao.ICursoDao;
import com.example.domain.Curso;

public class CursoTest {
    
    private ICursoDao cursoDao;

    public CursoTest() {
        cursoDao = new CursoDao();
    }

    @Test
    public void cadastrar() {
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setDescricao("Curso teste");
        curso.setNome("Curso de Java");
        curso = cursoDao.cadastrar(curso);

        assertNotNull(curso);
        assertNotNull(curso.getId());
    }

}
