package dao;
import jpa.*;

public abstract class DAOFactory {
	
	protected static DAOFactory factory = new JPADAOFactory();
	
	public static DAOFactory getFactory() {
		return factory;
	}
	
	public abstract UsuarioDAO getUsuarioDAO();
	
	public abstract EmpresaDAO getEmpresaDAO();
	
	public abstract RequerimientoDAO getRequerimientoDAO();
	
	public abstract ProductoDAO getProductoDAO();
	
	public abstract CategoriaDAO getCategoriaDAO();
}
