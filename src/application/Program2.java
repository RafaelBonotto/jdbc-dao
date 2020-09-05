package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartamentoDao;
import model.entities.Departamento;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartamentoDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TEST 1: buscarPorId =======");
		Departamento dep = departmentDao.buscaPorId(1);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2: buscarTodos =======");
		List<Departamento> list = departmentDao.buscarTodos();
		for (Departamento d : list) {
			System.out.println(d);
		}

		System.out.println("\n=== TEST 3: inserir =======");
		Departamento newDepartment = new Departamento(null, "Music");
		departmentDao.inserir(newDepartment);
		System.out.println("Inserido! Novo id: " + newDepartment.getId());

		System.out.println("\n=== TEST 4: atualizar =======");
		Departamento dep2 = departmentDao.buscaPorId(1);
		dep2.setNome("Food");
		departmentDao.atualizar(dep2);
		System.out.println("Atuallização completa!");
		
		System.out.println("\n=== TEST 5: delete =======");
		System.out.print("Entre com id para ser excluido: ");
		int id = sc.nextInt();
		departmentDao.excluirPorId(id);
		System.out.println("Excluído com sucesso!");

		sc.close();
	}

}
