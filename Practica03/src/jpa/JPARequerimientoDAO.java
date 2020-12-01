package jpa;

import dao.*;
import entidad.*;

public class JPARequerimientoDAO extends JPAGenericDAO<Requerimiento, String> implements RequerimientoDAO {
	
	public JPARequerimientoDAO() {
		super(Requerimiento.class);
	    }
}
