package com.example.dao;

import com.example.domain.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProdutoDao implements IProdutoDao {

    @Override
    public Produto cadastrar(Produto prod) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(prod);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return prod;
    }
    
}
