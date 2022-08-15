package com.osorio.mieconomia.services;

import com.osorio.mieconomia.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.osorio.mieconomia.models.Usuario;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;


@Service("UsuarioService")
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private static Logger logger = Logger.getLogger("Logger");

    public Usuario guardar(Usuario usuario)
    {
        return  usuarioRepository.save(usuario);
    }

    public Usuario editar(Usuario usuario)
    {
        Usuario usuarioAEditar = usuarioRepository.findById(usuario.getIdUsuario()).get();
        usuarioAEditar.setNombres(usuario.getNombres());
        usuarioAEditar.setPrimerApellido(usuario.getPrimerApellido());
        usuarioAEditar.setSegundoApellido(usuario.getSegundoApellido());
        usuarioAEditar.setSalario(usuario.getSalario());
        usuarioAEditar.setFechaNacimiento(usuario.getFechaNacimiento());

        return usuarioRepository.save(usuarioAEditar);
    }

    public void eliminar(Integer id)
    {
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> obtenerTodos()
    {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuario(Integer id)
    {
        return usuarioRepository
                .findById(id)
                .orElseThrow( () -> new NullPointerException("No se encontró usuario con id: " +  id));
    }


}
