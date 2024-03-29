package com.barbeariaapi.utis;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtils {

	public static String enviarEmail(String email) {
		 String to = email;
		    String subject = "Recuperação de Senha";
		    String msg ="<h1>Clique no link para redefinir sua senha: </h1> </br> <h3>http://easycutapp.s3-website-sa-east-1.amazonaws.com/recuperar-senha</h3>";
		    final String from ="vitordev.macedo@gmail.com";
		    final  String password ="wehpxindwjtjcevo";


		    Properties props = new Properties();  
		    props.setProperty("mail.transport.protocol", "smtp");     
		    props.setProperty("mail.host", "smtp.gmail.com");  
		    props.put("mail.smtp.auth", "true");  
		    props.put("mail.smtp.port", "465");  
		    props.put("mail.debug", "true");  
		    props.put("mail.smtp.socketFactory.port", "465");  
		    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
		    props.put("mail.smtp.socketFactory.fallback", "false");  
		   
	    Session session = Session.getDefaultInstance(props,  
	    		new javax.mail.Authenticator() {
	    	protected PasswordAuthentication getPasswordAuthentication() {  
	    		return new PasswordAuthentication(from,password);  
	    	}  
	    });

	    try {

	    	//session.setDebug(true);  
	    	   Transport transport = session.getTransport();  
	    	   InternetAddress addressFrom = new InternetAddress(from);  

	    	   MimeMessage message = new MimeMessage(session);  
	    	   message.setSender(addressFrom);  
	    	   message.setSubject(subject);  
	    	   message.setContent(msg, "text/html");  
	    	   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  

	    	   transport.connect();  
	    	   Transport.send(message, from, password);  
	    	   transport.close();

	     } catch (MessagingException e) {
	        throw new RuntimeException(e);
	    }
		return email;

	}
}
