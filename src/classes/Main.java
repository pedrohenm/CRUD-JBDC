package classes;

import java.util.Scanner;

public class Main {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		int op;
		while(true) {
			menu();
			op = Integer.parseInt(teclado.nextLine());
			if(op == 0) {
				System.out.println("Saindo do Sistema");
				break;
			}
			if(op == 1)	{
				StudentMenu();
				op = Integer.parseInt(teclado.nextLine());
				StudentCRUD.executar(op);				
			}
			if(op == 2)	{
				CourseMenu();
				op = Integer.parseInt(teclado.nextLine());
				CourseCRUD.executar(op);				
			}
			if(op == 3)	{
				ClassMenu();
				op = Integer.parseInt(teclado.nextLine());
				ClassCRUD.executar(op);				
			}
			if(op == 4)	{
				SituationsMenu();
				op = Integer.parseInt(teclado.nextLine());
				SituationCRUD.executar(op);				
			}
		}
	}
	
	private static void menu() {
		System.out.println("Selecione uma opção: ");
		System.out.println("1. Estudantes");
		System.out.println("2. Cursos");
		System.out.println("3. Turmas");
		System.out.println("4. Situações");
		System.out.println("0. Sair\n");
	}
	
	private static void StudentMenu() {
		System.out.println("\nDigite a opção para começar");
		System.out.println("1. Inserir estudante");
		System.out.println("2. Atualizar estudante");
		System.out.println("3. Listar todos os estudante");
		System.out.println("4. Deletar estudante");
		System.out.println("9. Voltar\n");
		
	}
	
	private static void CourseMenu() {
		System.out.println("\nDigite a opção para começar");
		System.out.println("1. Inserir curso");
		System.out.println("2. Atualizar curso");
		System.out.println("3. Listar todos os cursos");
		System.out.println("4. Deletar Curso");
		System.out.println("9. Voltar\n");
		
	}
	
	private static void ClassMenu() {
		System.out.println("\nDigite a opção para começar");
		System.out.println("1. Inserir turma");
		System.out.println("2. Atualizar turma");
		System.out.println("3. Listar todas as turmas");
		System.out.println("4. Deletar Turma");
		System.out.println("9. Voltar\n");
		
	}
	
	private static void SituationsMenu() {
		System.out.println("\nDigite a opção para começar");
		System.out.println("1. Inserir situação");
		System.out.println("2. Atualizar situação");
		System.out.println("3. Listar todas as situaçoes");
		System.out.println("4. Deletar Situação");
		System.out.println("9. Voltar\n");
		
	}
}
