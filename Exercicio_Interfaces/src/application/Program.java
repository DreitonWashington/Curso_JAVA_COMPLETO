package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre os dados do contrado:");
		System.out.print("Numero: ");
		Integer numeroContrato = Integer.parseInt(sc.nextLine());
		System.out.print("Data: ");
		LocalDate dateContract = LocalDate.parse(sc.nextLine(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.print("Valor do contrato: ");
		Double valorContrato = Double.parseDouble(sc.nextLine());
		System.out.println("Entre com número de parcelas: ");
		int numParcelas = sc.nextInt();
		
		Contract contrato = new Contract(numeroContrato, dateContract, valorContrato);
		ContractService service = new ContractService(new PaypalService());
		service.processContract(contrato, numParcelas);
		
		System.out.println("Parcelas: ");
		for(Installment inst : contrato.getInstallments()) {
			System.out.println(inst.getDueDate().format(fmt) + " - " + inst.getAmount());
		}
	}

}
