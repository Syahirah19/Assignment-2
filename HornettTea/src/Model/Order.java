package Model;

import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable /*allows us to convert an Object to stream that we can 
send over the network or save it as file or store in DB for later usage*/
{

	private static final long serialVersionUID = 1L;
	private int orderId;
	private int orderNumber;
	private Date transactionDate;
	private ArrayList<OrderedItem> orderItems;
	private int totalOrderItem;
	private double subTotal;
	private double serviceTax;
	private double rounding;
	private double grandTotal;
	private double tenderedCash;
	private double change;

	public Order() 
	{}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public ArrayList<OrderedItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(ArrayList<OrderedItem> orderItems) {
		this.orderItems = orderItems;
	}

	public int getTotalOrderItem() {
		return totalOrderItem;
	}

	public void setTotalOrderItem(int totalOrderItem) {
		this.totalOrderItem = totalOrderItem;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getServiceTax() {
		return serviceTax;
	}

	public void setServiceTax(double serviceTax) {
		this.serviceTax = serviceTax;
	}

	public double getRounding() {
		return rounding;
	}

	public void setRounding(double rounding) {
		this.rounding = rounding;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public double getTenderedCash() {
		return tenderedCash;
	}

	public void setTenderedCash(double tenderedCash) {
		this.tenderedCash = tenderedCash;
	}

	public double getChange() {
		return change;
	}

	public void setChange(double change) {
		this.change = change;
	}

}
