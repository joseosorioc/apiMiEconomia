package com.osorio.mieconomia.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "USUARIOS")
@Getter
@Setter
@ToString
public class Usuario implements Serializable {

    @Id
    @Column(name = "ID_USUARIO")
    @SequenceGenerator(name = "generator_id_usuario", sequenceName = "USUARIO_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_id_usuario")
    private Integer idUsuario;

    @Column(name = "NOMBRES")
    private String nombres;

    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;

    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;

    @Column(name = "FECHA_NACIMIENTO")
    private LocalDate fechaNacimiento;

    @Column(name = "SALARIO")
    private Double salario;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Detalle> detalleList;


    public Usuario() {

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


}
