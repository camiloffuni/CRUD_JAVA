package org.example.domain;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Clase que representa la entidad "Cursos" en la base de datos.
 * Cada instancia de esta clase corresponde a un registro en la tabla "cursos".
 */
@Entity
@Table(name = "cursos")
public class Cursos {

    // Identificador único del curso, se genera automáticamente en la base de datos.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private int idCurso;

    // Nombre del curso, almacenado en la columna "nombre_curso".
    @Column(name = "nombre_curso")
    private String nombreCurso;

    // Descripción breve del curso, almacenada en la columna "descripcion_curso".
    @Column(name = "descripcion_curso")
    private String descripcionCurso;

    // Fecha de inicio del curso. Se almacena en formato DATE en la base de datos.
    @Temporal(TemporalType.DATE)  // Define cómo se almacena la fecha
    @DateTimeFormat(pattern = "yyyy-MM-dd")  // Formato esperado
    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    // Fecha de finalización del curso. También se almacena en formato DATE.
    @Temporal(TemporalType.DATE)  // Define cómo se almacena la fecha
    @DateTimeFormat(pattern = "yyyy-MM-dd")  // Formato esperado
    @Column(name = "fecha_fin")
    private Date fechaFin;

    // Indica si el curso está activo (true) o inactivo (false).
    @Column(name = "activo")
    private boolean activo;

    // Precio del curso, almacenado como un número decimal.
    @Column(name = "precio")
    private double precio;

    // Métodos getter y setter para acceder y modificar los valores de los atributos.
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getDescripcionCurso() {
        return descripcionCurso;
    }

    public void setDescripcionCurso(String descripcionCurso) {
        this.descripcionCurso = descripcionCurso;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setprecio(double precio) {
        this.precio = precio;
    }
}
