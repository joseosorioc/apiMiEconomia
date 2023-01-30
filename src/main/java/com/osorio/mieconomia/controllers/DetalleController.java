package com.osorio.mieconomia.controllers;


import com.osorio.developer.commons.models.Detalle;
import com.osorio.mieconomia.response.DetalleResponse;
import com.osorio.mieconomia.services.DetalleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping(path = "api/v1/detalle")
public class DetalleController {

    @Autowired
    @Qualifier("DetalleService")
    private DetalleService detalleService;

    public DetalleController() {

    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Detalle guardarDetalle(@RequestBody Detalle detalle) {
     System.out.println(detalle);
        return detalleService.guardarDetalle(detalle);
    }

    @RequestMapping(value = "/editar", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public Detalle editarDetalle(@RequestBody Detalle detalle) {
        return detalleService.editarDetalle(detalle);
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public String eliminarDetalle(@PathVariable(value = "id") Integer id) {
        return detalleService.eliminarDetalle(id);
    }

    @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public Detalle buscarDetalle(@PathVariable Integer id) {
        return detalleService.obtenerDetalle(id);
    }

    @RequestMapping(value = "/detalles", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public Page<DetalleResponse> listarDetalles(Pageable pageable) {
        return detalleService.obtenerTodo(pageable);
    }


}
