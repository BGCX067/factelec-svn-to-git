/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.util.xml;

import com.nirsa.comprobantes.modelo.factura.Factura;
import com.nirsa.comprobantes.modelo.guia.GuiaRemision;
import com.nirsa.comprobantes.modelo.notacredito.NotaCredito;
import com.nirsa.comprobantes.modelo.notadebito.NotaDebito;
import com.nirsa.comprobantes.modelo.retencion.ComprobanteRetencion;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Rolando
 */
public class Java2XML {

    public Java2XML() {
    }

    public static String marshalFactura(Factura comprobante, String pathArchivoSalida) {
        String respuesta = null;
        try {
            JAXBContext context = JAXBContext.newInstance(new Class[]{Factura.class});
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty("jaxb.encoding", "UTF-8");
            marshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(pathArchivoSalida), "UTF-8");
            marshaller.marshal(comprobante, out);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }
        return respuesta;
    }

    public static String marshalGuiaRemision(GuiaRemision comprobante, String pathArchivoSalida) {
        String respuesta = null;
        try {
            JAXBContext context = JAXBContext.newInstance(new Class[]{GuiaRemision.class});
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty("jaxb.encoding", "UTF-8");
            marshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(pathArchivoSalida), "UTF-8");
            marshaller.marshal(comprobante, out);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }
        return respuesta;
    }

    public static String marshalComprobanteRetencion(ComprobanteRetencion comprobante, String pathArchivoSalida) {
        String respuesta = null;
        try {
            JAXBContext context = JAXBContext.newInstance(new Class[]{
                        ComprobanteRetencion.class
                    });
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty("jaxb.encoding", "UTF-8");
            marshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(pathArchivoSalida), "UTF-8");
            marshaller.marshal(comprobante, out);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }
        return respuesta;
    }

    public static String marshalNotaDeCredito(NotaCredito comprobante, String pathArchivoSalida) {
        String respuesta = null;
        try {
            JAXBContext context = JAXBContext.newInstance(new Class[]{
                        NotaCredito.class
                    });
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty("jaxb.encoding", "UTF-8");
            marshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(pathArchivoSalida), "UTF-8");
            marshaller.marshal(comprobante, out);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }
        return respuesta;
    }

    public static String marshalNotaDeDebito(NotaDebito comprobante, String pathArchivoSalida) {
        String respuesta = null;
        try {
            JAXBContext context = JAXBContext.newInstance(new Class[]{NotaDebito.class
                    });
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty("jaxb.encoding", "UTF-8");
            marshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(pathArchivoSalida), "UTF-8");
            marshaller.marshal(comprobante, out);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }
        return respuesta;
    }
}
