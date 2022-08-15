package com.osorio.mieconomia.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "USUARIOS")
public class Usuario implements Serializable {

    @Id
    @Column(name = "ID_USUARIO")
    @SequenceGenerator(name="generator_id_usuario", sequenceName = "USUARIO_SEQ", initialValue = 1, allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator ="generator_id_usuario" )
    private Integer idUsuario;

    @Column(name = "NOMBRES")
    private String nombres;

    @Column(name="PRIMER_APELLIDO")
    private String primerApellido;

    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;

    @Column(name="FECHA_NACIMIENTO")
    private LocalDate fechaNacimiento;

    @Column(name = "SALARIO")
    private Double salario;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Detalle> detalleList ;


    public Usuario()
    {

    }

    public Usuario(Integer idUsuario, String nombres, String primerApellido,
                   String segundoApellido, LocalDate fechaNacimiento, Double salario) {
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombres='" + nombres + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", salario=" + salario +
                '}';
    }

   @JsonIgnore
    public List<Detalle> getDetalleList() {
        return detalleList;
    }

    public void setDetalleList(List<Detalle> detalleList) {
        this.detalleList = detalleList;
    }
}
