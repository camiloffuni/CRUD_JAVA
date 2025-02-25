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
/**
 * Controlador REST para manejar la información de los docentes.
 * Proporciona endpoints para obtener, crear, actualizar y eliminar docentes en el sistema.
 */
@RestController
@RequestMapping("/docentes/")
public class DocentesController {

    // Servicio que contiene la lógica de negocio relacionada con los docentes
    private final DocenteServiceI docenteServiceI;

    /**
     * Constructor que inyecta el servicio de docentes.
     * Esto permite que el controlador pueda llamar a los métodos de la capa de servicio.
     */
    private DocentesController(DocenteServiceI docenteServiceI){
        this.docenteServiceI = docenteServiceI;
    }

    //Obtiene la lista de todos los docentes registrados.
    @GetMapping
    public List<Docentes> getAllDocentes(){
        return docenteServiceI.getAllDocentes();
    }

    //Busca un docente por su ID.
    @GetMapping("buscar_por_id/{idDocente}")
    public Optional<Docentes> getDocenteByIdDocente(@PathVariable("idDocente") int idDocente){
        return docenteServiceI.getDocenteByIdDocente(idDocente);
    }

    //Busca un docente por su nombre.
    @GetMapping("buscar_por_docente{nombreDocente}")
    public Optional<Docentes> getDocenteByNombreDocente(@RequestParam("nombreDocente") String nombreDocente){
        return docenteServiceI.getDocenteByNombreDocente(nombreDocente);
    }

    //Crea un nuevo docente en la base de datos.
    @PostMapping("crearDocente")
    public ResponseEntity<Docentes> saveDocente(@RequestBody DocentesDTO docentesDTO){
        Docentes docente = docenteServiceI.saveDocente(docentesDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(docente);
    }

    //Actualiza la información de un docente basado en su ID.
    @PutMapping("actualizar_docente/{idDocente}")
    public ResponseEntity<Optional<Docentes>> updateDocente(@PathVariable("idDocente") int idDocente, @RequestBody DocentesDTO docentesDTO){
        Optional<Docentes> docente = docenteServiceI.updateDocente(idDocente, docentesDTO);
        return ResponseEntity.status(HttpStatus.OK).body(docente);
    }

    //Elimina un docente de la base de datos por su ID.
    @DeleteMapping("eliminar_docente/{idDocente}")
    public ResponseEntity<Void> deleleteDocente(@PathVariable("idDocente") int idDocente){
        docenteServiceI.deleteDocente(idDocente);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}