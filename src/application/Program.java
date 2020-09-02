package application;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Vendedor;

public class Program {

	public static void main(String[] args) {
					
		VendedorDao vendedorDao = DaoFactory.createVendedorDao();
		
		Vendedor vendedor = vendedorDao.buscaPorId(3);
		
		System.out.println(vendedor);
	}

}
