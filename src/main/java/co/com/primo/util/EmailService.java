/*
 * PACKAGE
 */
package co.com.primo.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Clase utilitaria para el envío de Correo
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 21/08/2019
 */

public class EmailService {
    
    /** Atributos del Clase **/
    private final Properties myProperties = new Properties();
    private Session mySession;
    
    /**
     * Método de inicialización de la clase
     */
    private void init(){
        try {
            //Cargar el archivo de propiedades
            Properties myArchProperties = new Properties();
            myArchProperties.load(new FileInputStream("C:/Users/Usuario/Documents/NetBeansProjects/PrimoApp/src/main/resources/application.properties"));
            
            //Cargar las propiedades del Correo
            myProperties.put("mail.smtp.host", myArchProperties.getProperty("smtp.host"));
            myProperties.put("mail.smtp.starttls.enable", myArchProperties.getProperty("smtp.starttls.enable"));
            myProperties.put("mail.smtp.ssl.trust", myArchProperties.getProperty("smtp.ssl.trust"));
            myProperties.put("mail.smtp.port",myArchProperties.getProperty("smtp.port"));
            myProperties.put("mail.smtp.mail.sender",myArchProperties.getProperty("smtp.mail.sender"));
            myProperties.put("mail.smtp.user", myArchProperties.getProperty("smtp.user"));
            myProperties.put("mail.smtp.auth", myArchProperties.getProperty("smtp.auth"));
            myProperties.put("mail.smtp.password", myArchProperties.getProperty("smtp.password"));
            
            //Iniciar la sesión del Correo
            mySession = Session.getDefaultInstance(myProperties);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmailService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EmailService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     */
    public void enviarCorreo(String myCorreo){
        //Inicializar las propiedades
        init();
        
        try{
            //Configurar el Mensaje
            MimeMessage myMensaje = new MimeMessage(mySession);
            myMensaje.setFrom(new InternetAddress((String)myProperties.getProperty("mail.smtp.mail.sender")));
            myMensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(myCorreo));
            myMensaje.setSubject("Recuperar Contraseña Primo");
            myMensaje.setText("Reperar Contraseña en el siguiente link: ");
            
            //Transporte
            Transport myTransport = mySession.getTransport("smtp");
            myTransport.connect((String)myProperties.get("mail.smtp.user"),(String)myProperties.get("mail.smtp.password"));
            myTransport.sendMessage(myMensaje, myMensaje.getAllRecipients());
            myTransport.close();
       }
       catch(MessagingException e){
           System.err.println(e.getMessage());
       }
    }
}