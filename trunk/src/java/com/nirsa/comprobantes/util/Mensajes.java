/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.util;

/**
 *
 * @author Rolando
 */
public class Mensajes {

    public static final String DOCUMENTO_NULO = "El documento electrónico llegó vacío";
    public static final String CLAVE_ACCESO_MAL_FORMADA = "Ocurrió un problema al generar la clave de acceso";

    public static String obtenerMensajeError(String mensaje) {
        return "¬E¬" + mensaje;
    }

    public static String obtenerMensajeErrorAsociadoAExcepcion(Exception excepcion) {
        return "¬E¬" + ExceptionUtils.getStackTrace(excepcion);
    }
}
