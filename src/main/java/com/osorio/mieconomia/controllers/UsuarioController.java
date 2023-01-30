package com.osorio.mieconomia.controllers;

import com.osorio.developer.commons.models.Usuario;
import com.osorio.mieconomia.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "api/v1/usuario")
public class UsuarioController {

    @Autowired
    @Qualifier("UsuarioService")
    private UsuarioService usuarioService;


    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardar(usuario);
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> eliminarUsuario(@PathVariable Integer id) {
        usuarioService.eliminar(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(value = "/editar", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Usuario editarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.editar(usuario);
    }

    @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Usuario buscarUsuario(@PathVariable Integer id) {
        return usuarioService.buscarUsuario(id);
    }

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)

    @CrossOrigin
    public Page<Usuario> obtenerUsuarios(Pageable pageable) {
        return usuarioService.obtenerTodos(pageable);

    }


}
