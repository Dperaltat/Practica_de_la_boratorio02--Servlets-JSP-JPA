package dao;

import entidad.*;

public interface UsuarioDAO extends GenericDAO<Usuario, String> {
	Usuario login(String mail, String pass);
}
