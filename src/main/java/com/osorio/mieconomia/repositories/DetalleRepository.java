package com.osorio.mieconomia.repositories;

import com.osorio.mieconomia.models.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("DetalleRepository")
public interface DetalleRepository extends JpaRepository<Detalle, Integer> {
}
