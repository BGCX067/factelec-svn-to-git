/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.modelo.guia;

import com.nirsa.comprobantes.modelo.DetallesAdicionales;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Rolando
 */
@XmlRootElement(name = "detalle")
@XmlType(propOrder = {
    "codigoInterno", "codigoAdicional", "descripcion", "cantidad", 
    "detallesAdicionales"})
public class GuiaDetallesDetalle {

    protected String codigoInterno;
    protected String codigoAdicional;
    protected String descripcion;
    protected BigDecimal cantidad;
    protected DetallesAdicionales detallesAdicionales;

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

    public DetallesAdicionales getDetallesAdicionales() {
        return detallesAdicionales;
    }

    public void setDetallesAdicionales(DetallesAdicionales detallesAdicionales) {
        this.detallesAdicionales = detallesAdicionales;
    }
}
