package com.osorio.mieconomia.services;

import com.osorio.developer.commons.models.Fuente;
import com.osorio.mieconomia.repositories.FuenteRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Getter
@Setter
@Service("FuenteService")
public class FuenteService {


    private final FuenteRepository fuenteRepository;

    @Autowired
    public FuenteService(FuenteRepository fuenteRepository) {
        this.fuenteRepository = fuenteRepository;
    }

    // Metodo guardar para guardar fuentes
    public Fuente guardarFuente(Fuente fuente )
    {
        return fuenteRepository.save(fuente);
    }

    public Fuente editarFuente(Fuente fuente)
    {
        Fuente fuenteAEditar = obtenerFuente(fuente.getIdFuente());

        fuenteAEditar.setNombre(fuente.getNombre());

        return fuenteRepository.save(fuenteAEditar);
    }

    public String eliminarFuente(Integer id)
    {
        fuenteRepository.deleteById(id);
        return "OK";
    }

    public Fuente obtenerFuente(Integer id)
    {
        return fuenteRepository
                .findById(id)
                .orElseThrow(() -> new NullPointerException("Ocurrió un error al buscar la fuente con id " + id)) ;
    }

    public List<Fuente> obtenerTodo()
    {
        return fuenteRepository.findAll();
    }



}
