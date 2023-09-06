package Modulo32.src.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import Modulo32.src.main.dao.CursoDao;
import Modulo32.src.main.dao.ICursoDao;
import Modulo32.src.main.domain.Curso;

public class CursoTest {

    private ICursoDao cursoDao;
	
	public CursoTest() {
		cursoDao = new CursoDao();
	}
    
    @Test
    public void cadastrar() {
        Curso curso = new Curso();
		curso.setCodigo("A1");
		curso.setDescricao("CURSO TESTE");
		curso.setNome("Curso de Java Backend");
		curso = cursoDao.cadastrar(curso);
		
		assertNotNull(curso);
		assertNotNull(curso.getId());
    }
}
