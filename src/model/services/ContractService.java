package model.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
		
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, Integer months) {
		double installmentBaseValue = contract.getTotalvalue() / months;
		
		for (int m=1; m<= months; m++) {
			Date dateInstallment = addMonths(contract.getDate(), m);
			double interestValue = installmentBaseValue + onlinePaymentService.interest(installmentBaseValue, m);
			double installmentValue = interestValue + onlinePaymentService.paymentFee(interestValue);
			contract.addInstallment(new Installment(dateInstallment, installmentValue));
		}
	}
	
	private  Date addMonths(Date date , int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
}
