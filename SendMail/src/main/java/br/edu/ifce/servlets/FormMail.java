package br.edu.ifce.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormMail
 */
public class FormMail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormMail() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String user = (String) request.getSession().getAttribute("usuario");

		if (user == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);

		}

		PrintWriter out = response.getWriter();
		out.print("<html>" 
				+ "<head>" 
				+ "<title>Projeto Send Mail 1.0 - TJW</title>" 
				+ "</head>" 
				+ "<body>" 
				+ "<div>"
				+ "<h1 align=\"center\">Formulário de Envio de Emails</h1>"
				+ "<p align=\"center\">Captura automática de parâmetros da Requisição usando JavaBeans - <a href=\"Logout\">Sair</a></p>"
				+ "</div>" 
				+ "<form action=\"SendMail\" method=\"post\" name=\"form_sendmail\" >" 
				+ "<p>&nbsp;</p>"
				+ "<table width=\"230\" border=\"0\" align=\"center\">" 
				+ "<tr>" 
				+ "<td width=\"70\">Assunto:</td>"
				+ "<td width=\"144\"><input type=\"text\" name=\"assunto\"></td>" 
				+ "</tr>" 
				+ "<tr>"
				+ "<td>Destinatário:</td>" 
				+ "<td><input type=\"text\" name=\"destinatario\"></td>" 
				+ "</tr>" 
				+ "<tr>"
				+ "<td>Mensagem: </td>"
				+ "<td><textarea name=\"mensagem\" id=\"textarea\" cols=\"45\" rows=\"5\"></textarea></td>" 
				+ "</tr>"
				+ "<tr>" 
				+ "<td></td>" 
				+ "<td><input type=\"submit\" name=\"sendmail\" value=\"Enviar e-mail\"></td>"
				+ "</tr>" 
				+ "</table>" 
				+ "<p>&nbsp;</p>" 
				+ "</form>" 
				+ "</body>" 
				+ "</html>");
		out.flush();
	}
}
