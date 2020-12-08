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

import dao.CategoriaDAO;
import dao.DAOFactory;
import dao.ProductoDAO;
import entidad.Categoria;
import entidad.Empresa;
import entidad.Producto;

@WebServlet("/ModificarProductoControlador")
public class ModificarProductoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDAO;
	private CategoriaDAO categoriaDAO;
	private Producto producto;
	private String result;

    public ModificarProductoControlador() {
    	productoDAO = DAOFactory.getFactory().getProductoDAO();
    	result = "";
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	Empresa emp;
	Categoria catg;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getParameter("categ"));
		
		String url, descripcion, nombre, requerimiento ;
		int id;	
		
		boolean flag = false;
		
		HttpSession session = request.getSession(true);
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		url = "/startbootstrap-sb-admin-gh-pages/dist/private/ModificarProducto.jsp";
		
		if(request.getParameter("id").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if(request.getParameter("nombre").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if(request.getParameter("precio").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if(request.getParameter("descrip").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if(request.getParameter("categ").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		
		if(flag==false) {
			
			id = Integer.valueOf(request.getParameter("idProducto"));
			nombre = request.getParameter("nombre");
			requerimiento = request.getParameter("requerimientos");
	
			catg.getIdCategoria();
			emp.getIdEmpresa();
			descripcion = request.getParameter("descrip");
			try {
				
				producto = new Producto(id, nombre, requerimiento, catg);
				productoDAO.update(producto);
				
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