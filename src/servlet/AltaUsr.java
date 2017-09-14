package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.Response;

import entidades.Usuario;
import entidades.Anestesista;
import entidades.Sanatorio;
import controlador.CtrlUsuario;
import controlador.CtrlAnestesista;
import controlador.CtrlSanatorio;
import utilidades.ApplicationException;
import java.util.ArrayList;

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
		Anestesista a = new Anestesista();
		CtrlAnestesista ca = new CtrlAnestesista();
		String[] sanatoriosString;
		ArrayList<Integer> sanatoriosInt = new ArrayList<>();
		Sanatorio s = new Sanatorio();
		CtrlSanatorio cs = new CtrlSanatorio();
		
		//Seteo al request como UTF-8 para" no tener problemas con caracteres especiales
		request.setCharacterEncoding("UTF-8");
		
		
		//Seteo los valores en el objeto usuario. 
		u.setUser(request.getParameter("usuario"));
		u.setPassword(request.getParameter("password"));
		u.setNombreUsuario(request.getParameter("nombre"));
		u.setApellidoUsuario(request.getParameter("apellido"));
		u.setMailUsuario(request.getParameter("mail"));
		u.setIdRol(0);
		
		//Seteo los valores para el anestesista
		a.setNombreAnestesista(request.getParameter("nombre"));
		a.setApellidoAnestesista(request.getParameter("apellido"));
		a.setUser(request.getParameter("usuario"));
		String matricula = request.getParameter("matricula");
		String grupo = request.getParameter("grupo");

		//Valido que los datos del combo no sea nulos
		if(matricula != "" && grupo != ""){
			a.setMatricula(Integer.parseInt(request.getParameter("matricula")));
			a.setGrupo(Integer.parseInt(request.getParameter("grupo")));
		}
		//si lo son le cargo ambos valores con cero
		else{
			a.setMatricula(0);
			a.setGrupo(0);
		}
			
		//Seteo los sanatorios que selecciono en el checkbox
		sanatoriosString = request.getParameterValues("opciones");
		//Y recorro el array para buscar los id de sanatorios
		if(sanatoriosString.length>0){
			for(int i = 0; i < sanatoriosString.length; i++){
				s = cs.buscaSanatorio(sanatoriosString[i].toString());
				if(s != null){
				sanatoriosInt.add(s.getIdSanatorio());}
			}
		}
		//Doy de alta al usuario sin rol 
		try{
			//Doy de alta el usuario y pregunto si salio bien
			if(cu.altaUsuario(u, sanatoriosInt) == true){
				/*
				 * pregunto si algunos de estos datos se cargo, si es asi genero el alta del anestesista.
				 * Doy por sentado que los valores que se ingresen en Grupo y Matricula son validos, ya que son
				 * cargados por anestesistas, sin embargo hay un paso posterior que se valida que el usuario que 
				 * se dio de alta sea o no anestesistas, este paso lo hace una persona
				 */
				if(a.getMatricula() != 0 && a.getGrupo() != 0)
				{
					if(ca.altaAnestesista(a, sanatoriosInt) == true){
						cargaPagina(true, response);
					}
				}
				cargaPagina(true, response);
			}
			else{
				cargaPagina(false, response);
			}
		}
		catch(ApplicationException e){
			e.getMessage();
			response.sendRedirect("");
		}
	}
	
	private void cargaPagina(boolean r, HttpServletResponse response) throws ApplicationException{
		try{
			if(r == true){
				response.sendRedirect("index.html");
			}
			else{
				response.sendRedirect("AltaUsrForm.html");
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
