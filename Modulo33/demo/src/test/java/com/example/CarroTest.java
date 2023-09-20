package com.example;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.example.dao.AcessorioDao;
import com.example.dao.CarroDao;
import com.example.dao.IAcessorioDao;
import com.example.dao.ICarroDao;
import com.example.dao.IMarcaDao;
import com.example.dao.MarcaDao;
import com.example.domain.Acessorio;
import com.example.domain.Carro;
import com.example.domain.Marca;

public class CarroTest {
    
    private ICarroDao carroDao;

    private IMarcaDao marcaDao;

    private IAcessorioDao acessorioDao;

    public CarroTest() {
        carroDao = new CarroDao();
        marcaDao = new MarcaDao();
        acessorioDao = new AcessorioDao();
    }

    @Test
    public void cadastrarTest() {

        Marca marca = newMarca("Telsa");

        Carro carro = new Carro();
        carro.setModelo("2023");
        carro.setMarca(marca);

        Acessorio acessorio = new Acessorio();
        acessorio.setNome("Teto solar");
        acessorio.setCodigo("+5512");

        carro.add(acessorio);
        carroDao.cadastrar(carro);

        assertNotNull(acessorio);
        assertNotNull(acessorio.getId());

    }

    private Marca newMarca(String nome) {
        Marca marca = new Marca();
        marca.setNome(nome);
        marca.setCodigo("A23");
        marcaDao.cadastrar(marca);
        return marca;
    }

}
