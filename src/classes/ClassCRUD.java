package classes;

import java.util.List;
import java.util.Scanner;

import dao.ClassDAO;

public class ClassCRUD {
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
		Class c = new Class();
		System.out.println("Selecione um Estudante: ");
		List<Student> studentList = StudentCRUD.listar();
		c.setStudentId(studentList.get(Integer.parseInt(teclado.nextLine())));
		System.out.println("Selecione um Curso: ");
		List<Course> courseList = CourseCRUD.listar();
		c.setCourseId(courseList.get(Integer.parseInt(teclado.nextLine())));
		System.out.println("Login: ");
		c.setStudentLogin(teclado.nextLine());
		ClassDAO.save(c);
	}
	
	private static void atualizar() {
		System.out.println("Selecione uma turma: \n");
		List<Class> classList = listar();
		Class c = classList.get(Integer.parseInt(teclado.nextLine()));
		System.out.println("Alterar Estudante ou enter para manter o mesmo");
		List<Student> studentList = StudentCRUD.listar();
		c.setStudentId(studentList.get(Integer.parseInt(teclado.nextLine())));
		System.out.println("Alterar Curso ou enter para manter o mesmo");
		List<Course> courseList = CourseCRUD.listar();
		c.setCourseId(courseList.get(Integer.parseInt(teclado.nextLine())));
		System.out.println("Login: ");
		c.setStudentLogin(teclado.nextLine());
		ClassDAO.update(c);
	}
	
	public static void deletar() {
		System.out.println("Selecione um curso para deletar: \n");
		List<Class> classList = listar();
		int index = Integer.parseInt(teclado.nextLine());
		System.out.println("Tem Certeza? S/N");
		String op = teclado.nextLine();
		if(op.startsWith("s")) {
			ClassDAO.delete(classList.get(index));
		}
	}
	
	private static List<Class> listar() {
		List<Class> classList = ClassDAO.selectAll();
		for (int i = 0; i < classList.size(); i++) {
			Class c = classList.get(i);
			System.out.println("\n["+i+"]" + "Nome: " + c.getStudentId().getStudentName() +", Curso: "+ c.getCourseId().getCourseName() +", Login: "+ c.getStudentLogin());
			System.out.println("====================================================");
		}
		return classList;
	}
}