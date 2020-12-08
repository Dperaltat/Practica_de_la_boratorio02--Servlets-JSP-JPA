package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoriaDAO;
import dao.DAOFactory;
import dao.EmpresaDAO;
import dao.ProductoDAO;
import dao.UsuarioDAO;
import entidad.Categoria;
import entidad.Empresa;
import entidad.Producto;
import entidad.Requerimiento;

@WebServlet("/RegistrarProductoControlador")
public class RegistrarProductoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDAO;
	private EmpresaDAO empDAO;
	private CategoriaDAO catDAO;
	private Producto producto;
	private String result;

    public RegistrarProductoControlador() {
    	productoDAO = DAOFactory.getFactory().getProductoDAO();
    	catDAO = DAOFactory.getFactory().getCategoriaDAO();
    	empDAO = DAOFactory.getFactory().getEmpresaDAO();
    	result = "";
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getParameter("categ"));
		
		String url, descripcion, nombre, requerimiento;
		int id;
		boolean flag = false;
		
		Empresa emp;
		Categoria catg;
		
		HttpSession session = request.getSession(true);
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		url = "/startbootstrap-sb-admin-gh-pages/dist/private/register_pro.jsp";
		
		if(request.getParameter("idProducto").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if(request.getParameter("nombre").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if(request.getParameter("requerimientos").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if(request.getParameter("categorias").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if(flag==false) {
			
			id = Integer.valueOf(request.getParameter("idProducto"));
			nombre = request.getParameter("nombre");
			requerimiento = request.getParameter("requerimientos");
			catg = catDAO.read(request.getParameter("categorias"));
			
			try {
				
				producto = new Producto(id, nombre, requerimiento, catg);
				productoDAO.create(producto);
				
				if(session.getAttribute("rol").toString().equals("U")) {
					url = "/Practica_laboratorio_1/startbootstrap-sb-admin-gh-pages/dist/private/home_user.jsp";
					httpResponse.sendRedirect(url);
				} else {
					url = "/Practica_laboratorio_1/startbootstrap-sb-admin-gh-pages/dist/private/home_admin.jsp";
					httpResponse.sendRedirect(url);
				}
				response.getWriter().append("Served at: ").append(request.getContextPath());
				
			} catch (Exception e) {
				request.setAttribute("mensaje", "(!) Ocurrio un ERROR");
			}
		} else {
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
	}
}