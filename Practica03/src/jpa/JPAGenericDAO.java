package jpa;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import dao.*;
import entidad.*;

public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID> {

	private Class<T> persistentClass;
	protected EntityManager em;
	public static String rol;

	public JPAGenericDAO(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
		this.em = Persistence.createEntityManagerFactory("db-jpa").createEntityManager();
	}

	@Override
	public void create(T entity) {
		em.getTransaction().begin();
		try {
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(">>>> ERROR:JPAGenericDAO:create " + e);
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
	}

	@Override
	public T read(ID id) {
		return em.find(persistentClass, id);
	}

	@Override
	public void update(T entity) {
		em.getTransaction().begin();
		try {
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(">>>> ERROR:JPAGenericDAO:update " + e);
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
	}

	// entity debe estar en estado de "Managed"
	@Override
	public void delete(T entity) {
		em.getTransaction().begin();
		try {
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(">>>> ERROR:JPAGenericDAO:delete " + e);
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
	}

	@Override
	public List<T> find() {

		return null;
	}

	@Override
	public void deleteByID(ID id) {
		T entity = this.read(id);
		if (entity != null)
			this.delete(entity);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<T> findAll() {
		em.getTransaction().begin();
		List<T> lista = null;
		try {
			javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(persistentClass));
			lista = em.createQuery(cq).getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;

	}

	@Override
	public Usuario buscar(String email, String contrasena) {
		Query nativeQuery = em.createNativeQuery("SELECT u FROM usuario u WHERE correo = ? AND pwd = ? ", Usuario.class);
		nativeQuery.setParameter(1, email);
		nativeQuery.setParameter(2, contrasena);
		
		/*try {
			if (rs != null && rs.next()) {
				id = rs.getString("id");
				rol = rs.getString("rol");
				usuarioObject = new Usuario (id, rs.getString("nombre"), rs.getString("apellido"), rs.getString("correo"), rs.getString("clave"), rol);
			}	
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUsuarioDAO:read): " + e.getMessage());
		}*/

		return (Usuario) nativeQuery.getSingleResult();
	}

	@Override
	public List<Requerimiento> listarProductos0() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> listarProductos1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empresa> listarProductos2() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
