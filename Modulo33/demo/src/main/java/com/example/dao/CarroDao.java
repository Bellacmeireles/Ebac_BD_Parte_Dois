package com.example.dao;

import com.example.domain.Carro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CarroDao implements ICarroDao {

    @Override
    public Carro cadastrar(Carro carro) {
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UsandoJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(carro);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return carro;

    }
    
}
