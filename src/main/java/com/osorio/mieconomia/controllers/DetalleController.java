package com.osorio.mieconomia.controllers;


import com.osorio.developer.commons.models.Detalle;
import com.osorio.mieconomia.services.DetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/detalle")
public class DetalleController {

    @Autowired
    @Qualifier("DetalleService")
    private DetalleService detalleService;

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Detalle guardarDetalle(@RequestBody Detalle detalle) {
        return detalleService.guardarDetalle(detalle);
    }

    @RequestMapping(value = "/editar", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Detalle editarDetalle(@RequestBody Detalle detalle) {
        return detalleService.editarDetalle(detalle);
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public String eliminarDetalle(@PathVariable(value = "id") Integer id) {
        return detalleService.eliminarDetalle(id);
    }

    @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Detalle buscarDetalle(@PathVariable Integer id) {
        return detalleService.obtenerDetalle(id);
    }

    @RequestMapping(value = "/detalles", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Detalle> listarDetalles() {
        return detalleService.obtenerTodo();
    }


}
