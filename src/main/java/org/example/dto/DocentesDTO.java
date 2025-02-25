package org.example.dto;

// DTO para Docentes, utilizado para transferir datos entre capas sin exponer la entidad directamente.
public class DocentesDTO {
    private String nombreDocente;
    private String apellidoDocente;
    private int cursoImparte;

    public DocentesDTO(){};

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public int getCursoImparte() {
        return cursoImparte;
    }

    public void setCursoImparte(int cursoImparte) {
        this.cursoImparte = cursoImparte;
    }

    public String getApellidoDocente() {
        return apellidoDocente;
    }

    public void setApellidoDocente(String apellidoDocente) {
        this.apellidoDocente = apellidoDocente;
    }
}
