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

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		dao=new UserDao();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op=request.getParameter("btn");
		String lg=request.getParameter("log");
		String ps=request.getParameter("pass");
		
		if(op.equals("inscrire"))
		{
		String nom=request.getParameter("name");
		
		
		int id=dao.inscription(nom, lg, ps);
		response.sendRedirect("index.jsp");
		}
		else
			if(op.equals("connect"))
			{
				
				com.model.User u = dao.authentification(lg, ps);
				if(u!=null)
					{
						HttpSession ses = request.getSession();
						ses.setAttribute("user", u);
						response.sendRedirect("Acceuil.jsp");
					}
				else
				response.sendRedirect("index.jsp");
			}
		
			
		
	}

}
