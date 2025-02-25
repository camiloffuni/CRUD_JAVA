package org.example.service;
// Interfaz que define los métodos de servicio para gestionar cursos,
// permitiendo obtener, crear, actualizar y eliminar cursos en la aplicación.
import org.example.domain.Cursos;
import org.example.dto.CursosDTO;

import java.util.List;
import java.util.Optional;

public interface CursoServiceI {
    List<Cursos> getAllCursos();
    Optional<Cursos> getCursoByIDCurso(int idCurso);
    Optional<Cursos> getCursoByPrecio(double precio);
    List<Cursos> getCursoByPrecioBetween(double precio_min, double precio_max);
    Cursos saveCurso(CursosDTO cursosDTO);
    Optional<Cursos> updateCurso(int idCurso, CursosDTO cursosDTO);
    void deleteCurso(int idCurso);
}
//