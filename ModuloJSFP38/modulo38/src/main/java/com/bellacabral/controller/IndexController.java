package com.bellacabral.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class IndexController implements Serializable {
    
    public String redirectCliente() {
		return "/cliente/list.jsp";
	}
     
    /* public String redirectCliente() {
		return "/cliente/list.xhtml";
	} */

}
