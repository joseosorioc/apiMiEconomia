package com.osorio.mieconomia.services;

import com.osorio.developer.commons.models.Detalle;
import com.osorio.mieconomia.mappers.DetalleMapper;
import com.osorio.mieconomia.repositories.DetalleRepository;
import com.osorio.mieconomia.response.DetalleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service("DetalleService")
public class DetalleService {


    private final DetalleRepository detalleRepository;

    private final DetalleMapper detalleMapper;

    @Autowired
    public DetalleService(DetalleRepository detalleRepository, DetalleMapper detalleMapper) {
        this.detalleRepository = detalleRepository;
        this.detalleMapper = detalleMapper;
    }

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

    public Page<DetalleResponse> obtenerTodo(Pageable pageable) {
        List<DetalleResponse> detalleResponseList =  detalleRepository.findAll(pageable)
                .stream()
                .map(detalleMapper :: detalleToDetalleResponse )
                .collect(Collectors.toList());


        return new PageImpl<>(detalleResponseList);

    }



}
