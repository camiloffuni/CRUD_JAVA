package org.example.repository;

import org.example.domain.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// Repositorio JPA para la entidad Cursos, con métodos para buscar por precio y rango de precios.
public interface CursosRepository extends JpaRepository<Cursos, Integer> {
    Optional<Cursos> getCursoByPrecio (double precio);
    List<Cursos> getCursoByPrecioBetween(int precio_min, int precio_max);
}
