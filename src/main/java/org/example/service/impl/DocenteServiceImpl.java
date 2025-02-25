package org.example.service.impl;

import org.example.domain.Cursos;
import org.example.domain.Docentes;
import org.example.dto.CursosDTO;
import org.example.dto.DocentesDTO;
import org.example.repository.CursosRepository;
import org.example.repository.DocentesRepository;
import org.example.service.DocenteServiceI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Indica que esta clase es un servicio de Spring y será manejada por el contenedor de Spring.
@Service
public class DocenteServiceImpl implements DocenteServiceI {

    private final DocentesRepository docentesRepository;
    private final CursosRepository cursosRepository;

    // Constructor que inyecta los repositorios, permitiendo interactuar con la base de datos.
    private DocenteServiceImpl(DocentesRepository docentesRepository, CursosRepository cursosRepository){
        this.docentesRepository = docentesRepository;
        this.cursosRepository = cursosRepository;
    }

    // Recupera y devuelve todos los docentes almacenados en la base de datos.
    public List<Docentes> getAllDocentes(){
        return docentesRepository.findAll();
    }

    // Busca un docente por su ID en la base de datos y lo devuelve si existe.
    @Override
    public Optional<Docentes> getDocenteByIdDocente(int idDocente){
        return docentesRepository.findById(idDocente);
    }

    // Busca un docente por su nombre y lo devuelve si existe.
    @Override
    public Optional<Docentes> getDocenteByNombreDocente(String nombreDocente){
        return docentesRepository.getByNombreDocente(nombreDocente);
    }

    // Guarda el docente en la base de datos y lo devuelve.
    @Override
    public Docentes saveDocente(DocentesDTO docentesDTO){
        Docentes docente = new Docentes();
        docente.setNombreDocente(docentesDTO.getNombreDocente());
        docente.setApellidoDocente(docentesDTO.getApellidoDocente());
        Optional<Cursos> curso = cursosRepository.findById(docentesDTO.getCursoImparte());
        docente.setCursoImparte(curso.get().getIdCurso());

        return docentesRepository.save(docente);
    }

    // Guarda el docente actualizado en la base de datos.
    @Override
    public Optional<Docentes> updateDocente(int idDocente, DocentesDTO docentesDTO){
        return docentesRepository.findById(idDocente).map(docente -> {
            docente.setNombreDocente(docentesDTO.getNombreDocente());
            docente.setApellidoDocente(docentesDTO.getApellidoDocente());
            docente.setCursoImparte(docentesDTO.getCursoImparte());

            return docentesRepository.save(docente);
        });
    }

    // Elimina el docente de la base de datos por su ID.
    @Override
    public void deleteDocente(int idDocente){
        docentesRepository.deleteById(idDocente);
    }
}
