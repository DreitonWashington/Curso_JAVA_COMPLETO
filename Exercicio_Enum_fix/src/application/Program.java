package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat fmt1 = new SimpleDateFormat("dd/MM/yyyy"); 
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date(DD/MM/YYYY): ");
		Date dateB = fmt1.parse(sc.next());
		Client cliente = new Client(name, email,dateB);		
		
		System.out.println("Enter data order:");
		System.out.print("Status: ");
		sc.nextLine();
		String orderStatus = sc.nextLine(); 
		System.out.print("How many items to this order?: ");
		int hm = sc.nextInt();
		
		Order od = new Order(OrderStatus.valueOf(orderStatus), cliente);
		
		for(int i = 1 ; i <= hm ; i++) {
			System.out.print("Enter #" + i + " item data:\n");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quant = sc.nextInt();
			
			Product produto = new Product(productName,productPrice);
			OrderItem orderItem = new OrderItem(quant, productPrice, produto);
			od.addItem(orderItem);
		}
		System.out.println("\nORDER SUMMARY:");
		System.out.println("Order moment: " + od.getMoment());
		System.out.println("Order status: " + od.getStatus());
		System.out.println("Client: " + cliente.getName() + " (" + cliente.getBirthDate() + ") - " + cliente.getEmail());
		System.out.println("Order items:");
		for(OrderItem c : od.getItems() ) {
			System.out.println(c.getProductName() + ", Quantity: " + c.getQuantity() + ", SubTotal: $" + c.subTotal());
		}
		System.out.println("Total price: $" + od.total());
	}

}
