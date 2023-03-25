package br.edu.ifce.mail;
import java.net.MalformedURLException;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

import br.edu.ifce.bean.Mail;

public class CommonsMail {
	
	  public CommonsMail() throws EmailException, MalformedURLException {  
	     Mail m = new Mail();
	     m.setAssunto("Assunto");
	     m.setDestinatario("wiwia_ribeiro@icloud.com");
	     m.setMensagem("bsdjfd");
		 enviaEmailSimples(m);   
	     System.out.println("Email enviado com sucesso.");
	    } 
	  
	public void enviaEmailSimples(Mail mail) throws EmailException { 
		 
		  SimpleEmail email = new SimpleEmail();  
		  email.setHostName("smtp.gmail.com");
//		  email.setSmtpPort(587);
		  email.setSSLOnConnect(true);
		  email.setAuthentication("wiwiaribeiro23@gmail.com", "rwnifozamievvnzn"); 
		  email.setFrom("wiwiaribeiro23@gmail.com");
		  email.setSubject(mail.getAssunto());
		  email.setMsg(mail.getMensagem());
		  email.addTo(mail.getDestinatario());
		  email.send();
	  }
		
	public static void main(String[] args) throws EmailException, MalformedURLException {  
		new CommonsMail();  
	}		

}
