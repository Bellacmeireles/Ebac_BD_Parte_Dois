package com.example.dao;

import java.util.List;

import com.example.domain.Curso;

public interface ICursoDao {

    public Curso cadastrar(Curso curso);

	public void excluir(Curso cur);

	public List<Curso> buscarTodos();
    
}
