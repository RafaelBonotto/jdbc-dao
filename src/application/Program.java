package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
					
		VendedorDao vendedorDao = DaoFactory.createVendedorDao();
		
		System.out.println("=== Test 1: vendedor buscarPorId ===");
		
		Vendedor vendedor = vendedorDao.buscaPorId(3);
		
		System.out.println(vendedor);
		
		System.out.println("\n=== Test 2: vendedor buscarPorDepartamento ===");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> list = vendedorDao.buscarPorDepartamento(departamento);
		for (Vendedor obj : list) {
			System.out.println(obj);
		}
			
		System.out.println("\n=== Test 3: vendedor buscarTodos ===");
		list = vendedorDao.buscarTodos();
		   for (Vendedor obj : list) {
				System.out.println(obj);
		}
		   
		System.out.println("\n=== Test 4: vendedor anserir  ===");
		Vendedor newVendedor = new Vendedor(null, "Greg", "greg@gmail.com", new Date(), 4000.0, departamento);
		vendedorDao.inserir(newVendedor);
		System.out.println("Inserido! Novo Id: " + newVendedor.getId());
		
		System.out.println("\n=== Test 5: vendedor atualizar  ===");
		vendedor = vendedorDao.buscaPorId(1);
		vendedor.setNome("Marta Waine");
		vendedorDao.atualizar(vendedor);
		System.out.println("Atualização Completada!");
		
		System.out.println("\n=== Test 6: vendedor delete  ===");
		System.out.println("Entre com ID paratestar o delete: ");
		int id = sc.nextInt();
		vendedorDao.excluirPorId(id);
		System.out.println("Excluído com Sucesso!!");
		
		sc.close();
		


	   
     }
}	
