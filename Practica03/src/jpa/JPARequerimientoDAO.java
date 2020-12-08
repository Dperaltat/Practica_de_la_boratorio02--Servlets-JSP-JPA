package jpa;

import java.util.ArrayList;
import java.util.List;

import dao.*;
import entidad.*;

public class JPARequerimientoDAO extends JPAGenericDAO<Requerimiento, String> implements RequerimientoDAO {
	
	public JPARequerimientoDAO() {
		super(Requerimiento.class);
	    }
	
	@Override
	public void update_estado(Requerimiento requerimientosCompra) {
		
		em.getTransaction().begin();
		em.merge(requerimientosCompra);
		em.getTransaction().commit();
		
	}

	@Override
	public List<Requerimiento> find_empresa(int id) {
		
		List<Requerimiento> list = new ArrayList<Requerimiento>();
		String jpql = "SELECT r FROM RequerimientosCompra r INNER JOIN r.empresa e WHERE e.id = "+id;
		list = (List<Requerimiento>) em.createQuery(jpql, Requerimiento.class).getResultList();
		
		return list;
	}

	@Override
	public List<Requerimiento> find_usuario(int id) {
		
		List<Requerimiento> list = new ArrayList<Requerimiento>();
		String jpql = "SELECT r FROM RequerimientosCompra r INNER JOIN r.usuario u WHERE u.id = "+id;
		list = (List<Requerimiento>) em.createQuery(jpql, Requerimiento.class).getResultList();
		
		return list;
	}
}
