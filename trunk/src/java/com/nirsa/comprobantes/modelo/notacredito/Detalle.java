/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.modelo.notacredito;

import com.nirsa.comprobantes.modelo.DetallesAdicionales;
import com.nirsa.comprobantes.modelo.Impuestos;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Rolando
 */
@XmlType(propOrder = {
    "codigoInterno", "codigoAdicional", "descripcion", "cantidad", "precioUnitario", 
    "descuento", "precioTotalSinImpuesto", "detallesAdicionales", "impuestos"})
public class Detalle {

    protected String codigoInterno;
    protected String codigoAdicional;
    protected String descripcion;
    protected BigDecimal cantidad;
    protected BigDecimal precioUnitario;
    protected BigDecimal descuento;
    protected BigDecimal precioTotalSinImpuesto;
    protected DetallesAdicionales detallesAdicionales;
    protected Impuestos impuestos;

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

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public DetallesAdicionales getDetallesAdicionales() {
        return detallesAdicionales;
    }

    public void setDetallesAdicionales(DetallesAdicionales detallesAdicionales) {
        this.detallesAdicionales = detallesAdicionales;
    }

    public Impuestos getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(Impuestos impuestos) {
        this.impuestos = impuestos;
    }

    public BigDecimal getPrecioTotalSinImpuesto() {
        return precioTotalSinImpuesto;
    }

    public void setPrecioTotalSinImpuesto(BigDecimal precioTotalSinImpuesto) {
        this.precioTotalSinImpuesto = precioTotalSinImpuesto;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
