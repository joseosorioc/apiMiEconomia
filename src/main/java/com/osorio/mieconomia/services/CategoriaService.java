package com.osorio.mieconomia.services;


import com.osorio.mieconomia.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.osorio.mieconomia.models.Categoria;

import java.util.List;


@Service("CategoriaService")
public class CategoriaService  {

    @Autowired
    private CategoriaRepository categoriaRepository;


    // Guardar Categoria
    public Categoria guardarCategoria(Categoria categoria)
    {
        return categoriaRepository.save(categoria);
    }

    public Categoria editarCategoria(Categoria categoria)
    {
        Categoria categoriaAEditar = categoriaRepository
                .findById(categoria.getIdCategoria())
                .orElseThrow( () -> new
                        NullPointerException("No se encontró la categoria con el id: " +  categoria.getIdCategoria()));

        categoriaAEditar.setNombre(categoria.getNombre());
        categoriaAEditar.setDescripcion(categoria.getDescripcion());
       return  categoriaRepository.save(categoriaAEditar);
    }

    public Categoria buscarCategoriaPorId(Integer id )
    {
        return categoriaRepository
                .findById(id)
                .orElseThrow(() -> new NullPointerException("No se encontró la categoria con el id: " +  id));
    }

    public String eliminarCategoriaPorID(Integer id)
    {
        categoriaRepository.deleteById(id);
        return "OK";
    }

    public List<Categoria> obtenerTodo()
    {
        return categoriaRepository.findAll();
    }





}
