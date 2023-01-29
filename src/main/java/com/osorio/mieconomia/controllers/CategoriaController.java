package com.osorio.mieconomia.controllers;

import com.osorio.developer.commons.models.Categoria;
import com.osorio.mieconomia.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "api/v1/categoria")
public class CategoriaController {

    @Autowired
    @Qualifier("CategoriaService")
    private CategoriaService categoriaService;

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria guardarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.guardarCategoria(categoria);
    }

    @RequestMapping(value = "/editar", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Categoria editarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.editarCategoria(categoria);
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public String eliminarCategoriaPorId(@PathVariable("id") Integer id) {
        return categoriaService.eliminarCategoriaPorID(id);
    }

    @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Categoria buscarCategoriaPorId(@PathVariable("id") Integer id) {
        return categoriaService.buscarCategoriaPorId(id);
    }

    @RequestMapping(value = "/categorias", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Categoria> obtenerCategorias( @RequestParam(name = "page", defaultValue = "0") int page  ) {

        Pageable pageable = PageRequest.of(page, 2);
        return categoriaService.obtenerTodo(pageable);
    }


}
