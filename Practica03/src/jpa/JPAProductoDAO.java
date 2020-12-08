package jpa;

import java.util.ArrayList;
import java.util.List;

import dao.*;
import entidad.*;

public class JPAProductoDAO extends JPAGenericDAO<Producto, String> implements ProductoDAO {
	
	public JPAProductoDAO() {
		super(Producto.class);
	    }
	
	@Override
	public List<Producto> find_emp(int emp) {
		String jpql = "SELECT p FROM Producto p WHERE p.empresa.id = "+emp;
		List<Producto> list = new ArrayList<Producto>();
		
		list = (List<Producto>) em.createQuery(jpql, Producto.class).getResultList();
		
		return list;
	}
}
