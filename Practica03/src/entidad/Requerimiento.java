package entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="requerimiento")
public class Requerimiento implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private String idRequerimientos;
	private String estado;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "requerimientos")
	private Set<Producto> productos = new HashSet<Producto>();
	@ManyToOne
	@JoinColumn
	private Usuario usuario;
	
	
	public Requerimiento() {
		
	}

	public Requerimiento(String idRequerimientos, String estado, Usuario usuario) {
		super();
		this.idRequerimientos = idRequerimientos;
		this.estado = estado;
		this.usuario = usuario;
	}


	public String getIdRequerimientos() {
		return idRequerimientos;
	}


	public void setIdRequerimientos(String idRequerimientos) {
		this.idRequerimientos = idRequerimientos;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Set<Producto> getProductos() {
		return productos;
	}


	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((idRequerimientos == null) ? 0 : idRequerimientos.hashCode());
		result = prime * result + ((productos == null) ? 0 : productos.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Requerimiento other = (Requerimiento) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (idRequerimientos == null) {
			if (other.idRequerimientos != null)
				return false;
		} else if (!idRequerimientos.equals(other.idRequerimientos))
			return false;
		if (productos == null) {
			if (other.productos != null)
				return false;
		} else if (!productos.equals(other.productos))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Requerimiento [idRequerimientos=" + idRequerimientos + ", estado=" + estado + ", productos=" + productos
				+ ", usuario=" + usuario + "]";
	}
   
	
}
