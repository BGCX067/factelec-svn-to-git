/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.ws.modelo.notacredito;

import com.nirsa.comprobantes.ws.modelo.DetAdicionalWS;
import com.nirsa.comprobantes.ws.modelo.ImpuestoWS;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Rolando
 */
public class NotaCreditoDetalles {

    protected String codigoInterno;
    protected String codigoAdicional;
    protected String descripcion;
    protected BigDecimal cantidad;
    protected BigDecimal precioUnitario;
    protected BigDecimal descuento;
    protected BigDecimal precioTotalSinImpuesto;
    protected List<DetAdicionalWS> detallesAdicionales;
    protected List<ImpuestoWS> impuestos;

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

    public List<DetAdicionalWS> getDetallesAdicionales() {
        return detallesAdicionales;
    }

    public void setDetallesAdicionales(List<DetAdicionalWS> detallesAdicionales) {
        this.detallesAdicionales = detallesAdicionales;
    }

    public List<ImpuestoWS> getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(List<ImpuestoWS> impuestos) {
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
