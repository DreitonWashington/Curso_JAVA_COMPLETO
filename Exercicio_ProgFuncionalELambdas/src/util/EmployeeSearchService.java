package util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import model.entities.Employee;

public class EmployeeSearchService {
	public List<String> employeeSearch(List<Employee> list , Predicate<Employee> criteria ) {
		List<String> emails = new ArrayList<>() ;
		for(Employee emp : list) {
			if(criteria.test(emp)) {
				emails.add(emp.getEmail());
			}
		}
		return emails;
	}
}
