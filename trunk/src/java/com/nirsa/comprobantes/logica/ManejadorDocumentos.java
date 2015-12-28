/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.logica;

import com.nirsa.comprobantes.modelo.factura.Factura;
import com.nirsa.comprobantes.modelo.guia.GuiaRemision;
import com.nirsa.comprobantes.modelo.notacredito.NotaCredito;
import com.nirsa.comprobantes.modelo.notadebito.NotaDebito;
import com.nirsa.comprobantes.util.ArchivoUtils;
import com.nirsa.comprobantes.util.ExceptionUtils;
import com.nirsa.comprobantes.util.FormGenerales;
import com.nirsa.comprobantes.util.Mensajes;
import com.nirsa.comprobantes.util.seguridad.GenericXMLSignature;
import ec.gob.sri.comprobantes.ws.Comprobante;
import ec.gob.sri.comprobantes.ws.Mensaje;
import ec.gob.sri.comprobantes.ws.RespuestaSolicitud;
import es.mityc.firmaJava.libreria.xades.DataToSign;
import es.mityc.firmaJava.libreria.xades.EnumFormatoFirma;
import es.mityc.firmaJava.libreria.xades.XAdESSchemas;
import es.mityc.javasign.xml.refs.InternObjectToSign;
import es.mityc.javasign.xml.refs.ObjectToSign;
import java.io.File;
import java.util.List;
import org.w3c.dom.Document;

/**
 *
 * @author Rolando
 */
public class ManejadorDocumentos extends GenericXMLSignature {

    public String resourceToSing;
    public String resourceSigned;

    public String generarComprobante(Factura factura) {
        String respuestaCreacion = "";
        try {
            resourceToSing = (new StringBuilder()).append("c:").append(File.separator).append("comprobantes_electronicos").append(File.separator).append("facturas").append(File.separator).append("factura").append(factura.getInfoTributaria().getSecuencial()).append(".xml").toString();
            resourceSigned = (new StringBuilder()).append("c:").append(File.separator).append("comprobantes_electronicos").append(File.separator).append("facturas").append(File.separator).append("firmadas").append(File.separator).append("factura").append(factura.getInfoTributaria().getSecuencial()).append(".xml").toString();
            respuestaCreacion = ArchivoUtils.realizaMarshal(factura, resourceToSing);
        } catch (Exception ex) {
            factura = null;
            respuestaCreacion = ExceptionUtils.getStackTrace(ex);
        } finally {
            return respuestaCreacion;
        }
    }
    
    public String generarComprobante(GuiaRemision guiaRemision) {
        String respuestaCreacion = "";
        try {
            resourceToSing = (new StringBuilder()).append("c:").append(File.separator).append("comprobantes_electronicos").append(File.separator).append("guias").append(File.separator).append("guia").append(guiaRemision.getInfoTributaria().getSecuencial()).append(".xml").toString();
            resourceSigned = (new StringBuilder()).append("c:").append(File.separator).append("comprobantes_electronicos").append(File.separator).append("guias").append(File.separator).append("firmadas").append(File.separator).append("guia").append(guiaRemision.getInfoTributaria().getSecuencial()).append(".xml").toString();
            respuestaCreacion = ArchivoUtils.realizaMarshal(guiaRemision, resourceToSing);
        } catch (Exception ex) {
            guiaRemision = null;
            respuestaCreacion = ExceptionUtils.getStackTrace(ex);
        } finally {
            return respuestaCreacion;
        }
    }
    
    public String generarComprobante(NotaCredito notaCredito) {
        String respuestaCreacion = "";
        try {
            resourceToSing = (new StringBuilder()).append("c:").append(File.separator).append("comprobantes_electronicos").append(File.separator).append("notasCredito").append(File.separator).append("notasCredito").append(notaCredito.getInfoTributaria().getSecuencial()).append(".xml").toString();
            resourceSigned = (new StringBuilder()).append("c:").append(File.separator).append("comprobantes_electronicos").append(File.separator).append("notasCredito").append(File.separator).append("firmadas").append(File.separator).append("notasCredito").append(notaCredito.getInfoTributaria().getSecuencial()).append(".xml").toString();
            respuestaCreacion = ArchivoUtils.realizaMarshal(notaCredito, resourceToSing);
        } catch (Exception ex) {
            notaCredito = null;
            respuestaCreacion = ExceptionUtils.getStackTrace(ex);
        } finally {
            return respuestaCreacion;
        }
    }
    
