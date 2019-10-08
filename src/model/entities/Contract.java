package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.utility.Utility;

public class Contract {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer number;
	private Date date;
	private Double totalvalue;

	private List<Installment> installments = new ArrayList<>();
	

	public Contract() {
	}

	public Contract(Integer number, Date date, Double totalvalue) {
		this.number = number;
		this.date = date;
		this.totalvalue = totalvalue;
		
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalvalue() {
		return totalvalue;
	}

	public void setTotalvalue(Double totalvalue) {
		this.totalvalue = totalvalue;
	}

	public List<Installment> getInstallments() {
		return installments;
	}

	public void addInstallment(Installment installment) {
		installments.add(installment);
	}

	public void removeInstallment(Installment installment) {
		installments.remove(installment);
	}
	
	public double getSummaryInstallments() {
		double sum = 0.00;
		for (Installment i : installments) {
			sum += i.getAmount();
		}
		return sum;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Contract data: "+"\n");
		sb.append(Utility.stringFix("",33,"=")+"\n");
		sb.append(Utility.stringFix(" number") + " = " + number +"\n");
		sb.append(Utility.stringFix(" date") + " = " + sdf.format(date) +"\n");
		sb.append(Utility.stringFix(" Total Value") + " = " + String.format("%.2f", totalvalue)  +"\n");
		sb.append("\n");
		if (installments.size() > 0 ) {
			sb.append("Installments data:\n");
			sb.append(Utility.stringFix("",33,"=")+"\n");
			sb.append(Utility.stringFix("Payment date ") + "   " + Utility.stringFix("Value")+"\n");
			sb.append(Utility.stringFix("",15,"-")+ "   " + Utility.stringFix("",15,"-")+"\n");
			for (Installment inst : installments ) {
				sb.append( Utility.stringFix(" " + sdf.format(inst.getDueDate())) +  "   " + String.format("%.2f", inst.getAmount()) + "\n");
			}
			sb.append(Utility.stringFix("",33,"-")+"\n");
			sb.append(Utility.stringFix("Total payment:") + "   " + Utility.stringFix(String.format("%.2f",getSummaryInstallments()))+"\n");
		}
		return sb.toString();
	}
}
