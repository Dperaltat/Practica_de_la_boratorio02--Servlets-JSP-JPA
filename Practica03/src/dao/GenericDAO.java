package dao;

import java.util.List;

import entidad.*;

public interface GenericDAO<T,ID> {
	
	public void create(T entity);
	
	public T read(ID id);
	
	public void update(T entity);
	
	public void delete(T entity);
	
	public List<T> find();
	
	public void deleteByID(ID id);
	
	/*public List<Producto> buscarProducto(String nombre);
	public List<Requerimiento> buscarCedInv(String cedula);
	public List<Usuario> buscarCorreo(String correo); */
	
	List<T> findAll();
	
	Usuario buscar(String email, String pwd);
	
	List<Requerimiento> listarProductos0();
	
	List<Producto> listarProductos1();
	
	List<Empresa> listarProductos2();
}
