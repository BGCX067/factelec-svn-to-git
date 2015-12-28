/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.util;

import java.io.File;

/**
 *
 * @author Rolando
 */
public class Constantes {

    public static final String JDBC_CLASS = "org.postgresql.Driver";
    public static final String URL_CONECCION = "jdbc:postgresql://nirsa";
    public static final String AES = "AES";
    public static final File ficheroLlaveDesencriptacion = new File("resources" + File.separator + "seguridad" + File.separator + "nirsa-generador-170413-1155.key");
    public static final boolean CLAVE_ACCESO_SIN_USAR = false;
    public static final boolean CLAVE_ACCESO_USADA = true;
}
