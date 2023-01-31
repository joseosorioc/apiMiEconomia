package com.osorio.mieconomia.services;

import com.osorio.developer.commons.models.Usuario;
import com.osorio.mieconomia.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service("UsuarioService")
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario editar(Usuario usuario) {
        Usuario usuarioAEditar = usuarioRepository.findById(usuario.getIdUsuario()).get();
        usuarioAEditar.setNombres(usuario.getNombres());
        usuarioAEditar.setPrimerApellido(usuario.getPrimerApellido());
        usuarioAEditar.setSegundoApellido(usuario.getSegundoApellido());
        usuarioAEditar.setSalario(usuario.getSalario());
        usuarioAEditar.setFechaNacimiento(usuario.getFechaNacimiento());

        return usuarioRepository.save(usuarioAEditar);
    }

    public void eliminar(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Page<Usuario> obtenerTodos(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    public Usuario buscarUsuario(Integer id) {
        return usuarioRepository
                .findById(id)
                .orElseThrow(() -> new NullPointerException("No se encontró usuario con id: " + id));
    }


}
