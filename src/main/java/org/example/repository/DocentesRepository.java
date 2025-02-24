package org.example.repository;

import org.example.domain.Docentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocentesRepository extends JpaRepository<Docentes, Integer> {
    Optional<Docentes> getByNombreDocente(String nombreDocente);
}
