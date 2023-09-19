package com.example.dao;

import com.example.domain.Computador;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ComputadorDao implements IComputadorDao {

    @Override
    public Computador cadastrar(Computador computador) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(computador);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return computador;

    }
    
}
