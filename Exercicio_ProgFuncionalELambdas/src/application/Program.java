package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import model.entities.Employee;
import util.EmployeeSearchService;
import util.EmployeeService;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("Enter full file path: ");
		String path = "d://in2.txt";
		System.out.print("Enter salary: ");
		Double salary = 2000.00;
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			
			while(line != null) {
				String[] lines = line.split(",");
				list.add(new Employee(lines[0], lines[1], Double.parseDouble(lines[2])));
				line = br.readLine();
			}
			//list.removeIf(e -> e.getSalary() < salary);
			
			EmployeeSearchService ess = new EmployeeSearchService();
			List<String> mThan = ess.employeeSearch(list, e -> e.getSalary() > salary);
			Collections.sort(mThan, Collator.getInstance());
			
			System.out.println("\nEmail of people whose salary is more than " + salary);
			mThan.forEach(System.out::println);
			
			EmployeeService es = new EmployeeService();
			double sum = es.sumPrice(list, e -> e.getName().charAt(0) == 'M');
			System.out.print("\nSum of salary of people whose name starts with 'M': " + sum);
		}
		catch(IOException e) {
			System.out.println("Erro - " + e.getMessage());
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro - " + e.getMessage());
		}

	}

}
