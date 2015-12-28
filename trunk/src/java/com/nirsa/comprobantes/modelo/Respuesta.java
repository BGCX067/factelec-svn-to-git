package com.nirsa.comprobantes.modelo;

import java.sql.Date;

public class Respuesta {

    private Integer codigo;
    private String claveDeAcceso;
    private String archivo;
    private String estado;
    private Date fecha;

    public Respuesta() {
    }

    public Respuesta(Integer codigo, String claveDeAcceso, String archivo, String estado, Date fecha) {
        this.codigo = codigo;
        this.claveDeAcceso = claveDeAcceso;
        this.archivo = archivo;
        this.estado = estado;
        this.fecha = fecha;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getClaveDeAcceso() {
        return claveDeAcceso;
    }

    public void setClaveDeAcceso(String claveDeAcceso) {
        this.claveDeAcceso = claveDeAcceso;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}