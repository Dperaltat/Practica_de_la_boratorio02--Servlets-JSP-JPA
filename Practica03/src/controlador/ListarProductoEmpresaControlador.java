package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriaDAO;
import dao.DAOFactory;
import dao.ProductoDAO;
import entidad.Producto;
import entidad.Categoria;

@WebServlet("/ListarProductoEmpresaControlador")
public class ListarProductoEmpresaControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDAO;
	private CategoriaDAO categoriaDAO;
	private Categoria cat;
	private Producto pro;

    public ListarProductoEmpresaControlador() {
    	productoDAO = DAOFactory.getFactory().getProductoDAO();
    	categoriaDAO = DAOFactory.getFactory().getCategoriaDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url=null;
		int id;
		
		List<Producto> pr = new ArrayList<Producto>();
		List<String> ct = new ArrayList<>();
		
		try {
			
			id = Integer.valueOf(request.getParameter("idProducto").toString());		
			pr = productoDAO.find_emp(id);
			url = "/startbootstrap-sb-admin-gh-pages/dist/public/home.jsp";
			
			for (Producto p : pr) {
				cat = categoriaDAO.read(p.getCategorias().getIdCategoria());
				ct.add(cat.getNombre());	
			}
			
			request.setAttribute("productos", pr);
			request.setAttribute("categorias", ct);
			
			getServletContext().getRequestDispatcher(url).forward(request, response);
			
			
		} catch (Exception e) {
			System.out.println("ERROR "+e.getMessage());
		}
		
	}

}