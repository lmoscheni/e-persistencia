package email;

import java.util.Date;
import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class Email {
 
	String servidorSMTP;
	String puerto;
	String usuario;
	String password;
	String destino;
	String asunto;
	String mensaje;
	
	public Email(String dest,String msj){
		
		servidorSMTP = "smtp.gmail.com";
		puerto = "587";
		usuario = "skalic.julian";
		password = "lloossjjuullii";
		destino = dest;
		asunto = "Prueba!";
		mensaje = msj;
	}
	
 public void send() {
  
 
  Properties props = new Properties();
 
  props.put("mail.debug", "true");
  props.put("mail.smtp.auth", true);
  props.put("mail.smtp.starttls.enable", true);
  props.put("mail.smtp.host", servidorSMTP);
  props.put("mail.smtp.port", puerto);
 
  Session session = Session.getInstance(props, null);
 
  try {
   MimeMessage message = new MimeMessage(session);
   message.addRecipient(Message.RecipientType.TO, new InternetAddress(
     destino));
   message.setSubject(asunto);
   message.setSentDate(new Date());
   message.setText(mensaje);
    
   Transport tr = session.getTransport("smtp");
   tr.connect(servidorSMTP, usuario, password);
   message.saveChanges();  
   tr.sendMessage(message, message.getAllRecipients());
   tr.close();
    
  } catch (MessagingException e) {
   e.printStackTrace();
  }
 }
}
