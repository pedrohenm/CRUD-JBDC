package classes;

import java.util.List;
import java.util.Scanner;

import dao.SituationDAO;

public class SituationCRUD {
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
		Situation s = new Situation();
		System.out.println("Nome: ");
		s.setSituatioName(teclado.nextLine());
		System.out.println("Login: ");
		s.setStudentLogin(teclado.nextLine());
		SituationDAO.save(s);
	}
	
	private static void atualizar() {
		System.out.println("Selecione uma Situação: \n");
		List<Situation> situationList = listar();
		Situation s = situationList.get(Integer.parseInt(teclado.nextLine()));
		System.out.println("Novo nome ou enter para manter o mesmo");
		String name = teclado.nextLine();
		System.out.println("Novo login ou enter para manter o mesmo");
		String login = teclado.nextLine();
		if(!name.isEmpty()) {
			s.setSituatioName(name);
		}
		if(!login.isEmpty()) {
			s.setStudentLogin(login);
		}
		SituationDAO.update(s);;
	}
	
	public static void deletar() {
		System.out.println("Selecione uma situação para deletar: \n");
		List<Situation> situationList = listar();
		int index = Integer.parseInt(teclado.nextLine());
		System.out.println("Tem Certeza? S/N");
		String op = teclado.nextLine();
		if(op.startsWith("s")) {
			SituationDAO.delete(situationList.get(index));
		}
	}
	
	public static List<Situation> listar() {
		List<Situation> situationList = SituationDAO.selectAll();
		for (int i = 0; i < situationList.size(); i++) {
			Situation s = situationList.get(i);
			System.out.println("\n["+i+"]" + "Nome: " + s.getSituationName() +", Login: "+ s.getStudentLogin());
			System.out.println("====================================================");
		}
		return situationList;
	}
}
