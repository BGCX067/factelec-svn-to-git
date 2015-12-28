/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.util.ws;

import com.nirsa.comprobantes.logica.AutorizacionComprobantesWs;
import com.nirsa.comprobantes.logica.ManejadorDocumentos;
import com.nirsa.comprobantes.modelo.factura.Factura;
import com.nirsa.comprobantes.modelo.guia.GuiaRemision;
import com.nirsa.comprobantes.modelo.notacredito.NotaCredito;
import com.nirsa.comprobantes.modelo.notadebito.NotaDebito;
import com.nirsa.comprobantes.util.ArchivoUtils;
import com.nirsa.comprobantes.util.Mensajes;

/**
 *
 * @author Rolando
 */
public class WSUtil {

    public static String emitirDocumento(Object documento) {
        String mensajes = "";
        String claveAcceso = "";
        String strResultadoGeneracion = "";
        String tipoDocumento = "";
        ManejadorDocumentos emisor = new ManejadorDocumentos();
        if (documento instanceof Factura) {
            Factura f = (Factura) documento;
            strResultadoGeneracion = emisor.generarComprobante(f);
            claveAcceso = f.getInfoTributaria().getClaveAcceso();
            tipoDocumento = f.getInfoTributaria().getCodDoc();
        } else if(documento instanceof GuiaRemision) {
            GuiaRemision g = (GuiaRemision) documento;
            strResultadoGeneracion = emisor.generarComprobante(g);
            claveAcceso = g.getInfoTributaria().getClaveAcceso();
            tipoDocumento = g.getInfoTributaria().getCodDoc();
        } else if(documento instanceof NotaCredito) {
            NotaCredito nc = (NotaCredito) documento;
            strResultadoGeneracion = emisor.generarComprobante(nc);
            claveAcceso = nc.getInfoTributaria().getClaveAcceso();
            tipoDocumento = nc.getInfoTributaria().getCodDoc();
        } else if(documento instanceof NotaDebito) {
            NotaDebito nc = (NotaDebito) documento;
            strResultadoGeneracion = emisor.generarComprobante(nc);
            claveAcceso = nc.getInfoTributaria().getClaveAcceso();
            tipoDocumento = nc.getInfoTributaria().getCodDoc();
        }
        if (strResultadoGeneracion == null) {
            String strResultadoValidacion = ArchivoUtils.validaArchivoXSD(tipoDocumento, emisor.getResourceToSing());
            if (strResultadoValidacion == null) {
                emisor.firmarFactura();
                mensajes = emisor.enviarComprobante();
                //AUTORIZACIÓN
                String mensajesRecepcion[] = mensajes.split("\n");
                if (mensajesRecepcion.length > 0) {
                    String headerRecepcion[] = mensajesRecepcion[0].split("¬");
                    if (headerRecepcion.length > 0) {
                        if (headerRecepcion[1].toUpperCase().compareTo("RECIBIDA") == 0) {
                            String strResultadoAutorizacion = AutorizacionComprobantesWs.autorizarComprobanteIndividual(claveAcceso, "", "");
                            String mensajesAutorizacion[] = strResultadoAutorizacion.split("\n");
                            if (mensajesAutorizacion.length > 0) {
                                String headerAutorizacion[] = mensajesAutorizacion[0].split("¬");
                                if (headerAutorizacion.length > 0) {
                                    mensajes = strResultadoAutorizacion;
                                }
                            }
                        }
                    }
                }
                //------------------------------------------------------
            } else {
                mensajes = Mensajes.obtenerMensajeError(strResultadoValidacion);
            }
        } else {
            mensajes = Mensajes.obtenerMensajeError(strResultadoGeneracion);
        }
        return mensajes;
    }
}
