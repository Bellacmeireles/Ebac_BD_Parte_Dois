package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;

import java.time.Instant;

import org.junit.After;
import org.junit.Test;

import com.example.dao.CursoDao;
import com.example.dao.ICursoDao;
import com.example.dao.IMatriculaDao;
import com.example.dao.MatriculaDao;
import com.example.domain.Curso;
import com.example.domain.Matricula;

public class MatriculaTest {

    public IMatriculaDao matriculaDao;
    private ICursoDao cursoDao;

    public MatriculaTest() {
        matriculaDao = new MatriculaDao();
        cursoDao = new CursoDao();
    }

    @After
    public void end() {
        List<Matricula> list = matriculaDao.buscarTodos();
        list.forEach(mat -> matriculaDao.excluir(mat));
        
        List<Curso> listCursos = cursoDao.buscarTodos();
		listCursos.forEach(cur -> cursoDao.excluir(cur));

    }

    @Test
    public void cadastrar() {
        Curso curso = criarCurso("A1");
        Matricula mat = new Matricula();
        mat.setCodigo("M1");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("ATIVO");
        mat.setValor(2000d);
        mat.setCurso(curso);
        mat = matriculaDao.cadastrar(mat);

        assertNotNull(mat);
        assertNotNull(mat.getId());

        Matricula matBD = matriculaDao.buscarPorCodigoCurso(curso.getCodigo());
        assertNotNull(matBD);
        assertEquals(mat.getId(), matBD.getId());

        Matricula matBDObj = matriculaDao.buscarPorCurso(curso);
        assertNotNull(matBDObj);
        assertEquals(mat.getId(), matBDObj.getId());

    }

    private Curso criarCurso(String string) {
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setDescricao("Curso teste");
        curso.setNome("Curso de Java");
        return cursoDao.cadastrar(curso);
    }
    
}
