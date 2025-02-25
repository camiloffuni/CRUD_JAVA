package org.example.domain;

import jakarta.persistence.*;

/**
 * Representa la entidad "Docentes" en la base de datos.
 * Cada instancia de esta clase es un registro en la tabla "docentes".
 */
@Entity
@Table(name = "docentes")
public class Docentes {
    /**
     * Identificador único del docente.
     * Se genera automáticamente en la base de datos (AUTO_INCREMENT).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_docente")
    private Long idDocente;

    /**
     * Nombre del docente.
     * Se almacena en la columna "nombre_docente" con un límite de 30 caracteres.
     * No puede ser nulo.
     */
    @Column(name = "nombre_docente", nullable = false, length = 30)
    private String nombreDocente;

    /**
     * Apellido del docente.
     * Se almacena en la columna "apellido_docente" con un límite de 30 caracteres.
     * No puede ser nulo.
     */
    @Column(name = "apellido_docente", nullable = false, length = 30)
    private String apellidoDocente;

    /**
     * Identificador del curso que el docente imparte.
     * Se almacena en la columna "curso_imparte" y hace referencia a la clave primaria de la tabla "cursos".
     * No puede ser nulo.
     */
    @JoinColumn(name = "curso_imparte", referencedColumnName = "id_curso", nullable = false)
    private int cursoImparte;

    // 🔹 Métodos Getter y Setter para acceder y modificar los datos del docente.
    public Long getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Long idDocente) {
        this.idDocente = idDocente;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public String getApellidoDocente() {
        return apellidoDocente;
    }

    public void setApellidoDocente(String apellidoDocente) {
        this.apellidoDocente = apellidoDocente;
    }

    public int getCursoImparte() {
        return cursoImparte;
    }

    public void setCursoImparte(int cursoImparte) {
        this.cursoImparte = cursoImparte;
    }
}
