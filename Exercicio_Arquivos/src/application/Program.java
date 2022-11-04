package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Product;

public class Program {

	public static void main(String[] args) {
		
		String strPath = "D:\\WOut\\ItensVendidos.txt";
		String destPath = "D:\\WOut\\Out\\Summary.txt";
		Scanner sc = null;
		List<Product> produtos = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(strPath))){
			String line = br.readLine();
			
			while(line != null) {
					System.out.println(line);
					String[]produtoInfo = line.split(",\\s");
					String name = produtoInfo[0];
					Double price = Double.parseDouble(produtoInfo[1]);
					Integer quantity = Integer.parseInt(produtoInfo[2]);
					
					Product produto = new Product(name, price, quantity);
					produtos.add(produto);
					line = br.readLine();
			}
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(destPath))){
				for(Product produ : produtos) {
					String name = produ.getName();
					Double price = produ.totalPrice();
					bw.write(name + ", " +price);
					bw.newLine();
				}
				System.out.println("-----------------\nArquivo criado\n-----------------");
			}
			catch(IOException e ) {
				System.out.println("Erro na criação do arquivo no path: D:\\WOut\\Out\\");
			}	
		}
		catch(IOException e ) {
			System.out.println("Erro");
		}
		
	}

}
