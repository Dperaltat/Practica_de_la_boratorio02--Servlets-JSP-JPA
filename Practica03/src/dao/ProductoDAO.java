package dao;

import java.util.List;

import entidad.*;

public interface ProductoDAO extends GenericDAO<Producto, String>{
	List<Producto> find_emp(int emp);
}
