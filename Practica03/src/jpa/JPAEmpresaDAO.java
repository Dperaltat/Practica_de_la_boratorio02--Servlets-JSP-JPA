package jpa;

import dao.*;
import entidad.*;

public class JPAEmpresaDAO extends JPAGenericDAO<Empresa, String> implements EmpresaDAO {

		public JPAEmpresaDAO() {
			super(Empresa.class);
		    }
}
