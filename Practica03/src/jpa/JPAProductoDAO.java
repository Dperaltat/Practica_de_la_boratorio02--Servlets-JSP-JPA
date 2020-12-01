package jpa;

import dao.*;
import entidad.*;

public class JPAProductoDAO extends JPAGenericDAO<Producto, String> implements ProductoDAO {
	
	public JPAProductoDAO() {
		super(Producto.class);
	    }
}
