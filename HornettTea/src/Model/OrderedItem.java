package Model;

import java.sql.Date;


//model
public class OrderedItem {
	private int orderItemId;
	private itemProduct itemProduct;
	private int quantity;
	private float subTotalAmount;
	private int sequenceNumber;
	private String orderStatus;
	private Date readyTime;

	public void setOrderItemId (int orderItemId)
	{
		this.orderItemId = orderItemId;
	}

	public int getOrderItemId ()
	{
		return orderItemId;
	}

	public void setItemProduct (itemProduct itemProduct)
	{
		this.itemProduct = itemProduct;
	}

	public itemProduct getItemProduct ()	
	{
		return itemProduct;
	}

	public void setQuantity (int quantity)
	{
		this.quantity = quantity;
	}
	
	public int getQuantity ()
	{
		return quantity;
	}

	public void setSubTotalAmount (float subTotalAmount)
	{
		this.subTotalAmount = subTotalAmount;
	}

	public float getSubTotalAmount ()
	{
		return subTotalAmount;
	}

	public void setOrderStatus (String orderStatus)
	{
		this.orderStatus = orderStatus;
	}

	public String getOrderStatus ()
	{
		return orderStatus;
	}	

	public void setReadyTime (Date readyTime)
	{
		this.readyTime = readyTime;
	}

	public Date getReadyTime ()
	{
		return readyTime;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

}
