package com.osorio.mieconomia.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@Entity(name = "CATEGORIAS")
public class Categoria implements Serializable {

    @Id
    @Column(name = "ID_CATEGORIA")
    @SequenceGenerator(name = "generator_id_categoria", sequenceName = "CATEGORIA_SEQ",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_id_categoria")
    private Integer idCategoria;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Detalle> detallesList;


    public Categoria() {

    }

    public Categoria(Integer idCategoria, String nombre, String descripcion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }


}
