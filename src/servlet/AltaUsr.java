package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Usuario;
import controlador.CtrlUsuario;
import utilidades.ApplicationException;

/**
 * Servlet implementation class AltaUsr
 */
@WebServlet("/AltaUsr")
public class AltaUsr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaUsr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Variables
		Usuario u = new Usuario();
		CtrlUsuario cu = new CtrlUsuario();
		
		//Seteo los valores en el objeto usuario. 
		u.setUser(request.getParameter("usuario"));
		u.setPassword(request.getParameter("password"));
		u.setNombreUsuario(request.getParameter("nombre"));
		u.setApellidoUsuario(request.getParameter("apellido"));
		u.setMailUsuario(request.getParameter("mail"));
		u.setIdRol(0);
		
		//Doy de alta al usuario sin rol
		try{
			if(cu.altaUsuario(u) == true){
				response.sendRedirect("index.html");
			}
			else{
				response.sendRedirect("AltaUsrForm.html");
			}
		}
		catch(ApplicationException | IOException e){
			e.getMessage();
			response.sendRedirect("");
		}
	}

}
