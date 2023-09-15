package com.example.dao;

import java.util.List;

import com.example.domain.Curso;
import com.example.domain.Matricula;

public interface IMatriculaDao {

    public Matricula cadastrar(Matricula mat);

    public Matricula buscarPorCodigoCurso(String codigoCurso);

    public Matricula buscarPorCurso(Curso curso);

    public List<Matricula> buscarTodos();

    public void excluir(Matricula mat);
    
}
