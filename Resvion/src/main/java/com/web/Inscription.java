package com.web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.User;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	UserDao udao;
	int cpterr=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		udao=new UserDao();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String act = request.getParameter("act");
		if(act.equals("inscrire"))
		{
	String nom=request.getParameter("nom");
	String log=request.getParameter("log");
	String pass=request.getParameter("pass");
	int nb = udao.inscription(nom, log, pass);
	
	if(nb==1)
	{
		HttpSession ses = request.getSession();
		ses.setAttribute("u", nom);
		response.sendRedirect("smi2022.jsp");
	}else
	{
		response.sendRedirect("index2.jsp");
	
	}
		}else
			if(act.equals("connect"))
			{ 
				String log=request.getParameter("log");
				String pass=request.getParameter("pass");
				User u = udao.authentification(log, pass);
				if(u!=null)
				{
					HttpSession ses = request.getSession();
					ses.setAttribute("u", u.getNom());
					response.sendRedirect("smi2022.jsp");
				}else
				{
					//boolean error=true;
					cpterr++;
					response.sendRedirect("index2.jsp?err="+cpterr);

				}
				
			}
		
	
	}

}
