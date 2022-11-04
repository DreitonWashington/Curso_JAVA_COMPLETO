package model.entities;

import java.util.Objects;

public class Student {
	
	private int Id;
	
	public Student() {
	}
	
	public Student(int id) {
		this.Id = id;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Id == other.Id;
	}
	
	
}
