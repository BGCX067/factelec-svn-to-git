/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.modelo.retencion;

import com.nirsa.comprobantes.modelo.InfoAdicional;
import com.nirsa.comprobantes.modelo.InfoTributaria;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Rolando
 */
@XmlRootElement(name = "comprobanteRetencion")
@XmlType(propOrder = {
    "id", "version", "infoTributaria", "infoCompRetencion", "impuestos", "infoAdicional"})
public class ComprobanteRetencion {

    protected InfoTributaria infoTributaria;
    protected InfoCompRetencion infoCompRetencion;
    protected Impuestos impuestos;
    protected InfoAdicional infoAdicional;
    protected String id;
    protected String version;

    @XmlAttribute(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Impuestos getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(Impuestos impuestos) {
        this.impuestos = impuestos;
    }

    public InfoAdicional getInfoAdicional() {
        return infoAdicional;
    }

    public void setInfoAdicional(InfoAdicional infoAdicional) {
        this.infoAdicional = infoAdicional;
    }

    public InfoCompRetencion getInfoCompRetencion() {
        return infoCompRetencion;
    }

    public void setInfoCompRetencion(InfoCompRetencion infoCompRetencion) {
        this.infoCompRetencion = infoCompRetencion;
    }

    public InfoTributaria getInfoTributaria() {
        return infoTributaria;
    }

    public void setInfoTributaria(InfoTributaria infoTributaria) {
        this.infoTributaria = infoTributaria;
    }

    @XmlAttribute(name = "version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
