package br.edu.ifce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResumoEmailsEnviados
 */
public class ResumoEmailsEnviados extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int n_access;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResumoEmailsEnviados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = (String) request.getSession().getAttribute("usuario");
		if (user == null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		
		String cookieName = "TJW";
		Cookie[] cookies = request.getCookies();
		if (cookies != null){
			for (int i=0 ; i < cookies.length; i++){
				Cookie c = cookies[i];
				if (c.getName().equals(cookieName)){
					this.n_access =  Integer.parseInt(c.getValue());
					c.setValue(Integer.toString(n_access + 1));
					System.out.println(n_access + 1);
					response.addCookie(c);
					System.out.println("*");
				}
				else{
					Cookie co = new Cookie(cookieName, "0");
					co.setMaxAge(60 * 60 * 24 * 7);
					response.addCookie(co);
					System.out.println("#");
				}
			} 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
