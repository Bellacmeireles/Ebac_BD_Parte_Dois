package com.example.dao;

import com.example.domain.Acessorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AcessorioDao implements IAcessorioDao {

    @Override
    public Acessorio cadastrar(Acessorio acessorio) {
       
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UsandoJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(acessorio);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return acessorio;

    }
    
}
