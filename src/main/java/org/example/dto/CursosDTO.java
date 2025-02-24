package org.example.dto;

import java.util.Date;

public class CursosDTO {
    private String nombreCurso;
    private String descripcionCurso;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean activo;
    private double precio;

    public CursosDTO() {}

    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getDescripcionCurso() {
        return descripcionCurso;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public void setDescripcionCurso(String descripcionCurso) {
        this.descripcionCurso = descripcionCurso;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
