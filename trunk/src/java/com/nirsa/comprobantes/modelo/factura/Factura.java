/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.modelo.factura;

import com.nirsa.comprobantes.modelo.InfoAdicional;
import com.nirsa.comprobantes.modelo.InfoTributaria;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Rolando
 */
@XmlRootElement(name = "factura")
@XmlType(propOrder = {
//    "id", "version", "infoTributaria", "infoFactura", "detalles", "infoAdicional", "retenciones"})
    "id", "version", "infoTributaria", "infoFactura", "detalles", "infoAdicional"})
public class Factura {

    protected String id;
    protected String version;
    protected InfoTributaria infoTributaria;
    protected InfoFactura infoFactura;
    protected FacturaDetalleDetalles detalles;
    protected InfoAdicional infoAdicional;
//    protected RetencionesFactura retenciones;

    public FacturaDetalleDetalles getDetalles() {
        return detalles;
    }

    public void setDetalles(FacturaDetalleDetalles detalles) {
        this.detalles = detalles;
    }

    @XmlAttribute(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public InfoAdicional getInfoAdicional() {
        return infoAdicional;
    }

    public void setInfoAdicional(InfoAdicional infoAdicional) {
        this.infoAdicional = infoAdicional;
    }

    @XmlAttribute(name = "version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public InfoTributaria getInfoTributaria() {
        return infoTributaria;
    }

    public void setInfoTributaria(InfoTributaria infoTributaria) {
        this.infoTributaria = infoTributaria;
    }

    public InfoFactura getInfoFactura() {
        return infoFactura;
    }

    public void setInfoFactura(InfoFactura infoFactura) {
        this.infoFactura = infoFactura;
    }
//    public RetencionesFactura getRetenciones() {
//        return retenciones;
//    }
//
//    public void setRetenciones(RetencionesFactura retenciones) {
//        this.retenciones = retenciones;
//    }
}
