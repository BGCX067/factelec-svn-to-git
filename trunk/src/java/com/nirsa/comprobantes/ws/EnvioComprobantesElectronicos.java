/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.ws;

import com.nirsa.comprobantes.modelo.factura.Factura;
import com.nirsa.comprobantes.modelo.guia.GuiaRemision;
import com.nirsa.comprobantes.modelo.notacredito.NotaCredito;
import com.nirsa.comprobantes.util.CastingUtil;
import com.nirsa.comprobantes.util.Mensajes;
import com.nirsa.comprobantes.util.seguridad.CertificadosSSL;
import com.nirsa.comprobantes.util.ws.WSUtil;
import com.nirsa.comprobantes.ws.modelo.factura.FacturaWS;
import com.nirsa.comprobantes.ws.modelo.guia.GuiaRemisionWS;
import com.nirsa.comprobantes.ws.modelo.notacredito.NotaCreditoWS;
import com.nirsa.comprobantes.ws.modelo.notadebito.NotaDebitoWS;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Rolando
 */
@WebService(serviceName = "EnvioComprobantesElectronicos")
public class EnvioComprobantesElectronicos {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "EnvioFactura")
    public String EnvioFactura(@WebParam(name = "factura") final FacturaWS factura) {
        String mensajes = "";
        if (factura == null) {
            mensajes = Mensajes.obtenerMensajeError(Mensajes.DOCUMENTO_NULO);
        } else {
            mensajes = CertificadosSSL.instalarCertificados();
            if (mensajes != null) {
                return Mensajes.obtenerMensajeError(mensajes);
            }
            Object[] resultado = CastingUtil.convertirFacturaWSaFactura(factura);
            Factura f = (Factura) resultado[0];
            if (f != null) {
                mensajes = WSUtil.emitirDocumento(f);
            } else {
                mensajes = Mensajes.obtenerMensajeError(resultado[1].toString());
            }
        }
        return mensajes;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "EnvioGuiaRemision")
    public String EnvioGuiaRemision(@WebParam(name = "guiaRemision") final GuiaRemisionWS guiaRemision) {
        String mensajes = "";
        if (guiaRemision == null) {
            mensajes = Mensajes.obtenerMensajeError(Mensajes.DOCUMENTO_NULO);
        } else {
            mensajes = CertificadosSSL.instalarCertificados();
            if (mensajes != null) {
                return Mensajes.obtenerMensajeError(mensajes);
            }
//            ManejadorDocumentos emisor = new ManejadorDocumentos();
            Object[] resultado = CastingUtil.convertirGuiaRemisionWSaGuiaRemision(guiaRemision);
            GuiaRemision g = (GuiaRemision) resultado[0];
            if (g != null) {
                mensajes = WSUtil.emitirDocumento(g);
            } else {
                mensajes = Mensajes.obtenerMensajeError(resultado[1].toString());
            }
        }
        return mensajes;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "EnvioNotaCredito")
    public String EnvioNotaCredito(@WebParam(name = "notaCredito") final NotaCreditoWS notaCredito) {
        String mensajes = "";
        if (notaCredito == null) {
            mensajes = Mensajes.obtenerMensajeError(Mensajes.DOCUMENTO_NULO);
        } else {
            mensajes = CertificadosSSL.instalarCertificados();
            if (mensajes != null) {
                return Mensajes.obtenerMensajeError(mensajes);
            }
            Object[] resultado = CastingUtil.convertirNotaCreditoWSaNotaCredito(notaCredito);
            NotaCredito nc = (NotaCredito) resultado[0];
            if (nc != null) {
                mensajes = WSUtil.emitirDocumento(nc);
            } else {
                mensajes = Mensajes.obtenerMensajeError(resultado[1].toString());
            }
        }
        return mensajes;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "EnvioNotaDebito")
    public String EnvioNotaDebito(@WebParam(name = "notaDebito") final NotaDebitoWS notaDebito) {
        //TODO write your implementation code here:
        String mensajes = "";
        if (notaDebito == null) {
            mensajes = Mensajes.obtenerMensajeError(Mensajes.DOCUMENTO_NULO);
        } else {
            mensajes = CertificadosSSL.instalarCertificados();
            if (mensajes != null) {
                return Mensajes.obtenerMensajeError(mensajes);
            }
            Object[] resultado = CastingUtil.convertirNotaDebitoWSaDebito(notaDebito);
            NotaCredito nc = (NotaCredito) resultado[0];
            if (nc != null) {
                mensajes = WSUtil.emitirDocumento(nc);
            } else {
                mensajes = Mensajes.obtenerMensajeError(resultado[1].toString());
            }
        }
        return mensajes;
    }
}
