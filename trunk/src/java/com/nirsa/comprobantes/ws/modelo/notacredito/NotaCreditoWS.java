/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.ws.modelo.notacredito;

import com.nirsa.comprobantes.ws.modelo.CampoAdicionalWS;
import com.nirsa.comprobantes.ws.modelo.TotalImpuestoWS;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Rolando
 */
public class NotaCreditoWS {

    //-----------------------
    protected String id;
    protected String version;
    //-----------------------
    protected String ambiente;
    protected String tipoEmision;
    protected String razonSocial;
    protected String nombreComercial;
    protected String ruc;
    protected String claveAcceso;
    protected String codDoc;
    protected String estab;
    protected String ptoEmi;
    protected String secuencial;
    protected String dirMatriz;
    //-----------------------
    protected String fechaEmision;
    protected String dirEstablecimiento;
    protected String tipoIdentificacionComprador;
    protected String razonSocialComprador;
    protected String identificacionComprador;
    protected String contribuyenteEspecial;
    protected String obligadoContabilidad;
    protected String rise;
    protected String codDocModificado;
    protected String numDocModificado;
    protected String fechaEmisionDocSustento;
    protected BigDecimal totalSinImpuestos;
    protected BigDecimal valorModificacion;
    protected String moneda;
    protected List<TotalImpuestoWS> totalImpuesto;
    protected String motivo;
    protected List<NotaCreditoDetalles> detalle;
    protected List<CampoAdicionalWS> listaCamposAdicionales;

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    public String getCodDoc() {
        return codDoc;
    }

    public void setCodDoc(String codDoc) {
        this.codDoc = codDoc;
    }

    public String getCodDocModificado() {
        return codDocModificado;
    }

    public void setCodDocModificado(String codDocModificado) {
        this.codDocModificado = codDocModificado;
    }

    public String getContribuyenteEspecial() {
        return contribuyenteEspecial;
    }

    public void setContribuyenteEspecial(String contribuyenteEspecial) {
        this.contribuyenteEspecial = contribuyenteEspecial;
    }

    public List<NotaCreditoDetalles> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<NotaCreditoDetalles> detalle) {
        this.detalle = detalle;
    }

    public String getDirEstablecimiento() {
        return dirEstablecimiento;
    }

    public void setDirEstablecimiento(String dirEstablecimiento) {
        this.dirEstablecimiento = dirEstablecimiento;
    }

    public String getDirMatriz() {
        return dirMatriz;
    }

    public void setDirMatriz(String dirMatriz) {
        this.dirMatriz = dirMatriz;
    }

    public String getEstab() {
        return estab;
    }

    public void setEstab(String estab) {
        this.estab = estab;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getFechaEmisionDocSustento() {
        return fechaEmisionDocSustento;
    }

    public void setFechaEmisionDocSustento(String fechaEmisionDocSustento) {
        this.fechaEmisionDocSustento = fechaEmisionDocSustento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentificacionComprador() {
        return identificacionComprador;
    }

    public void setIdentificacionComprador(String identificacionComprador) {
        this.identificacionComprador = identificacionComprador;
    }

    public List<CampoAdicionalWS> getListaCamposAdicionales() {
        return listaCamposAdicionales;
    }

    public void setListaCamposAdicionales(List<CampoAdicionalWS> listaCamposAdicionales) {
        this.listaCamposAdicionales = listaCamposAdicionales;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNumDocModificado() {
        return numDocModificado;
    }

    public void setNumDocModificado(String numDocModificado) {
        this.numDocModificado = numDocModificado;
    }

    public String getObligadoContabilidad() {
        return obligadoContabilidad;
    }

    public void setObligadoContabilidad(String obligadoContabilidad) {
        this.obligadoContabilidad = obligadoContabilidad;
    }

    public String getPtoEmi() {
        return ptoEmi;
    }

    public void setPtoEmi(String ptoEmi) {
        this.ptoEmi = ptoEmi;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRazonSocialComprador() {
        return razonSocialComprador;
    }

    public void setRazonSocialComprador(String razonSocialComprador) {
        this.razonSocialComprador = razonSocialComprador;
    }

    public String getRise() {
        return rise;
    }

    public void setRise(String rise) {
        this.rise = rise;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getSecuencial() {
        return secuencial;
    }

    public void setSecuencial(String secuencial) {
        this.secuencial = secuencial;
    }

    public String getTipoEmision() {
        return tipoEmision;
    }

    public void setTipoEmision(String tipoEmision) {
        this.tipoEmision = tipoEmision;
    }

    public String getTipoIdentificacionComprador() {
        return tipoIdentificacionComprador;
    }

    public void setTipoIdentificacionComprador(String tipoIdentificacionComprador) {
        this.tipoIdentificacionComprador = tipoIdentificacionComprador;
    }

    public List<TotalImpuestoWS> getTotalImpuesto() {
        return totalImpuesto;
    }

    public void setTotalImpuesto(List<TotalImpuestoWS> totalImpuesto) {
        this.totalImpuesto = totalImpuesto;
    }

    public BigDecimal getTotalSinImpuestos() {
        return totalSinImpuestos;
    }

    public void setTotalSinImpuestos(BigDecimal totalSinImpuestos) {
        this.totalSinImpuestos = totalSinImpuestos;
    }

    public BigDecimal getValorModificacion() {
        return valorModificacion;
    }

    public void setValorModificacion(BigDecimal valorModificacion) {
        this.valorModificacion = valorModificacion;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
