package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import entidad.*;


@WebServlet("/ListarProductos")
public class ListarProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductoDAO productosDAO;
    private List<Producto> listaProducto;

    public ListarProductos() {
    	productosDAO = DAOFactory.getFactory().getProductoDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = null;
		try {
			listaProducto = productosDAO.findAll();
		    System.out.println("Tamaño de la lista recuperada: " + listaProducto.size());
		    request.setAttribute("requerimientos", listaProducto);
		    url = "/JSPs/Listar.jsp";
		} catch (Exception e) {
		    url = "/JSPs/404/error.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);   
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
