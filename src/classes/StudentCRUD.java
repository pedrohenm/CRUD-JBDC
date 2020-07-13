package classes;

import java.util.List;
import java.util.Scanner;

import dao.StudentDAO;

public class StudentCRUD {

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
		Student s = new Student();
		System.out.println("Nome: ");
		s.setStudentName(teclado.nextLine());
		System.out.println("Genero: ");
		s.setStudentGender(String.valueOf(teclado.nextLine()).charAt(0));
		System.out.println("Selecione uma Situação: ");
		List<Situation> situationList = SituationCRUD.listar();
		s.setSituationId(situationList.get(Integer.parseInt(teclado.nextLine())));
		System.out.println("Login: ");
		s.setStudentLogin(teclado.nextLine());
		StudentDAO.save(s);
	}
	
	private static void atualizar() {
		System.out.println("Selecione um curso: \n");
		List<Student> studentList = listar();
		Student s = studentList.get(Integer.parseInt(teclado.nextLine()));
		System.out.println("Novo nome ou enter para manter o mesmo");
		String name = teclado.nextLine();
		System.out.println("Novo genero ou enter para manter o mesmo");
		String gender = teclado.nextLine();
		System.out.println("Novo login ou enter para manter o mesmo");
		String login = teclado.nextLine();
		if(!name.isEmpty()) {
			s.setStudentName(name);
		}
		if(!gender.isEmpty()) {
			s.setStudentGender(String.valueOf(gender).charAt(0));
		}
		if(!login.isEmpty()) {
			s.setStudentLogin(login);
		}
		StudentDAO.update(s);
	}
	
	public static void deletar() {
		System.out.println("Selecione um estudante para deletar: \n");
		List<Student> studentList = listar();
		int index = Integer.parseInt(teclado.nextLine());
		System.out.println("Tem Certeza? S/N");
		String op = teclado.nextLine();
		if(op.startsWith("s")) {
			StudentDAO.delete(studentList.get(index));
		}
	}
	
	public static List<Student> listar() {
		List<Student> studentList = StudentDAO.selectAll();
		for (int i = 0; i < studentList.size(); i++) {
			Student s = studentList.get(i);
			System.out.println("\n["+i+"]" + "Nome: " + s.getStudentName() + ", Genero: "+ s.getStudentGender() + ", Login: "+ s.getStudentLogin() + ", Situação: " + s.getSituationId().getSituationName());
			System.out.println("====================================================");
		}
		return studentList;
	}
}