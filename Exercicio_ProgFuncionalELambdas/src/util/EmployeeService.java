package util;

import java.util.List;
import java.util.function.Predicate;

import model.entities.Employee;

public class EmployeeService{
	
	public Double sumPrice(List<Employee> list , Predicate<Employee> criteria) {
		double sum = 0.0;
		for(Employee emp : list) {
			if(criteria.test(emp)){
				sum += emp.getSalary();
			}
		}
		return sum;
	}
	

}
