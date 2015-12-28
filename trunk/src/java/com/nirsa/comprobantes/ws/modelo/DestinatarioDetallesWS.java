/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.ws.modelo;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Rolando
 */
public class DestinatarioDetallesWS {

    protected String codigoInterno;
    protected String codigoAdicional;
    protected String descripcion;
    protected BigDecimal cantidad;
    protected List<DetAdicionalWS> listaDetallesAdicionales;

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigoAdicional() {
        return codigoAdicional;
    }

    public void setCodigoAdicional(String codigoAdicional) {
        this.codigoAdicional = codigoAdicional;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<DetAdicionalWS> getListaDetallesAdicionales() {
        return listaDetallesAdicionales;
    }

    public void setListaDetallesAdicionales(List<DetAdicionalWS> listaDetallesAdicionales) {
        this.listaDetallesAdicionales = listaDetallesAdicionales;
    }
}
