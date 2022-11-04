package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(new Locale("en", "US"));
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int num = sc.nextInt();
		
		for(int i = 1 ; i <= num ; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)?: ");
			char option = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String nameProduct = sc.nextLine();
			System.out.print("Price: ");
			Double priceProduct = sc.nextDouble();
			
			if(option == 'c') {
				Product product = new Product(nameProduct, priceProduct);
				products.add(product);
			}
			if(option == 'u') {
				System.out.println("Manufacture date(DD/MM/YYYY)");
				Date date = fmt.parse(sc.next());
				products.add(new UsedProduct(nameProduct, priceProduct, date));
			}
			if(option == 'i') {
				System.out.print("Customs fee: ");
				Double customFee = sc.nextDouble();
				Product product = new ImportedProduct(nameProduct, priceProduct, customFee);
				products.add(product);
			}
		}
		
		System.out.println("\nPRICE TAGS:");
		for(Product prod  : products) {
			System.out.println(prod.priceTag());
		}
		
		
	}

}
