package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	private OnlinePaymentService onlinePaymentService;
	
	
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}



	public void processContract(Contract contrato, int parcela){
		Contract contract = contrato;
		int parcelas = parcela;
		LocalDate date = contrato.getDate();
		Double total;
		for(int i = 1 ; i <= parcelas ; i++) {
			Double valorParc = contract.getTotalValue()/parcelas;
			Double amountInterest = onlinePaymentService.interest(valorParc, i);
			total = valorParc + amountInterest;
			Double amountWithFee = onlinePaymentService.paymentFee(total);
			total += amountWithFee;
			LocalDate dateParc = date.plusMonths(i);
			contrato.addInstallment(new Installment(total, dateParc));
		}
	}
}
