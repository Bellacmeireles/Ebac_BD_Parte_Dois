package com.example.exceptions;

public class DAOException extends Exception {

    public DAOException(String msg, Exception ex) {
		super(msg, ex);
    }
    
}
