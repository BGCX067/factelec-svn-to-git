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
@XmlRootElement(name = "detalles")
public class FacturaDetalleDetalles {

    private List<FacturaDetalle> detalle;

    public List<FacturaDetalle> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<FacturaDetalle> detalle) {
        this.detalle = detalle;
    }
}
