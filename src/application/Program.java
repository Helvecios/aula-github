package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Funcionario> list = new ArrayList<>(); //Instanciar a lista
		
		//Primeira parte: Entrada de dados
		
				
		System.out.print("Entre número de funcionarios a serem registrados: ");
		int n = sc.nextInt();
		
		for(int i = 1; i<= n; i++) {
			
			System.out.println();
			System.out.println("Funcionário: #" + i + ":");
			
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			//Verificar se o id existe. Foi criada uma função "hasId" no final do código, para esta verificação 
			while (hasId(list, id)) {
				System.out.println("id já existe. Tente novamente!");
				id = sc.nextInt();
			}
						
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salario: ");
			Double salario = sc.nextDouble();
			/* Mostrando separadamente criando o objeto Funcionário
			   Funcionario emp = new Funcionario(id, nome, salario);
			   Inserindo os dados do funcionario na lista
			   list.add(emp)
			*/
			list.add(new Funcionario(id, nome, salario)); //Criando o objeto Funcionario e inserindo na lista
		}
		
		//Segunda parte: Aumento de salario para determinado empregado
		
		System.out.println();
		System.out.print("Entre id do funcionario que terá aumento salarial:  ");
		int idAumento = sc.nextInt();
		//Verificar se o id existe. Foi criada uma função "hasId" no final do código, para esta verificação 
		Funcionario emp = list.stream().filter(x -> x.getId() == idAumento).findFirst().orElse(null);
			if (emp == null) {
				System.out.println("Este id não existe!");
			}
			else
			{
				System.out.print("Entre com percentual do aumento salarial:  ");
				double percentual = sc.nextDouble();
				emp.aumento(percentual); //Aumentar salário do funcionário do id digitado
			}
		
		//Terceira parte: Listagem dos empregado 
		
		System.out.println();
		System.out.println("Lista de empregados:");
		for (Funcionario obj : list) { //For_each
			System.out.println(obj);
		}
				
		sc.close();
		
	}
	
	//Metodo  para informar a posição do funcionario na lista
	public static boolean hasId(List<Funcionario> list, int id) {
			Funcionario emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
			return emp != null;
		

	}

}
