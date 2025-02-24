package org.example.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "docentes")
public class Docentes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_docente")
    private Long idDocente;

    @Column(name = "nombre_docente", nullable = false, length = 30)
    private String nombreDocente;

    @Column(name = "apellido_docente", nullable = false, length = 30)
    private String apellidoDocente;


    @JoinColumn(name = "curso_imparte", referencedColumnName = "id_curso", nullable = false)
    private int cursoImparte;

    // 🔹 Getters y Setters
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
