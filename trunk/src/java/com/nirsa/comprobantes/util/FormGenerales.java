/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.util;

/**
 *
 * @author Rolando
 */
public class FormGenerales {

    public static String devuelveUrlWs(String ambiente, String nombreServicio) {
        StringBuilder url = new StringBuilder();
        String direccionIPServicio = null;
        Proxy configuracion = null;
        try {
            configuracion = obtenerProxy();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (configuracion != null) {
            if (ambiente.equals(TipoAmbienteEnum.PRODUCCION.getCode())) {
                direccionIPServicio = configuracion.getWsProduccion();
            } else if (ambiente.equals(TipoAmbienteEnum.PRUEBAS.getCode())) {
                direccionIPServicio = configuracion.getWsPruebas();
            }
            url.append(direccionIPServicio);
            url.append("/comprobantes-electronicos-ws/");
            url.append(nombreServicio);
            url.append("?wsdl");
        }
        return url.toString();
    }

    private static Proxy obtenerProxy() {
        Proxy proxy = new Proxy();
        proxy.setWsProduccion("https://cel.sri.gob.ec");
        proxy.setWsPruebas("https://celcer.sri.gob.ec");
        return proxy;
    }
}