    public String generarComprobante(NotaDebito notaDebito) {
        String respuestaCreacion = "";
        try {
            resourceToSing = (new StringBuilder()).append("c:").append(File.separator).append("comprobantes_electronicos").append(File.separator).append("notasDebito").append(File.separator).append("notaDebito").append(notaDebito.getInfoTributaria().getSecuencial()).append(".xml").toString();
            resourceSigned = (new StringBuilder()).append("c:").append(File.separator).append("comprobantes_electronicos").append(File.separator).append("notasDebito").append(File.separator).append("firmadas").append(File.separator).append("notaDebito").append(notaDebito.getInfoTributaria().getSecuencial()).append(".xml").toString();
            respuestaCreacion = ArchivoUtils.realizaMarshal(notaDebito, resourceToSing);
        } catch (Exception ex) {
            notaDebito = null;
            respuestaCreacion = ExceptionUtils.getStackTrace(ex);
        } finally {
            return respuestaCreacion;
        }
    }

    public String enviarComprobante() {
        StringBuilder msg = new StringBuilder();
        String estado = "";
        try {
            EnvioComprobantesWs ec = new EnvioComprobantesWs(FormGenerales.devuelveUrlWs("1", "RecepcionComprobantes"));
            RespuestaSolicitud response = ec.enviarComprobante("", new File(resourceSigned), "", "");
            estado = response.getEstado();
            msg.append("¬").append(estado).append("¬").append("").append("¬").append("").append("¬").append("").append("¬").append("");
            List<Comprobante> listaComprobantes = response.getComprobantes().getComprobante();
            if (!listaComprobantes.isEmpty()) {
                for (Comprobante comprobante : listaComprobantes) {
                    List<Mensaje> mensajes = comprobante.getMensajes().getMensaje();
                    for (Mensaje mensaje : mensajes) {
                        if (!mensaje.getMensaje().isEmpty()) {
                            msg.append("\n").append("¬").append(estado).append("¬").append(mensaje.getTipo()).append("¬").append(mensaje.getIdentificador()).append("¬").append(mensaje.getMensaje()).append("¬").append(mensaje.getInformacionAdicional());
                        }
                    }
                }
            }
            return msg.toString().trim();
        } catch (Exception e) {
            return Mensajes.obtenerMensajeErrorAsociadoAExcepcion(e);
        }
    }

    @Override
    protected DataToSign createDataToSign() {
        DataToSign dataToSign = new DataToSign();
        try {
            dataToSign.setXadesFormat(EnumFormatoFirma.XAdES_BES);
            dataToSign.setEsquema(XAdESSchemas.XAdES_132);
            dataToSign.setXMLEncoding("UTF-8");
            dataToSign.setEnveloped(true);
            dataToSign.addObject(new ObjectToSign(new InternObjectToSign("comprobante"), "Documento de ejemplo", null, "text/xml", null));
            Document docToSign = getDocument(resourceToSing);
            dataToSign.setDocument(docToSign);

        } catch (Exception ex) {
            dataToSign = null;
            ex.printStackTrace();
        } finally {
            return dataToSign;
        }
    }

    @Override
    protected String getSignatureFileName() {
        return resourceSigned;
    }

    public void firmarFactura() {
        execute();
    }

    public String getResourceSigned() {
        return resourceSigned;
    }

    public void setResourceSigned(String resourceSigned) {
        this.resourceSigned = resourceSigned;
    }

    public String getResourceToSing() {
        return resourceToSing;
    }

    public void setResourceToSing(String resourceToSing) {
        this.resourceToSing = resourceToSing;
    }
}
