/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.ws.modelo.guia;

import com.nirsa.comprobantes.ws.modelo.CampoAdicionalWS;
import java.util.List;

/**
 *
 * @author Rolando
 */
public class GuiaRemisionWS {

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
    protected String dirPartida;
    protected String razonSocialTransportista;
    protected String tipoIdentificacionTransportista;
    protected String rucTransportista;
    protected String rise;
    protected String obligadoContabilidad;
    protected String contribuyenteEspecial;
    protected String fechaIniTransporte;
    protected String fechaFinTransporte;
    protected String placa;
    //-----------------------
    private List<DestinatarioWS> listaDestinatarios;
    private List<CampoAdicionalWS> listaCamposAdicionales;

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

    public String getDirPartida() {
        return dirPartida;
    }

    public void setDirPartida(String dirPartida) {
        this.dirPartida = dirPartida;
    }

    public String getEstab() {
        return estab;
    }

    public void setEstab(String estab) {
        this.estab = estab;
    }

    public String getFechaFinTransporte() {
        return fechaFinTransporte;
    }

    public void setFechaFinTransporte(String fechaFinTransporte) {
        this.fechaFinTransporte = fechaFinTransporte;
    }

    public String getFechaIniTransporte() {
        return fechaIniTransporte;
    }

    public void setFechaIniTransporte(String fechaIniTransporte) {
        this.fechaIniTransporte = fechaIniTransporte;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<CampoAdicionalWS> getListaCamposAdicionales() {
        return listaCamposAdicionales;
    }

    public void setListaCamposAdicionales(List<CampoAdicionalWS> listaCamposAdicionales) {
        this.listaCamposAdicionales = listaCamposAdicionales;
    }

    public List<DestinatarioWS> getListaDestinatarios() {
        return listaDestinatarios;
    }

    public void setListaDestinatarios(List<DestinatarioWS> listaDestinatarios) {
        this.listaDestinatarios = listaDestinatarios;
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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

    public String getRazonSocialTransportista() {
        return razonSocialTransportista;
    }

    public void setRazonSocialTransportista(String razonSocialTransportista) {
        this.razonSocialTransportista = razonSocialTransportista;
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

    public String getRucTransportista() {
        return rucTransportista;
    }

    public void setRucTransportista(String rucTransportista) {
        this.rucTransportista = rucTransportista;
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

    public String getTipoIdentificacionTransportista() {
        return tipoIdentificacionTransportista;
    }

    public void setTipoIdentificacionTransportista(String tipoIdentificacionTransportista) {
        this.tipoIdentificacionTransportista = tipoIdentificacionTransportista;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
}
