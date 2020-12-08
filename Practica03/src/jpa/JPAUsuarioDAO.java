package jpa;

import dao.*;
import entidad.*;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, String> implements UsuarioDAO {
	
	public JPAUsuarioDAO() {
		super(Usuario.class);
	    }
	
	@Override
	public Usuario login(String mail, String pass) {
		
		Usuario user = null;
		String jpql = "SELECT u FROM Usuario u WHERE u.correo = '"+mail+"' and u.contrasena = '"+pass+"'";
		//em.createQuery("SELECT p FROM Product p WHERE p.category='" + category + "'");
		
		try {
			user = em.createQuery(jpql, Usuario.class).getSingleResult();
		} catch (Exception e) {
			System.out.println(">>>WARNING (JDBCUserDAO:login): " + e.getMessage());
		}
		
		return user;
	}
}
