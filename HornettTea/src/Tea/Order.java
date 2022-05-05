package Tea;

import java.sql.Date;
import java.util.ArrayList;


public class Order {

	private int OrderId;
	private int orderNumber;
	private Date transactionDate;
	private ArrayList totalOrderItem; //kat sini aku tak tahu nak declare mcm mana
	private double subTotal;
	private double ServiceTax;
	private double rounding;
	private double grandTotal;
	private double tenderedCash;
	private double change;
	
	public void setOrderId	(int orderId)
	{
		this.OrderId = orderId;
	}

	public int getOrderId	()
	{
		return OrderId;
	}

	public void setOrderNumber (int orderNumber)
	{
		this.orderNumber = orderNumber;
	}

	public int getOrderNumber ()
	{
		return orderNumber;
	}
	
	public void setTransactionDate (Date transactionDate)
	{
		this.transactionDate= transactionDate;
	}
	
	public Date getTransactionDate ()
	{
		return transactionDate;
	}

	public void setTotalOrderItem (ArrayList totalOrderItem)
	{
		this.totalOrderItem = totalOrderItem;
	}

	
	public ArrayList getTotalOrderItem ()
	{
		return totalOrderItem;
	}
	
	public void setSubTotal (double subTotal)
	{
		this.subTotal = subTotal;
	}

	public double getSubTotal ()	
	{
		return subTotal;
	}

	public void setServiceTax (double serviceTax)
	{
		this.ServiceTax = serviceTax;
	}

	public double getServiceTax ()
	{
		return ServiceTax;
	}

	public void setRounding (double rounding)
	{	
		this.rounding = rounding;
	}

	public double getRounding ()
	{
		return rounding;
	}

	public void setGrandTotal (double grandTotal)
	{
		this.grandTotal = grandTotal ;
	}

	public double getGrandTotal ()
	{
		return grandTotal;	
	}

	public void setTenderedCash (double tenderedCash)
	{
		this.tenderedCash = tenderedCash;
	}

	public double getTenderedCash ()
	{
		return tenderedCash;
	}

	public void setChange (double change)
	{
		this.change = change;
	}

	public double getChange ()
	{
		return change;
	}
}
