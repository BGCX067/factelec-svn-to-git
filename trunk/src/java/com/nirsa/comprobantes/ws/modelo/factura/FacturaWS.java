/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.ws.modelo.factura;

import com.nirsa.comprobantes.ws.modelo.CampoAdicionalWS;
import com.nirsa.comprobantes.ws.modelo.TotalImpuestoWS;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Rolando
 */
public class FacturaWS {

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
    protected String contribuyenteEspecial;
    protected String obligadoContabilidad;
    protected String tipoIdentificacionComprador;
    protected String guiaRemision;
    protected String razonSocialComprador;
    protected String identificacionComprador;
    protected BigDecimal totalSinImpuestos;
    protected BigDecimal totalDescuento;
    private List<TotalImpuestoWS> listaTotalImpuestos;
    protected BigDecimal propina;
    protected BigDecimal importeTotal;
    protected String moneda;
    //-----------------------
    protected List<FacturaDetalleWS> listaDetalles;
    //-----------------------
    private List<CampoAdicionalWS> listaCamposAdicionales;
    //-----------------------

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

    public String getContribuyenteEspecial() {
        return contribuyenteEspecial;
    }

    public void setContribuyenteEspecial(String contribuyenteEspecial) {
        this.contribuyenteEspecial = contribuyenteEspecial;
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

    public String getGuiaRemision() {
        return guiaRemision;
    }

    public void setGuiaRemision(String guiaRemision) {
        this.guiaRemision = guiaRemision;
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

    public BigDecimal getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(BigDecimal importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getObligadoContabilidad() {
        return obligadoContabilidad;
    }

    public void setObligadoContabilidad(String obligadoContabilidad) {
        this.obligadoContabilidad = obligadoContabilidad;
    }

    public BigDecimal getPropina() {
        return propina;
    }

    public void setPropina(BigDecimal propina) {
        this.propina = propina;
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

    public BigDecimal getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(BigDecimal totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public BigDecimal getTotalSinImpuestos() {
        return totalSinImpuestos;
    }

    public void setTotalSinImpuestos(BigDecimal totalSinImpuestos) {
        this.totalSinImpuestos = totalSinImpuestos;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<CampoAdicionalWS> getListaCamposAdicionales() {
        return listaCamposAdicionales;
    }

    public void setListaCamposAdicionales(List<CampoAdicionalWS> listaCamposAdicionales) {
        this.listaCamposAdicionales = listaCamposAdicionales;
    }

    public List<FacturaDetalleWS> getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(List<FacturaDetalleWS> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }

    public List<TotalImpuestoWS> getListaTotalImpuestos() {
        return listaTotalImpuestos;
    }

    public void setListaTotalImpuestos(List<TotalImpuestoWS> listaTotalImpuestos) {
        this.listaTotalImpuestos = listaTotalImpuestos;
    }
}
