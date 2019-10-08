package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Contract;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		Double totalvalue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, totalvalue);
		
		System.out.print("Enter number of installments: ");
		int months = sc.nextInt();
		
		ContractService cs = new ContractService(new PaypalService());
		cs.processContract(contract, months);
		
		System.out.println();
		System.out.println(contract);
		
		sc.close();
	}

}
