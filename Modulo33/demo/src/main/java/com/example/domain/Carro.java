package com.example.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CARRO")
public class Carro {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "carro_seq")
    @SequenceGenerator(name = "carro_seq", sequenceName = "sq_carro", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "MODELO", length = 50, nullable = false)
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "id_marca_fk,",
    foreignKey = @ForeignKey(name = "fk_marca_carro"),
    referencedColumnName = "id", nullable = false)
    private Marca marca;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "TB_CARRO_ACESSORIOS",
     joinColumns = { @JoinColumn(name = "id_carro_fk") },
     inverseJoinColumns = { @JoinColumn(name = "id_acessorio_fk")})
    private List<Acessorio> acessorios;

    public Carro() {
        this.acessorios = new ArrayList<Acessorio>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    public void add(Acessorio acessorio) {
        this.acessorios.add(acessorio);
    }
    
}
