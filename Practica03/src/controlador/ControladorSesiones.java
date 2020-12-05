package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import entidad.*;
import jpa.JPAUsuarioDAO;

@WebServlet(name = "controladorSesiones", urlPatterns = { "/controladorSesiones" })
public class ControladorSesiones extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControladorSesiones() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html:charset=UTF-8");
		String url = null;
		
		//RequerimientosDAO requerimientoDAO = DAOFactory.getFactory().getRequerimientoDAO();
		UsuarioDAO usuarioDao = DAOFactory.getFactory().getUsuarioDAO();

		Object mostrar = request.getParameter("mostrarPrincipalU");
		List<Requerimiento> req = new ArrayList<Requerimiento>();
		List<Producto> pr = new ArrayList<Producto>();
		List<Empresa> em = new ArrayList<Empresa>();
		HttpSession sesion = request.getSession(true);

		sesion.setAttribute("accesos", sesion.getId());
		System.out.println("ID sesion Usuario: " + String.valueOf(sesion.getId()));
		
		/*if (mostrar.equals("mostrar")) {
			try {
				req = usuarioDao.listarProductos0();
				pr = usuarioDao.listarProductos1();
				em = usuarioDao.listarProductos2();
				request.setAttribute("requerimientos", req);
				request.setAttribute("productos", pr);
				request.setAttribute("empresas", em);
				JPAUsuarioDAO nuevo = new JPAUsuarioDAO();
				if (nuevo.rol.equals("A")) {
					url="/JSPs/Admin.jsp";
				}else if(nuevo.rol.equals("U")){
					url="/JSPs/Usuario.jsp";
				}
			} catch (Exception e) {
				url="/JSPs/InicioSesion.jsp";
				System.out.println("Error en el login: " + e.getMessage());
			}
			request.getRequestDispatcher(url).forward(request, response);
		}*/

	}
	
}
