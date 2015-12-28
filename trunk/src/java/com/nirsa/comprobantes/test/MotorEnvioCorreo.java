/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Joel
 */
public class MotorEnvioCorreo {
    
    /**
     * @param asunto : Asunto del mensaje
     * @param mensaje  : Cuerpo del Mensaje
     * @param correoDestinatarioPara : Correos destinatarios que se encuentran en el campo Para
     * @param correoDestinatarioConCopia : Correos destinatarios que se encuentran en el campo Cc
     * @param correoDestinatarioConCopiaOculto : Correos destinatarios que se encuentran en el campo Cco
     * @return true si el envío es conforme y false si no es conforme.
     */
    
    public MotorEnvioCorreo() {
        
    }
    
    @SuppressWarnings({ "finally" })
    public static synchronized boolean enviarCorreo(String asunto, 
                                                    String mensaje, 
                                                    String correoDestinatarioPara, 
                                                    String correoDestinatarioConCopia, 
                                                    String correoDestinatarioConCopiaOculto, 
                                                    String[] archivoAdjunto) throws Exception{
        boolean envio = false;
        try {
            Properties propiedades = new Properties();
            propiedades.load(MotorEnvioCorreo.class.getClassLoader().getResourceAsStream("email.properties"));
            Session session = Session.getDefaultInstance(propiedades);
            session.setDebug(true);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(propiedades.getProperty("mail.smtp.user").trim()));
            
            if(correoDestinatarioPara != null && !correoDestinatarioPara.isEmpty())
            message.setRecipients(Message.RecipientType.TO, 
                                  InternetAddress.parse(correoDestinatarioPara));
            
            if(correoDestinatarioConCopia != null && !correoDestinatarioConCopia.isEmpty())
            message.setRecipients(Message.RecipientType.CC, 
                                  InternetAddress.parse(correoDestinatarioConCopia));
            
            if(correoDestinatarioConCopiaOculto != null && !correoDestinatarioConCopiaOculto.isEmpty())
            message.setRecipients(Message.RecipientType.BCC, 
                                  InternetAddress.parse(correoDestinatarioConCopiaOculto));

            message.setSubject(asunto);
            message.setText(mensaje);
            
            if(archivoAdjunto != null && archivoAdjunto.length>0){
                MimeMultipart multiParte = new MimeMultipart();
                for(int i=0;i<archivoAdjunto.length;i++){
                    BodyPart adjunto = new MimeBodyPart();
                    adjunto.setDataHandler(new DataHandler(new FileDataSource(archivoAdjunto[i])));
                    String fileName = archivoAdjunto[i].split("/")[archivoAdjunto.length-1];
                    adjunto.setFileName(fileName);
                    multiParte.addBodyPart(adjunto);
                }
                message.setContent(multiParte);
            }

            Transport t = session.getTransport("smtp");
            t.connect(propiedades.getProperty("mail.smtp.user").trim(), 
                      propiedades.getProperty("mail.smtp.password").trim());
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            envio = true;
        } catch (Exception e) {
            System.out.println("EXCEPTION : " + e.getMessage());
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            return envio;
        }
    }
}
