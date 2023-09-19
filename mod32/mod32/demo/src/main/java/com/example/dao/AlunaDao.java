package com.example.dao;

import com.example.domain.Aluno;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AlunaDao implements IAlunoDao {

    @Override
    public Aluno cadastrar(Aluno aluno) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(aluno);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return aluno;
    }

}
