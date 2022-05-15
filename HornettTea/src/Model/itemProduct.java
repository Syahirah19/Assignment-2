package Model;

//model

public class itemProduct {

	private int itemProductId; 
	private String name;
	private String LabelName;
	private double price;

	public void setItemProductId(int itemProductId)
	{
		this.itemProductId= itemProductId;
	}

	public int getItemProductId()
	{
		return itemProductId;
	}

	public void setName (String name)
	{	
		this.name = name;
	}

	public String getName ()
	{	
	
		return name;
	}

	public void setLabelName (String LabelName)
	{
		this.LabelName = LabelName;
	}

	public String getLabelName ()
	{
		return LabelName;
	}

	public void setPrice (double price)
	{
		this.price = price;
	}

	public double getPrice ()
	{
		return price;
	}	
}
