/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.util;

import com.nirsa.comprobantes.util.seguridad.Encriptador;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author Rolando
 */
public class SQLUtil {

    private static String sqlIp;
    private static String sqlClave;
    private static String sqlUsuario;
    private static String sqlBaseDatos;

    static {
        InputStream is = null;
        Properties prop = new Properties();
        try {
            is = new FileInputStream("resources" + File.separator + "seguridad" + File.separator + "conexion.properties");
            prop.load(is);
            sqlIp = prop.getProperty("sql.ip");
            sqlClave = prop.getProperty("sql.clave");
            sqlUsuario = prop.getProperty("sql.usuario");
            sqlBaseDatos = prop.getProperty("sql.basededatos");
            is.close();
        } catch (Exception e) {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static Connection obtenerConexionJDBC() {
        Connection conexion = null;
        try {
            Class.forName(Constantes.JDBC_CLASS);
            conexion = DriverManager.getConnection("jdbc:postgresql://" + sqlIp + "/" + sqlBaseDatos + "?" + "user=" + Encriptador.desencriptar(sqlUsuario, Constantes.ficheroLlaveDesencriptacion) + "&password=" + Encriptador.desencriptar(sqlClave, Constantes.ficheroLlaveDesencriptacion));
        } catch (Exception e) {
            e.printStackTrace();
            conexion = null;
        } finally {
            return conexion;
        }
    }

    public static void cerrarConexionesBaseDatos(Connection conexion, Statement sentencia, ResultSet resultado) {
        if (resultado != null) {
            try {
                resultado.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (sentencia != null) {
            try {
                sentencia.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conexion != null) {
            try {
                conexion.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
