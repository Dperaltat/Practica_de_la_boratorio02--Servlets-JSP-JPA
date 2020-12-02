package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import entidad.*;

@WebServlet(name = "controladorSesiones", urlPatterns = { "/controladorSesiones" })
public class ControladorSesiones extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControladorSesiones() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession sesion = request.getSession();
		sesion.setAttribute("accesos", sesion.getAttribute("accesos"));

		System.out.print("Id sesion IndexController: " + sesion.getAttribute("accesos"));
		RequerimientoDAO telefonoDao = DAOFactory.getFactory().getRequerimientoDAO();
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDao = DAOFactory.getFactory().getUsuarioDAO();

		if (Integer.parseInt(request.getParameter("id")) == 1) {
			usuario = usuarioDao.read(request.getParameter("c"));
			//System.out.println("Cedula usar: " + request.getParameter("c"));

			//System.out.println("Apellido user: " + usuario.getApellido());
			request.setAttribute("idc", request.getParameter("c"));
			request.setAttribute("usuario", usuario);
			getServletContext().getRequestDispatcher("/JSPs/Agregar.jsp").forward(request, response);

		} else if (Integer.parseInt(request.getParameter("id")) == 2) {

			// System.out.println(telefonoDao.find().telf_id +','+ str.id_user
			// +','+str.numero+','+str.tipo+','+str.operadora);
			usuario = usuarioDao.read(request.getParameter("idU"));

			//request.setAttribute("telefono", telefonoDao.buscarCedula(usuario.getCedula()));
			request.setAttribute("usuario", usuario);
			getServletContext().getRequestDispatcher("/JSPs/IndexUsuario.jsp").forward(request, response);

		}

		if (Integer.parseInt(request.getParameter("id")) == 3) {
			System.out.print("Esta ingresando a ver lista de telefono");
			System.out.println(telefonoDao.findAll());
			request.setAttribute("telefono", telefonoDao.findAll());
			getServletContext().getRequestDispatcher("/JSPs/ModoInvitado.jsp").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
