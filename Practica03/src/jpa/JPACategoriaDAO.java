package jpa;

import dao.*;
import entidad.*;

public class JPACategoriaDAO extends JPAGenericDAO<Categoria, String> implements CategoriaDAO {
	
	public JPACategoriaDAO() {
		super(Categoria.class);
	    }
}
