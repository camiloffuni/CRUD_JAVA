package org.example.controller;

import org.example.domain.Cursos;
import org.example.domain.Docentes;
import org.example.dto.CursosDTO;
import org.example.dto.DocentesDTO;
import org.example.service.DocenteServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/docentes/")
public class DocentesController {

    private final DocenteServiceI docenteServiceI;

    private DocentesController(DocenteServiceI docenteServiceI){
        this.docenteServiceI = docenteServiceI;
    }

    @GetMapping
    public List<Docentes> getAllDocentes(){
        return docenteServiceI.getAllDocentes();
    }

    @GetMapping("{idDocente}")
    public Optional<Docentes> getDocenteByIdDocente(@PathVariable("idDocente") int idDocente){
        return docenteServiceI.getDocenteByIdDocente(idDocente);
    }

    @GetMapping("buscar{nombreDocente}")
    public Optional<Docentes> getDocenteByNombreDocente(@RequestParam("nombreDocente") String nombreDocente){
        return docenteServiceI.getDocenteByNombreDocente(nombreDocente);
    }

    @PostMapping
    public ResponseEntity<Docentes> saveDocente(@RequestBody DocentesDTO docentesDTO){
        Docentes docente = docenteServiceI.saveDocente(docentesDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(docente);
    }

    @PutMapping("{idDocente}")
    public ResponseEntity<Optional<Docentes>> updateDocente(@PathVariable("idDocente") int idDocente, @RequestBody DocentesDTO docentesDTO){
        Optional<Docentes> docente = docenteServiceI.updateDocente(idDocente, docentesDTO);
        return ResponseEntity.status(HttpStatus.OK).body(docente);
    }

    @DeleteMapping("{idDocente}")
    public ResponseEntity<Void> deleleteDocente(@PathVariable("idDocente") int idDocente){
        docenteServiceI.deleteDocente(idDocente);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
