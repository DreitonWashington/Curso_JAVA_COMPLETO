package entities;

public class OrderItem {
	private int quantity;
	private double price;
	private Product product;
	
	public OrderItem(int quantity, double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice() {
		this.price = product.getPrice();
	}

	public double getProductPrice() {
		return product.getPrice();
	}
	
	public String getProductName() {
		return product.getName();
	}
	
	public double subTotal() {
		double sum;
		sum = price * quantity;
		return sum;
	}
}
