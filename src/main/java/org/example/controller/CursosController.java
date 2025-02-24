package org.example.controller;

import org.example.domain.Cursos;
import org.example.dto.CursosDTO;
import org.example.service.CursoServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos/")
public class CursosController {

    private final CursoServiceI cursoServiceI;

    private CursosController(CursoServiceI cursoServiceI){
        this.cursoServiceI = cursoServiceI;
    }

    @GetMapping
    public List<Cursos> getAllCursos(){
        return cursoServiceI.getAllCursos();
    }

    @GetMapping("{idCurso}")
    public Optional<Cursos> getCursoByIdCurso(@PathVariable("idCurso") int idCurso){
        return cursoServiceI.getCursoByIDCurso(idCurso);
    }

    @GetMapping("{precio}")
    public Optional<Cursos> getCursoByPrecio(@RequestParam("precio") float precio ){
        return cursoServiceI.getCursoByPrecio(precio);
    }

    @GetMapping("buscar_entre_precios/")
    public ResponseEntity<List<Cursos>> getCursoByPrecioBetween(@RequestParam("precio_min") double precio_min, @RequestParam("precio_max") double precio_max ){
        List<Cursos> cursos = cursoServiceI.getCursoByPrecioBetween(precio_min, precio_max);
        return ResponseEntity.status(HttpStatus.OK).body(cursos);
    }


    @PostMapping
    public ResponseEntity<Cursos> saveCurso(@RequestBody CursosDTO cursosDTO){
        Cursos curso = cursoServiceI.saveCurso(cursosDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(curso);
    }

    @PutMapping("{idCurso}")
    public ResponseEntity<Optional<Cursos>> updateCurso(@PathVariable("idCurso") int idCurso, @RequestBody CursosDTO cursosDTO){
        Optional<Cursos> curso = cursoServiceI.updateCurso(idCurso, cursosDTO);
        return ResponseEntity.status(HttpStatus.OK).body(curso);
    }

    @DeleteMapping("{idCurso}")
    public ResponseEntity<Void> deleleteCurso(@PathVariable("idCurso") int idCurso){
        cursoServiceI.deleteCurso(idCurso);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
