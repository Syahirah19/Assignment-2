package Controller;


import java.util.Date;
import Model.Order;


public class OrderProcess {

	public Order calculation(Order order) {

		Date currentDateTime = new Date();

		double serviceTax = order.getSubTotal()*6/100;

		double sum = order.getSubTotal()+ serviceTax;
		double round = Math.round(sum * 20) /20.0;
		double difference = (sum-round);
		String roundingString = String.format("%.2f", difference);
		double rounding = Double.parseDouble(roundingString);

		if(rounding < 0)
			rounding = -1*rounding;
		else
			rounding = -1*rounding;

		double grandTotal = order.getSubTotal() + serviceTax + rounding;
		double change = order.getTenderedCash() - grandTotal;

		order.setTransactionDate(currentDateTime);
		order.setServiceTax(serviceTax);
		order.setRounding(rounding);
		order.setGrandTotal(grandTotal);
		order.setChange(change);

		return order;
	}


}
