package servlet;


/*
 *  IMPORT -- > En esta area ingresamos todas las clases que vamos a utilizar
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import controlador.CtrlUsuario;
import controlador.CtrlGeneral;
import entidades.ModeloAnestesia;
import entidades.Usuario;
import utilidades.ApplicationException;


@WebServlet("/LoginUsr")

public class LoginUsr extends HttpServlet {
	
	//Variables globales
	private static final long serialVersionUID = 1L;
	private CtrlUsuario cu = null;
	private Usuario user = null;
	private ArrayList<ModeloAnestesia> anestesias = null;
	private CtrlGeneral control = new CtrlGeneral();
	
	
	//Constructor
	public LoginUsr(){
		super();
	}
	
	//Metodos del servlet
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//NO lo implemento por cuestiones de seguridad, solo hago el llamado a doPost con los parametros
		
		//doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Variables locales
		
		//Obtengo los valores del formulario y lo asigno a las variables que creo. El Trim saca los espacios en blanco
		
		String usuario = request.getParameter("usuario").trim();
		String password = request.getParameter("password").trim();

		
		//Instancio el controlador y la variable
		cu = new CtrlUsuario();
		user = new Usuario();
		anestesias = new ArrayList<>();
		
		try{
			if (cu.validaUsuario(usuario, password)==true){
				user.setUser(usuario);
				user = cu.consultaUsuario(user);
				HttpSession session = request.getSession(true);
				session.setAttribute("u", usuario);
				
				switch (user.getIdRol()) {
				case 1:
					//administrador
					request.getRequestDispatcher("menuAdministrador.jsp").forward(request, response);
					break;
				case 2:
					//gestor
					request.getRequestDispatcher("menuGestor.jsp").forward(request, response);
					break;
				case 3:
					//Anestesista
					cargaAnestesista(request, response);
					
				default:
					//Sin Rol
					//request.getRequestDispatcher("menuUsr.jsp").forward(request, response);
					break;
				}
			}
			else{
				request.setAttribute("error", "Usuario o Password Incorrectos");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		catch(ServletException | IOException e){
			e.getMessage();
			response.sendRedirect("");
		}
		
	}
	
	// Metodo que instancia los listados que necesito mostrar al principio y me deriva a la pagina correspondiente
	private void cargaAnestesista(HttpServletRequest request, HttpServletResponse response){
		try {
			//CargarDatos pasa dos parametros el usuario activo y el anestesista, sirve para mostrar las anestesias de un usuario 
			// y un anestesista
			anestesias = control.cargarDatosA(user);
			HttpSession session = request.getSession(true);
			session.setAttribute("anestesias", anestesias);
			request.getRequestDispatcher("menuAnestesista.jsp").forward(request, response);
			
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		} 
	}
	
}
