package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import entidad.Categoria;
import entidad.Usuario;
import dao.UsuarioDAO;
import dao.CategoriaDAO;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private Categoria categoria;
	
    private static UsuarioDAO usuarioDAO;   
    private CategoriaDAO categoriaDAO;
       
    public Login() {
    	usuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
    	categoriaDAO = DAOFactory.getFactory().getCategoriaDAO();  
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session;
		
		try {
			String mail = request.getParameter("correo");
			String pass = request.getParameter("clave");
			
			usuario = usuarioDAO.login(mail, pass);
			
			session = request.getSession(true);
			session.setAttribute("rol", usuario.getRol());
			session.setAttribute("idUsuario", usuario.getIdUsuario());
			session.setAttribute("usuario", usuario);
			//session.setAttribute("categoria", categoria.getNombre());
			session.setAttribute("empresa", usuario.getEmpresa());
			session.setAttribute("empresa_idEmpresa", usuario.getEmpresa().getIdEmpresa());
			session.setAttribute("nombre", usuario.getNombre()+" "+usuario.getApellido());
			
			System.out.println(session.getAttribute("rol"));
			if (usuario.getRol().equals("U")) {
				url = "JSPs/Home.jsp";
				httpResponse.sendRedirect(url);
			} else if (usuario.getRol().equals("A")){
				url = "JSPs/Admin.jsp";
				httpResponse.sendRedirect(url);
			} else {
				request.setAttribute("mensaje", "(!) Usuario no registrado");
				url = "JSPs/InicioSesion.jsp";
				httpResponse.sendRedirect(url);
			}
		} catch (Exception e) {
			request.setAttribute("mensaje", "(!) Usuario no registrado");
			url = "JSPs/InicioSesion.jsp";
			httpResponse.sendRedirect(url);
			System.out.println("INTERNAL ERROR");
			System.out.println(e.getMessage());
		}	
	}
}