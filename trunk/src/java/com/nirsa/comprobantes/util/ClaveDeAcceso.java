/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

/**
 *
 * @author Rolando
 */
public class ClaveDeAcceso {

//    public static void main(String[] args) {
//        Date date = new Date();
//        String tipoComprobante = "01";
//        String ruc = "0992746033001";
//        String ambiente = "1";
//        //El número de serie es el código del establecimiento concatenado con el del punto de emisión
//        //emisor.getCodigoEstablecimiento().concat(emisor.getCodPuntoEmision())
//        String serie = "001001";
//        String numeroComprobante = "000000117";
//        //Clave interna de 8 dígitos
//        //12345678
//        String codigoNumerico = "12345678";
//        String tipoEmision = "1";
//        System.out.println(generarClaveAcceso(date, tipoComprobante, ruc, ambiente, serie, numeroComprobante, codigoNumerico, tipoEmision));
//    }
    public static String generarClaveAcceso(Date fechaEmision, String tipoComprobante, String ruc, String ambiente, String serie, String numeroComprobante, String codigoNumerico, String tipoEmision) {
        int verificador = 0;
        if (ruc != null && ruc.length() < 13) {
            ruc = String.format("%013d", new Object[]{ruc});
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        String fecha = dateFormat.format(fechaEmision);
        StringBuilder clave = new StringBuilder(fecha);
        clave.append(tipoComprobante);
        clave.append(ruc);
        clave.append(ambiente);
        clave.append(serie);
        clave.append(numeroComprobante);
        clave.append(codigoNumerico);
        clave.append(tipoEmision);
        verificador = generarDigitoModulo11(clave.toString());
        clave.append(Integer.valueOf(verificador));
        String claveGenerada = clave.toString();
        if (clave.toString().length() != 49) {
            claveGenerada = null;
        }
        return claveGenerada;
    }

    public String generaClaveContingencia(String fechaEmision, String tipoComprobante, String clavesContigencia, String tipoEmision) throws InputMismatchException {
        int verificador = 0;
        String claveGenerada = "";
//        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
//        String fecha = dateFormat.format(fechaEmision);
        StringBuilder clave = new StringBuilder(fechaEmision);
        clave.append(tipoComprobante);
        clave.append(clavesContigencia);
        clave.append(tipoEmision);
        verificador = generarDigitoModulo11(clave.toString());
        if (verificador != 10) {
            clave.append(Integer.valueOf(verificador));
            claveGenerada = clave.toString();
        }
        if (clave.toString().length() != 49) {
            claveGenerada = null;
        }
        return claveGenerada;
    }

    public static int generarDigitoModulo11(String cadena) {
        int baseMultiplicador = 7;
//        System.out.println((new StringBuilder()).append("CADENA-->").append(cadena).toString());
        int aux[] = new int[cadena.length()];
        int multiplicador = 2;
        int total = 0;
        int verificador = 0;
        for (int i = aux.length - 1; i >= 0; i--) {
            aux[i] = Integer.parseInt((new StringBuilder()).append("").append(cadena.charAt(i)).toString());
            aux[i] = aux[i] * multiplicador;
            if (++multiplicador > baseMultiplicador) {
                multiplicador = 2;
            }
            total += aux[i];
        }

        if (total == 0 || total == 1) {
            verificador = 0;
        } else {
            verificador = 11 - total % 11 != 11 ? 11 - total % 11 : 0;
        }
        if (verificador == 10) {
            verificador = 1;
        }
        return verificador;
    }
}
