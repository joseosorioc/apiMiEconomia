package com.osorio.mieconomia.repositories;


import com.osorio.developer.commons.models.Fuente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuenteRepository extends JpaRepository<Fuente,Integer> {
}
