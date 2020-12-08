package dao;

import java.util.List;

import entidad.*;

public interface RequerimientoDAO extends GenericDAO<Requerimiento, String>{
	
	void update_estado(Requerimiento requerimientos);

	List<Requerimiento> find_empresa(int id);

	List<Requerimiento> find_usuario(int id);
}
