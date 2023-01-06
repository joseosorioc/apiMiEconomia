package com.osorio.mieconomia.services;


import com.osorio.mieconomia.models.Detalle;
import com.osorio.mieconomia.repositories.DetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DetalleService")
public class DetalleService {

    @Autowired
    private DetalleRepository detalleRepository;


    public Detalle guardarDetalle(Detalle detalle) {
        return detalleRepository.save(detalle);
    }

    public Detalle editarDetalle(Detalle detalle) {
        Detalle detalleABuscar = obtenerDetalle(detalle.getIdDetalle());
        detalleABuscar.setCaracteristica(detalle.getCaracteristica());
        detalleABuscar.setCategoria(detalle.getCategoria());
        detalleABuscar.setFuente(detalle.getFuente());
        detalleABuscar.setComentario(detalle.getComentario());
        detalleABuscar.setFechaGeneracion(detalle.getFechaGeneracion());
        detalleABuscar.setMonto(detalle.getMonto());
        detalleABuscar.setUsuario(detalle.getUsuario());

        return detalleRepository.save(detalle);

    }

    public String eliminarDetalle(Integer id) {
        detalleRepository.deleteById(id);

        return "OK";
    }

    public Detalle obtenerDetalle(Integer id) {
        return detalleRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("No se pudo encontrar el detalle con id: " + id));
    }

    public List<Detalle> obtenerTodo() {
        return detalleRepository.findAll();
    }


}
