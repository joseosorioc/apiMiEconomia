package com.osorio.mieconomia.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "FUENTES")
public class Fuente implements Serializable {

    @Id
    @Column(name = "ID_FUENTE")
    @SequenceGenerator(name = "generator_id_fuente", sequenceName = "FUENTES_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_id_fuente")
    private Integer idFuente;

    @Column(name = "NOMBRE")
    private String nombre;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fuente", cascade = CascadeType.ALL)
    private List<Detalle> detalleList;

    public Fuente() {

    }

    public Fuente(Integer idFuente, String nombre) {
        this.idFuente = idFuente;
        this.nombre = nombre;
    }


    public Integer getIdFuente() {
        return idFuente;
    }

    public void setIdFuente(Integer idFuente) {
        this.idFuente = idFuente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonIgnore
    public List<Detalle> getDetalleList() {
        return detalleList;
    }

    public void setDetalleList(List<Detalle> detalleList) {
        this.detalleList = detalleList;
    }
}
