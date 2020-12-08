package entidad;

import java.io.Serializable;


import javax.persistence.*;


@Entity
@Table(name="producto")
public class Producto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private String idProducto;
	private String nombre;
	@ManyToOne
	@JoinColumn
	private Requerimiento requerimientos;
	@ManyToOne
	@JoinColumn
	private Categoria categorias;
	

	public Producto() {
		
	}


	public Producto(String idProducto, String nombre, Requerimiento requerimientos, Categoria categorias) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.requerimientos = requerimientos;
		this.categorias = categorias;
	}


	public Producto(int id, String nombre2, String requerimiento, Categoria catg) {
	}


	public String getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Requerimiento getRequerimientos() {
		return requerimientos;
	}


	public void setRequerimientos(Requerimiento requerimientos) {
		this.requerimientos = requerimientos;
	}


	public Categoria getCategorias() {
		return categorias;
	}


	public void setCategorias(Categoria categorias) {
		this.categorias = categorias;
	}


	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", requerimientos=" + requerimientos
				+ ", categorias=" + categorias + "]";
	}
	
	
   
}
