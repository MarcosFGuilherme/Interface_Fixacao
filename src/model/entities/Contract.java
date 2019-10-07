package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.services.OnlinePaymentService;

public class Contract {
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer number;
	private Date date;
	private Double totalvalue;

	private List<Installment> installments;
	

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

	public void setInstallments(List<Installment> installments) {
		this.installments = installments;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(" number= " + number +"\n");
		sb.append(" date= " + sdf.format(date) +"\n");
		sb.append(" Total Value= " + String.format("%.2f", totalvalue)  +"\n");
		sb.append("\n");
		
		sb.append("Data Installments:\n");
		for (Installment inst : installments ) {
			sb.append( " " + sdf.format(inst.getDueDate()) +  " - " + String.format("%.2f", inst.getAmount()) + "\n");
		}
		
		return sb.toString();
	}
}
