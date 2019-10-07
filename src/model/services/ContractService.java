package model.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private List<Installment> installments = new ArrayList<>();
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService() {}
	
	public void processContract(Contract contract, Integer months,OnlinePaymentService onlinePaymentService) {
		
		double installmentValue = 0.0;
		
		
		for (int m=1; m<= months; m++) {
			Date dateInstallment = contract.getDate();
			double installmentBaseValue = contract.getTotalvalue() / months;
			installmentValue = onlinePaymentService.paymentFee(onlinePaymentService.interest(installmentBaseValue, m));
			Installment inst = new Installment(dateInstallment, installmentValue);
			//System.out.println("" + inst.getDueDate() + " - " + inst.getAmount());
			installments.add(inst);
		}
		
		contract.setInstallments(installments);
		
	}
}
