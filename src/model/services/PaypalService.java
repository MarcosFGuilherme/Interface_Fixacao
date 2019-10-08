package model.services;

public class PaypalService implements OnlinePaymentService {
	private static final double FREE_PERCENTAGE =  0.02;
	private static final double MONTHLY_INTEREST =  0.01;
	
	@Override
	public double paymentFee(double amount) {
		return amount * FREE_PERCENTAGE;
	}
	@Override
	public double interest(double amount, Integer months) {
		return amount * MONTHLY_INTEREST * months;
	}
}
