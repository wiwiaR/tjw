package br.edu.ifce.teste;
import java.net.MalformedURLException;

import org.apache.commons.mail.EmailException;

import br.edu.ifce.bean.Mail;
import br.edu.ifce.mail.CommonsMail;

public class personal {
  public static void main(String args[]) throws MalformedURLException, EmailException{
	  CommonsMail mail = new CommonsMail();
	  Mail m = new Mail();
	  mail.enviaEmailSimples(m);
  }
}
