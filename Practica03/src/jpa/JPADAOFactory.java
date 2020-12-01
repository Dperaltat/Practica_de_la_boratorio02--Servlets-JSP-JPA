package jpa;

import dao.*;

public class JPADAOFactory extends DAOFactory{
	
	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new JPAUsuarioDAO();
	}
	
	@Override
	public EmpresaDAO getEmpresaDAO() {
		return new JPAEmpresaDAO();
	}
	
	@Override
	public RequerimientoDAO getRequerimientoDAO() {
		return new JPARequerimientoDAO();
	}
	
	@Override
	public ProductoDAO getProductoDAO() {
		return new JPAProductoDAO();
	}
	
	@Override
	public CategoriaDAO getCategoriaDAO() {
		return new JPACategoriaDAO();
	}

}
