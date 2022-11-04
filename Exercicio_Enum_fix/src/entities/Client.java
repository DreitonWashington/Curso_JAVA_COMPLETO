package entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import entities.enums.OrderStatus;

public class Client {
	
	private String name;
	private String email;
	private Date birthDate;
	private Order order = new Order();
	
	public Client() {
	}

	public Client(String name, String email, Date birthDate) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = dateFormat.format(this.birthDate);
		return dataFormatada;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
