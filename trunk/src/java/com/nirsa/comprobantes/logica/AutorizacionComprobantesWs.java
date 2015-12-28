/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.logica;

import com.nirsa.comprobantes.util.FormGenerales;
import com.nirsa.comprobantes.util.Mensajes;
import ec.gob.sri.comprobantes.ws.aut.Autorizacion;
import ec.gob.sri.comprobantes.ws.aut.AutorizacionComprobantes;
import ec.gob.sri.comprobantes.ws.aut.AutorizacionComprobantesService;
import ec.gob.sri.comprobantes.ws.aut.Mensaje;
import ec.gob.sri.comprobantes.ws.aut.RespuestaComprobante;
import java.net.URL;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.namespace.QName;

/**
 *
 * @author Rolando
 */
public class AutorizacionComprobantesWs {

    private AutorizacionComprobantesService service;
    public static final String ESTADO_AUTORIZADO = "AUTORIZADO";
    public static final String ESTADO_NO_AUTORIZADO = "NO AUTORIZADO";

    public AutorizacionComprobantesWs(String wsdlLocation) {
        try {
            service = new AutorizacionComprobantesService(new URL(wsdlLocation), new QName("http://ec.gob.sri.ws.autorizacion", "AutorizacionComprobantesService"));
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Se ha producido un error ", 0);
        }
    }

    public RespuestaComprobante llamadaWSAutorizacionInd(String claveDeAcceso) {
        RespuestaComprobante response = null;
        try {
            AutorizacionComprobantes port = service.getAutorizacionComprobantesPort();
            response = port.autorizacionComprobante(claveDeAcceso);
        } catch (Exception e) {
            e.printStackTrace();
            return response;
        }
        return response;
    }

    public static String autorizarComprobanteIndividual(String claveDeAcceso, String nombreArchivo, String tipoAmbiente) {
        StringBuilder mensaje = new StringBuilder();
        try {
            String dirAutorizados = "";
            String dirNoAutorizados = "";
            RespuestaComprobante respuesta = null;
            int i = 0;
            do {
                if (i >= 5) {
                    break;
                }
                respuesta = (new AutorizacionComprobantesWs(FormGenerales.devuelveUrlWs("1", "AutorizacionComprobantes"))).llamadaWSAutorizacionInd(claveDeAcceso);
                if (!respuesta.getAutorizaciones().getAutorizacion().isEmpty()) {
                    break;
                }
                Thread.currentThread();
                Thread.sleep(300L);
                i++;
            } while (true);
            if (respuesta != null) {
                List<Autorizacion> listaAutorizaciones = respuesta.getAutorizaciones().getAutorizacion();
                i = 0;
                for (Autorizacion autorizacion : listaAutorizaciones) {
                    String estado = autorizacion.getEstado();
                    if (i == 0 && autorizacion.getEstado().toUpperCase().equals("AUTORIZADO")) {
                        mensaje.append("¬").append(estado).append("¬").append(autorizacion.getNumeroAutorizacion()).append("¬").append("").append("¬").append("").append("¬").append("");
                    } else if (autorizacion.getEstado().toUpperCase().equals("NO AUTORIZADO")) {
                        List<Mensaje> mensajes = autorizacion.getMensajes().getMensaje();
                        for (Mensaje m : mensajes) {
                            mensaje.append("\n").append("¬").append(estado).append("¬").append(m.getTipo()).append("¬").append(m.getIdentificador()).append("¬").append(m.getMensaje()).append("¬").append(m.getInformacionAdicional());
                        }
                    }
                }
            } else if (respuesta == null || respuesta.getAutorizaciones().getAutorizacion().isEmpty()) {
                mensaje.append("¬").append("SIN CONEXIÓN").append("¬").append("ERROR").append("¬").append("TRANSMITIDO SIN RESPUESTA").append("¬").append("Ha ocurrido un error en el proceso de la Autorizaci\363n, por lo que se traslado el archivo a la carpeta de: transmitidosSinRespuesta").append("¬").append("");
            }
            return mensaje.toString();
        } catch (Exception ex) {
            return Mensajes.obtenerMensajeErrorAsociadoAExcepcion(ex);
        }
    }
}
