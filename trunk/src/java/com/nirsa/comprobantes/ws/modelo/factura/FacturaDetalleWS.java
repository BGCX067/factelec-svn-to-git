/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.ws.modelo.factura;

import com.nirsa.comprobantes.ws.modelo.DetAdicionalWS;
import com.nirsa.comprobantes.ws.modelo.ImpuestoWS;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Rolando
 */
public class FacturaDetalleWS {

    protected String codigoPrincipal;
    protected String codigoAuxiliar;
    protected String descripcion;
    protected BigDecimal cantidad;
    protected BigDecimal precioUnitario;
    protected BigDecimal descuento;
    protected BigDecimal precioTotalSinImpuesto;
    protected List<DetAdicionalWS> listaDetallesAdicionales;
    protected List<ImpuestoWS> listaImpuestos;

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigoAuxiliar() {
        return codigoAuxiliar;
    }

    public void setCodigoAuxiliar(String codigoAuxiliar) {
        this.codigoAuxiliar = codigoAuxiliar;
    }

    public String getCodigoPrincipal() {
        return codigoPrincipal;
    }

    public void setCodigoPrincipal(String codigoPrincipal) {
        this.codigoPrincipal = codigoPrincipal;
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

    public List<DetAdicionalWS> getListaDetallesAdicionales() {
        return listaDetallesAdicionales;
    }

    public void setListaDetallesAdicionales(List<DetAdicionalWS> listaDetallesAdicionales) {
        this.listaDetallesAdicionales = listaDetallesAdicionales;
    }

    public List<ImpuestoWS> getListaImpuestos() {
        return listaImpuestos;
    }

    public void setListaImpuestos(List<ImpuestoWS> listaImpuestos) {
        this.listaImpuestos = listaImpuestos;
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
