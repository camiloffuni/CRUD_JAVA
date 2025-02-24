package org.example.service.impl;

import org.example.domain.Cursos;
import org.example.dto.CursosDTO;
import org.example.repository.CursosRepository;
import org.example.service.CursoServiceI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoServiceI {

    private final CursosRepository cursosRepository;

    public CursoServiceImpl(CursosRepository  cursosRepository){
        this.cursosRepository = cursosRepository;
    }

    @Override
    public List<Cursos> getAllCursos(){
        return cursosRepository.findAll();
    }

    @Override
    public Optional<Cursos> getCursoByIDCurso(int idCurso){
        return cursosRepository.findById(idCurso);
    }

    @Override
    public Optional<Cursos> getCursoByPrecio(double precio) {return cursosRepository.getCursoByPrecio(precio);}

    @Override
    public List<Cursos> getCursoByPrecioBetween(double precio_min, double precio_max){
        System.out.println(precio_min);
        System.out.println(precio_max);
        int precio_minimo = (int) precio_min;
        int precio_maximo = (int) precio_max;
        System.out.println(precio_minimo);
        System.out.println(precio_maximo);
        return cursosRepository.getCursoByPrecioBetween(precio_minimo, precio_maximo);
    }

    @Override
    public Cursos saveCurso(CursosDTO cursosDTO){
        System.out.println(cursosDTO.getPrecio());
        Cursos curso = new Cursos();
        curso.setNombreCurso(cursosDTO.getNombreCurso());
        curso.setDescripcionCurso(cursosDTO.getDescripcionCurso());
        curso.setFechaInicio(cursosDTO.getFechaInicio());
        curso.setFechaFin(cursosDTO.getFechaFin());
        curso.setActivo(cursosDTO.isActivo());
        curso.setprecio(cursosDTO.getPrecio());

        return cursosRepository.save(curso);
    }

    @Override
    public Optional<Cursos> updateCurso(int idCurso, CursosDTO cursosDTO){
        return cursosRepository.findById(idCurso).map(curso -> {
            curso.setNombreCurso(cursosDTO.getNombreCurso());
            curso.setDescripcionCurso(cursosDTO.getDescripcionCurso());
            curso.setFechaInicio(cursosDTO.getFechaInicio());
            curso.setFechaFin(cursosDTO.getFechaFin());
            curso.setActivo(cursosDTO.isActivo());

            return cursosRepository.save(curso);
        });
    }

    @Override
    public void deleteCurso(int idCurso){
        cursosRepository.deleteById(idCurso);
    }
}
