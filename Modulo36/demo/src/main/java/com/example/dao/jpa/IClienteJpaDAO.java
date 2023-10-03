package com.example.dao.jpa;

import com.example.dao.Persistente;
import com.example.dao.generic.IGenericJapDAO;
//import com.example.domain.jpa.ClienteJpa;

public interface IClienteJpaDAO <T extends Persistente> extends IGenericJapDAO<T, Long> {
    
}
