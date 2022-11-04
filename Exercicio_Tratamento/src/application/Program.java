package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.NotEnoughException;
import model.exceptions.WithdrawException;
import model.exceptions.ZeroBalanceException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			Integer numberAccount = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holderAccount = sc.nextLine();
			System.out.print("Initial balance: ");
			Double initBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withDLimit = sc.nextDouble();
			
			Account acc = new Account(numberAccount, holderAccount, initBalance, withDLimit);
			
			System.out.print("\nEnter amount for withdraw: ");
			Double amtWithdraw = sc.nextDouble();
			acc.withdraw(amtWithdraw);
			
			System.out.println("New balance: " + acc.getBalance());
		}
		catch(InputMismatchException e) {
			System.out.println("Erro - valor invalido");
		}
		catch(ZeroBalanceException e) {
			System.out.println(e.getMessage());
		}
		catch(WithdrawException e) {
			System.out.println(e.getMessage());
		}
		catch(NotEnoughException e) {
			System.out.println(e.getMessage());
		}
		catch(RuntimeException e ) {
			System.out.println("Erro inexperado");
		}
	}

}
