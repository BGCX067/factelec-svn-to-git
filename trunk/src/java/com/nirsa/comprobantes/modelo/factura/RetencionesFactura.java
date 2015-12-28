/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.modelo.factura;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rolando
 */
//@XmlRootElement(name = "retenciones")
public class RetencionesFactura {

    private List<RetencionFactura> retencion;

    public List<RetencionFactura> getRetencion() {
        return retencion;
    }

    public void setRetencion(List<RetencionFactura> retencion) {
        this.retencion = retencion;
    }
}
