package com.osorio.mieconomia.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "DETALLES")
public class Detalle implements Serializable {

    @Id
    @Column(name = "ID_DETALLE")
    @SequenceGenerator(name = "generator_id_detalle", sequenceName = "DETALLES_SEQ",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_id_detalle")
    private Integer idDetalle;

    @Column(name = "MONTO")
    private Double monto;

    @Column(name = "COMENTARIO")
    private String comentario;

    @Column(name = "CARACTERISTICA")
    private String caracteristica;

    @Column(name = "FECHA_GENERACION")
    private LocalDate fechaGeneracion;

    @JoinColumn(name = "USUARIO")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario usuario;

    @JoinColumn(name = "CATEGORIA")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Categoria categoria;

    @JoinColumn(name = "FUENTE")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Fuente fuente;


    @Override
    public String toString() {
        return "Detalle{" +
                "idDetalle=" + idDetalle +
                ", monto=" + monto +
                ", comentario='" + comentario + '\'' +
                ", caracteristica='" + caracteristica + '\'' +
                ", fechaGeneracion=" + fechaGeneracion +
                ", usuario=" + usuario +
                ", categoria=" + categoria +
                ", fuente=" + fuente +
                '}';
    }


    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public LocalDate getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDate fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Fuente getFuente() {
        return fuente;
    }

    public void setFuente(Fuente fuente) {
        this.fuente = fuente;
    }
}

