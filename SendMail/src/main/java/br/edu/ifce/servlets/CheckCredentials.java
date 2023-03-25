package br.edu.ifce.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckCredentials
 */
public class CheckCredentials extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private  String dbPasswd;
	       
    public String getDbPasswd() {
		return dbPasswd;
	}

	public void setDbPasswd(String dbPasswd) {
		this.dbPasswd = dbPasswd;
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCredentials() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeUsuario = request.getParameter("nomeUsuario");
		String senhaUsuario = request.getParameter("senhaUsuario");

		if (nomeUsuario.equals("admin") && senhaUsuario.equals("123")){
			request.getSession().setAttribute("usuario", nomeUsuario);
			response.sendRedirect("FormMail");
		}else{
			RequestDispatcher dispacher = request.getRequestDispatcher("index.jsp");
			dispacher.forward(request, response);
		}
	}

}
