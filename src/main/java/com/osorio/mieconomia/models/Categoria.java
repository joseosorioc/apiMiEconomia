package com.osorio.mieconomia.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "CATEGORIAS")
public class Categoria implements Serializable {

    @Id
    @Column(name="ID_CATEGORIA")
    @SequenceGenerator(name="generator_id_categoria", sequenceName = "CATEGORIA_SEQ",
            initialValue = 1, allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_id_categoria")
    private Integer idCategoria;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Detalle> detallesList;



    public Categoria()
    {

    }

    public Categoria(Integer idCategoria, String nombre, String descripcion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria=" + idCategoria +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @JsonIgnore
    public List<Detalle> getDetallesList() {
        return detallesList;
    }

    public void setDetallesList(List<Detalle> detallesList) {
        this.detallesList = detallesList;
    }

}
