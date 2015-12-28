/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.util;

import com.nirsa.comprobantes.modelo.factura.Factura;
import com.nirsa.comprobantes.modelo.guia.GuiaRemision;
import com.nirsa.comprobantes.modelo.notacredito.NotaCredito;
import com.nirsa.comprobantes.modelo.notadebito.NotaDebito;
import com.nirsa.comprobantes.modelo.retencion.ComprobanteRetencion;
import com.nirsa.comprobantes.util.xml.Java2XML;
import com.nirsa.comprobantes.util.xml.ValidadorEstructuraDocumento;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Rolando
 */
public class ArchivoUtils {

    public static byte[] convertirArchivoAByteArray(File file) throws IOException {
        byte[] buffer = new byte[(int) file.length()];
        InputStream ios = null;
        try {
            ios = new FileInputStream(file);
            if (ios.read(buffer) == -1) {
                throw new IOException("EOF reached while trying to read the whole file");
            }
        } finally {
            try {
                if (ios != null) {
                    ios.close();
                }
            } catch (IOException e) {
            }
        }
        return buffer;
    }

    public static String seleccionaXsd(String tipo) {
        String nombreXsd = null;
        if (tipo.equals(TipoComprobanteEnum.FACTURA.getCode())) {
            nombreXsd = TipoComprobanteEnum.FACTURA.getXsd();
        } else if (tipo.equals(TipoComprobanteEnum.COMPROBANTE_DE_RETENCION.getCode())) {
            nombreXsd = TipoComprobanteEnum.COMPROBANTE_DE_RETENCION.getXsd();
        } else if (tipo.equals(TipoComprobanteEnum.GUIA_DE_REMISION.getCode())) {
            nombreXsd = TipoComprobanteEnum.GUIA_DE_REMISION.getXsd();
        } else if (tipo.equals(TipoComprobanteEnum.NOTA_DE_CREDITO.getCode())) {
            nombreXsd = TipoComprobanteEnum.NOTA_DE_CREDITO.getXsd();
        } else if (tipo.equals(TipoComprobanteEnum.NOTA_DE_DEBITO.getCode())) {
            nombreXsd = TipoComprobanteEnum.NOTA_DE_DEBITO.getXsd();
        } else if (tipo.equals(TipoComprobanteEnum.LOTE.getCode())) {
            nombreXsd = TipoComprobanteEnum.LOTE.getXsd();
        }
        return nombreXsd;
    }

    public static String validaArchivoXSD(String tipoComprobante, String pathArchivoXML) {
        String respuestaValidacion = null;
        try {
            ValidadorEstructuraDocumento validador = new ValidadorEstructuraDocumento();
            String nombreXsd = seleccionaXsd(tipoComprobante);
            String pathArchivoXSD = (new StringBuilder()).append("C:\\comprobantes_electronicos\\xsd\\").append(nombreXsd).toString();
            System.out.println(pathArchivoXSD);
            if (pathArchivoXML != null) {
                validador.setArchivoXML(new File(pathArchivoXML));
                validador.setArchivoXSD(new File(pathArchivoXSD));
                respuestaValidacion = validador.validacion();
            }
        } catch (Exception ex) {
            respuestaValidacion = ExceptionUtils.getStackTrace(ex);
        }
        return respuestaValidacion;
    }

    public static String realizaMarshal(Object comprobante, String pathArchivo) {
        String respuesta = null;
        if (comprobante instanceof Factura) {
            respuesta = Java2XML.marshalFactura((Factura) comprobante, pathArchivo);
        } else if (comprobante instanceof NotaDebito) {
            respuesta = Java2XML.marshalNotaDeDebito((NotaDebito) comprobante, pathArchivo);
        } else if (comprobante instanceof NotaCredito) {
            respuesta = Java2XML.marshalNotaDeCredito((NotaCredito) comprobante, pathArchivo);
        } else if (comprobante instanceof ComprobanteRetencion) {
            respuesta = Java2XML.marshalComprobanteRetencion((ComprobanteRetencion) comprobante, pathArchivo);
        } else if (comprobante instanceof GuiaRemision) {
            respuesta = Java2XML.marshalGuiaRemision((GuiaRemision) comprobante, pathArchivo);
        }
        return respuesta;
    }
//
//    public static String cargarArchivosClavesAcceso(String ruta) {
//        String resultado = "";
//        File archivoClavesAcceso = new File(ruta);
//        FileReader fr = null;
//        BufferedReader br = null;
//        ClaveAccesoDAO caDAO = new ClaveAccesoDAOImplJDBC();
//        if (archivoClavesAcceso.exists()) {
//            try {
//                fr = new FileReader(archivoClavesAcceso);
//                br = new BufferedReader(fr);
//                String linea;
//                while ((linea = br.readLine()) != null) {
//                    if (linea != null && !linea.isEmpty()) {
//                        ClaveAcceso ca = new ClaveAcceso(0L, linea, Constantes.CLAVE_ACCESO_SIN_USAR, "");
//                        caDAO.guardar(ca);
//                    }
//                }
//            } catch (Exception e) {
//                resultado = e.getMessage();
//            }
//        } else {
//            resultado = "El archivo de claves no existe en la ruta especificada";
//        }
//        return resultado;
//    }

//    public static String generarClave(Date fechaEmision, String tipoComprobante, String ruc, String ambiente, String serie, String numeroComprobante, String codigoNumerico, String tipoEmision) {
//        int verificador = 0;
//        if (ruc != null && ruc.length() < 13) {
//            ruc = String.format("%013d", new Object[]{ruc});
//        }
//        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
//        String fecha = dateFormat.format(fechaEmision);
//        StringBuilder clave = new StringBuilder(fecha);
//        clave.append(tipoComprobante);
//        clave.append(ruc);
//        clave.append(ambiente);
////        clave.append(serie);
////        clave.append(numeroComprobante);
//        clave.append(codigoNumerico);
//        clave.append(tipoEmision);
//        verificador = generarDigitoModulo11(clave.toString());
//        clave.append(Integer.valueOf(verificador));
//        String claveGenerada = clave.toString();
////        System.out.println(claveGenerada + "-" + claveGenerada.length());
//        if (clave.toString().length() != 49) {
//            claveGenerada = null;
//        }
//        return claveGenerada;
//    }


//    public static String generarClave(Date fechaEmision, String tipoComprobante, String ruc, String ambiente, String serie, String numeroComprobante, String codigoNumerico, String tipoEmision) {
//        int verificador = 0;
//        if (ruc != null && ruc.length() < 13) {
//            ruc = String.format("%013d", new Object[]{
//                        ruc
//                    });
//        }
//        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
//        String fecha = dateFormat.format(fechaEmision);
//        StringBuilder clave = new StringBuilder(fecha);
//        clave.append(tipoComprobante);
//        clave.append(ruc);
//        clave.append(ambiente);
//        clave.append(serie);
//        clave.append(numeroComprobante);
//        clave.append(codigoNumerico);
//        clave.append(tipoEmision);
//        verificador = generarDigitoModulo11(clave.toString());
//        clave.append(Integer.valueOf(verificador));
//        String claveGenerada = clave.toString();
//        if (clave.toString().length() != 49) {
//            claveGenerada = null;
//        }
//        return claveGenerada;
//    }
}