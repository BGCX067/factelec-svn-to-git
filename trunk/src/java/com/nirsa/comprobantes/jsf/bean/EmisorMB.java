/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.jsf.bean;

import com.nirsa.comprobantes.persistencia.bean.Emisor;
import com.nirsa.comprobantes.persistencia.dao.hibernate.EmisorDaoHibernate;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Rolando
 */
@ManagedBean
@ViewScoped
public class EmisorMB {

    private String ruc;
    private String razonSocial;
    private String nombreComercial;
    private String direccionMatriz;
    private String direccionEstablecimiento;
    private String numeroResolucionContribuyenteEspecial;
    private String rutaRutaLogo;
    private String tiempoEspera;
    private String rutaFirmaDigital;
    private String obligadoLlevarContabilidad;

    /** Creates a new instance of EmisorMB */
    public EmisorMB() {
    }

    public String getDireccionEstablecimiento() {
        return direccionEstablecimiento;
    }

    public void setDireccionEstablecimiento(String direccionEstablecimiento) {
        this.direccionEstablecimiento = direccionEstablecimiento;
    }

    public String getDireccionMatriz() {
        return direccionMatriz;
    }

    public void setDireccionMatriz(String direccionMatriz) {
        this.direccionMatriz = direccionMatriz;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNumeroResolucionContribuyenteEspecial() {
        return numeroResolucionContribuyenteEspecial;
    }

    public void setNumeroResolucionContribuyenteEspecial(String numeroResolucionContribuyenteEspecial) {
        this.numeroResolucionContribuyenteEspecial = numeroResolucionContribuyenteEspecial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRutaFirmaDigital() {
        return rutaFirmaDigital;
    }

    public void setRutaFirmaDigital(String rutaFirmaDigital) {
        this.rutaFirmaDigital = rutaFirmaDigital;
    }

    public String getRutaRutaLogo() {
        return rutaRutaLogo;
    }

    public void setRutaRutaLogo(String rutaRutaLogo) {
        this.rutaRutaLogo = rutaRutaLogo;
    }

    public String getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(String tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public String getObligadoLlevarContabilidad() {
        return obligadoLlevarContabilidad;
    }

    public void setObligadoLlevarContabilidad(String obligadoLlevarContabilidad) {
        this.obligadoLlevarContabilidad = obligadoLlevarContabilidad;
    }

    public void guardarEmisor() {
        EmisorDaoHibernate dao = new EmisorDaoHibernate();
        Emisor emisor = new Emisor();
        emisor.setEmisorRuc(ruc);
        emisor.setEmisorRazonSocial(razonSocial);
        emisor.setEmisorNombreComercial(nombreComercial);
        emisor.setEmisorDireccionMatriz(direccionMatriz);
        emisor.setEmisorDireccionEstablecimiento(direccionEstablecimiento);
        emisor.setEmisorNumeroResolucionContribuyenteEspecial(numeroResolucionContribuyenteEspecial);
        emisor.setEmisorObligadoLlevarContabilidad(obligadoLlevarContabilidad);
        emisor.setEmisorLogo(null);
        int valorTiempoEspera = 0;
        try {
            valorTiempoEspera = Integer.parseInt(tiempoEspera);
        } catch (Exception e) {
            valorTiempoEspera = 0;
        }
        emisor.setEmisorTiempoEspera(valorTiempoEspera);
        emisor.setEmisorRutaFirmaDigital(rutaFirmaDigital);
        emisor.setEmisorEstaActivo('Y');
        dao.save(emisor);
    }
}
