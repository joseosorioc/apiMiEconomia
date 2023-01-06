package com.osorio.mieconomia.models;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter

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



}
