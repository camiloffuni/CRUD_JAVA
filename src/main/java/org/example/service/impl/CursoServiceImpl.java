package org.example.service.impl;

import org.example.domain.Cursos;
import org.example.dto.CursosDTO;
import org.example.repository.CursosRepository;
import org.example.service.CursoServiceI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Indica que esta clase es un servicio de Spring y se gestiona como un bean
@Service
public class CursoServiceImpl implements CursoServiceI {

    private final CursosRepository cursosRepository;

    // Constructor que inyecta el repositorio de cursos, permitiendo la interacción con la base de datos.
    public CursoServiceImpl(CursosRepository  cursosRepository){
        this.cursosRepository = cursosRepository;
    }

    // Recupera y devuelve todos los cursos almacenados en la base de datos.
    @Override
    public List<Cursos> getAllCursos(){
        return cursosRepository.findAll();
    }

    // Busca un curso por su ID en la base de datos.
    @Override
    public Optional<Cursos> getCursoByIDCurso(int idCurso){
        return cursosRepository.findById(idCurso);
    }

    // Busca un curso cuyo precio coincida con el valor proporcionado.
    @Override
    public Optional<Cursos> getCursoByPrecio(double precio) {return cursosRepository.getCursoByPrecio(precio);}

    // Retorna la lista de cursos cuyo precio se encuentra en el rango especificado.
    @Override
    public List<Cursos> getCursoByPrecioBetween(double precio_min, double precio_max){
        // Convierte los precios a enteros antes de realizar la consulta.
        int precio_minimo = (int) precio_min;
        int precio_maximo = (int) precio_max;

        return cursosRepository.getCursoByPrecioBetween(precio_minimo, precio_maximo);
    }

    // Guarda el curso en la base de datos y lo devuelve
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

    // Guarda el curso actualizado en la base de datos.
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

    // Elimina el curso de la base de datos por su ID.
    @Override
    public void deleteCurso(int idCurso){
        cursosRepository.deleteById(idCurso);
    }
}
