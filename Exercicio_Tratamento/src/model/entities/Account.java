package model.entities;

import model.exceptions.NotEnoughException;
import model.exceptions.WithdrawException;
import model.exceptions.ZeroBalanceException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
	}
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(Double amount) {
		this.balance += amount;
	}
	
	public void withdraw(Double amount) throws WithdrawException, ZeroBalanceException, NotEnoughException {
		if(amount > withdrawLimit ) {
			throw new WithdrawException ("Erro - Quantia maior que o limite de saque");
		}
		if(balance <= 0) {
			throw new ZeroBalanceException ("Erro - Conta sem saldo para saque");
		}
		if(amount > balance) {
			throw new NotEnoughException ("Erro - Quantia maior que o saldo");
		}
		this.balance -= amount;
	}
}
