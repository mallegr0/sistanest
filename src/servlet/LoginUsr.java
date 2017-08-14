package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import controlador.CtrlUsuario;
import entidades.Usuario;
import utilidades.ApplicationException;


@WebServlet("/LoginUsr")

public class LoginUsr extends HttpServlet {
	
	//Variables
	private static final long serialVersionUID = 1L;
	private CtrlUsuario user = null;
	private Usuario u = null;
	
	//Constructor
	public LoginUsr(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Es el metodo que usaria si el formulario es get y no post
		doPost(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Variables
		
		//Obtengo los valores del formulario y lo asigno a las variables que creo. El Trim saca los espacios en blanco
		
		String usuario = request.getParameter("usuario").trim();
		String password = request.getParameter("password").trim();
		
		//Instancio el controlador y la variable
		user = new CtrlUsuario();
		u = new Usuario();
		try{
			if (user.validaUsuario(usuario, password)==true){
				u.setUser(usuario);
				u = user.consultaUsuario(u);
				HttpSession session = request.getSession(true);
				session.setAttribute("u", u);
				
				switch (u.getIdRol()) {
				case 1:
					//administrador
					request.getRequestDispatcher("menuUsr.jsp").forward(request, response);
					break;
				case 2:
					//gestor
					request.getRequestDispatcher("menuUsr.jsp").forward(request, response);
					break;
				default:
					//Anestesista
					request.getRequestDispatcher("menuUsr.jsp").forward(request, response);
					break;
				}
			}
			else{
				response.setStatus(1);
				request.getRequestDispatcher("index.html").forward(request, response);
			}
		}
		catch(ServletException | IOException e){
			e.getMessage();
			response.sendRedirect("");
		}
		
	}

}
