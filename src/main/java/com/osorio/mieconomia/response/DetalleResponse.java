package com.osorio.mieconomia.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetalleResponse implements Serializable {

    private Integer idDetalle;
    private  LocalDate fechaCreacion;
    private  String elemento;
    private  String caracteristica;


}
