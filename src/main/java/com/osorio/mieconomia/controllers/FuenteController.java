package com.osorio.mieconomia.controllers;



import com.osorio.developer.commons.models.Fuente;
import com.osorio.mieconomia.services.FuenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/fuente")
public class FuenteController {

    @Autowired
    @Qualifier("FuenteService")
    private FuenteService fuenteService;


    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Fuente guardarFuente(@RequestBody Fuente fuente) {
        return fuenteService.guardarFuente(fuente);
    }

    @RequestMapping(value = "/editar", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Fuente editarFuente(@RequestBody Fuente fuente) {
        return fuenteService.editarFuente(fuente);
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public String eliminarFuente(@PathVariable(value = "id") Integer id) {
        return fuenteService.eliminarFuente(id);
    }

    @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Fuente buscarFuente(@PathVariable(value = "id") Integer id) {
        return fuenteService.obtenerFuente(id);
    }

    @RequestMapping(value = "/fuentes", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Fuente> obtenerTodasLasFuentes() {
        return fuenteService.obtenerTodo();
    }


}
