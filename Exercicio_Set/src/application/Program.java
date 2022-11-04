package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import model.entities.Student;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Set<Student> list = new HashSet<>(); 
		
		int quantity;
		
		System.out.print("How many students for course A?: ");
		quantity = sc.nextInt();
		for(int i = 0 ; i < quantity ; i++) {
			int id = sc.nextInt();
			list.add(new Student(id));
		}
		System.out.print("How many students for course B?: ");
		quantity = sc.nextInt();
		for(int i = 0 ; i < quantity ; i++) {
			int id = sc.nextInt();
			list.add(new Student(id));
		}
		System.out.print("How many students for course c?: ");
		quantity = sc.nextInt();
		for(int i = 0 ; i < quantity ; i++) {
			int id = sc.nextInt();
			list.add(new Student(id));
		}
		System.out.print("Quantity: " + list.size());
	}

}
