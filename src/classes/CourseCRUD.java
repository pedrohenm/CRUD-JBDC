package classes;

import java.util.List;
import java.util.Scanner;

import dao.CourseDAO;

public class CourseCRUD {
	private static Scanner teclado = new Scanner(System.in);
	
	public static void executar(int op) {
		switch(op) {
			case 1: 
				inserir(); 
				break; 
			case 2: 
				atualizar();
				break;	
			case 3: 
				listar();
				break;
			case 4: 
				deletar();
				break;
		}
	}
	
	public static void inserir() {
		Course c = new Course();
		System.out.println("Nome: ");
		c.setCourseName(teclado.nextLine());
		System.out.println("Login: ");
		c.setStudentLogin(teclado.nextLine());
		CourseDAO.save(c);
	}
	
	private static void atualizar() {
		System.out.println("Selecione um curso: \n");
		List<Course> courseList = listar();
		Course c = courseList.get(Integer.parseInt(teclado.nextLine()));
		System.out.println("Novo nome ou enter para manter o mesmo");
		String name = teclado.nextLine();
		System.out.println("Novo login ou enter para manter o mesmo");
		String login = teclado.nextLine();
		if(!name.isEmpty()) {
			c.setCourseName(name);
		}
		if(!login.isEmpty()) {
			c.setStudentLogin(login);
		}
		CourseDAO.update(c);
	}
	
	public static void deletar() {
		System.out.println("Selecione um curso para deletar: \n");
		List<Course> courseList = listar();
		int index = Integer.parseInt(teclado.nextLine());
		System.out.println("Tem Certeza? S/N");
		String op = teclado.nextLine();
		if(op.startsWith("s")) {
			CourseDAO.delete(courseList.get(index));
		}
	}
	
	public static List<Course> listar() {
		List<Course> courseList = CourseDAO.selectAll();
		for (int i = 0; i < courseList.size(); i++) {
			Course c = courseList.get(i);
			System.out.println("\n["+i+"]" + "Nome: " + c.getCourseName() +", Login: "+ c.getStudentLogin());
			System.out.println("====================================================");
		}
		return courseList;
	}
}
