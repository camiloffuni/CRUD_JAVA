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

@Service
public class DocenteServiceImpl implements DocenteServiceI {

    private final DocentesRepository docentesRepository;
    private final CursosRepository cursosRepository;

    private DocenteServiceImpl(DocentesRepository docentesRepository, CursosRepository cursosRepository){
        this.docentesRepository = docentesRepository;
        this.cursosRepository = cursosRepository;
    }

    public List<Docentes> getAllDocentes(){
        return docentesRepository.findAll();
    }

    @Override
    public Optional<Docentes> getDocenteByIdDocente(int idDocente){
        return docentesRepository.findById(idDocente);
    }

    public Optional<Docentes> getDocenteByNombreDocente(String nombreDocente){
        return docentesRepository.getByNombreDocente(nombreDocente);
    }
    @Override
    public Docentes saveDocente(DocentesDTO docentesDTO){
        Docentes docente = new Docentes();
        docente.setNombreDocente(docentesDTO.getNombreDocente());
        docente.setApellidoDocente(docentesDTO.getApellidoDocente());
        Optional<Cursos> curso = cursosRepository.findById(docentesDTO.getCursoImparte());
        docente.setCursoImparte(curso.get().getIdCurso());

        return docentesRepository.save(docente);
    }

    @Override
    public Optional<Docentes> updateDocente(int idDocente, DocentesDTO docentesDTO){
        return docentesRepository.findById(idDocente).map(docente -> {
            docente.setNombreDocente(docentesDTO.getNombreDocente());
            docente.setApellidoDocente(docentesDTO.getApellidoDocente());
            docente.setCursoImparte(docentesDTO.getCursoImparte());

            return docentesRepository.save(docente);
        });
    }

    @Override
    public void deleteDocente(int idDocente){
        docentesRepository.deleteById(idDocente);
    }
}
