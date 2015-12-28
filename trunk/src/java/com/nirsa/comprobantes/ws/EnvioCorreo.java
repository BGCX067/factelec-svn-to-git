/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.ws;

import com.nirsa.comprobantes.test.GmailSender;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Joel
 */
@WebService(serviceName = "EnvioCorreo")
public class EnvioCorreo {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "enviarCorreoElectronico")
    public String enviarCorreoElectronico(@WebParam(name = "asunto") String asunto,
            @WebParam(name = "mensaje") String mensaje,
            @WebParam(name = "correoDestinatarioPara") String correoDestinatarioPara,
            @WebParam(name = "correoDestinatarioConCopia") String correoDestinatarioConCopia,
            @WebParam(name = "correoDestinatarioConCopiaOculto") String correoDestinatarioConCopiaOculto, @WebParam(name = "archivoAdjunto") java.lang.String[] archivoAdjunto) {
        GmailSender.send();
        return "ENVIADO";
    }
}
