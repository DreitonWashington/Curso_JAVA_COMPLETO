package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	
	private List<OrderItem> items = new ArrayList<OrderItem>();
	
	public Order() {
	}
	
	public Order(OrderStatus status, Client client) {
		this.moment = new Date();
		this.status = status;
		this.client = client;
	}
	

	public Date getMoment() {
		return moment;
	}

	public void setMoment() {
		this.moment = new Date();
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setOrderStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Client getClient() {
		return client;
	}

	public List<OrderItem> getItems() {
		return items;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double price = 0;
		for(OrderItem o : items) {
			price += o.subTotal();
		}
		return price;
	}
	
}
