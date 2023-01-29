package com.osorio.mieconomia.services;


import com.osorio.developer.commons.models.Categoria;
import com.osorio.mieconomia.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service("CategoriaService")
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    // Guardar Categoria
    @Transactional
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Transactional
    public Categoria editarCategoria(Categoria categoria) {
        Categoria categoriaAEditar = categoriaRepository
                .findById(categoria.getIdCategoria())
                .orElseThrow(() -> new
                        NullPointerException("No se encontró la categoria con el id: " + categoria.getIdCategoria()));

        categoriaAEditar.setNombre(categoria.getNombre());
        categoriaAEditar.setDescripcion(categoria.getDescripcion());
        return categoriaRepository.save(categoriaAEditar);
    }


    @Transactional(readOnly = true)
    public Categoria buscarCategoriaPorId(Integer id) {
        return categoriaRepository
                .findById(id)
                .orElseThrow(() -> new NullPointerException("No se encontró la categoria con el id: " + id));
    }

    @Transactional
    public String eliminarCategoriaPorID(Integer id) {
        categoriaRepository.deleteById(id);
        return "OK";
    }


    @Transactional(readOnly = true)
    public List<Categoria> obtenerTodo() {
        return categoriaRepository.findAll( );
    }


}
