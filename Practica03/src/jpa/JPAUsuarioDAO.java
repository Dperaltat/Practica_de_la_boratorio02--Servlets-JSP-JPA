package jpa;

import dao.*;
import entidad.*;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, String> implements UsuarioDAO {
	
	public JPAUsuarioDAO() {
		super(Usuario.class);
	    }

}
