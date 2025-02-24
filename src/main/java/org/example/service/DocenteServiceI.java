package org.example.service;

import org.example.domain.Cursos;
import org.example.domain.Docentes;
import org.example.dto.CursosDTO;
import org.example.dto.DocentesDTO;

import java.util.List;
import java.util.Optional;

public interface DocenteServiceI {
    List<Docentes> getAllDocentes();
    Optional<Docentes> getDocenteByIdDocente(int idDocente);
    Optional<Docentes> getDocenteByNombreDocente(String nombreDocente);
    Docentes saveDocente(DocentesDTO docentesDTO);
    Optional<Docentes> updateDocente(int idDocente, DocentesDTO docentesDTO);
    void deleteDocente(int idDocente);
}
