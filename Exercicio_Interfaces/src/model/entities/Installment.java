package model.entities;

import java.time.LocalDate;

public class Installment {
	
	private LocalDate dueDate;
	private Double amount;
	
	public Installment() {
	}
	
	public Installment(Double amount, LocalDate date) {
		this.amount = amount;
		this.dueDate = date;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
}
