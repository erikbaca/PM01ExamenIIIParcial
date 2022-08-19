package com.proyecto.pm01exameniiiparcial.models;

public class Medicamentos {

    private String id;
    private String descripcion;
    private String cantidad;
    private String tiempo;
    private String periocidad;
    private String imagen;


    public Medicamentos(){

    }

    public Medicamentos(String id, String descripcion, String cantidad, String tiempo, String periocidad, String imagen) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.tiempo = tiempo;
        this.periocidad = periocidad;
        this.imagen = imagen;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getPeriocidad() {
        return periocidad;
    }

    public void setPeriocidad(String periocidad) {
        this.periocidad = periocidad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
