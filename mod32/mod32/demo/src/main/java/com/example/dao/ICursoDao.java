package com.example.dao;

import java.util.List;

import com.example.domain.Curso;

public interface ICursoDao {

    public Curso cadastrar(Curso curso);

    public List<Curso> buscarTodos();

    public void excluir(Curso cur);
    
}
