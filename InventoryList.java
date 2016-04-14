package POS_DAO;

public class InventoryList 
{

    
    public InventoryList()
	{
        	sku="";
        	name="";
        	categ="";
       	 	description="";
        	active="";
       	 	total="";
        	cost="";
        	oldSku=""; 
    	}

    public InventoryList(String sku,
                        String name,
                        String categ,
                        String description,
                        String active,
                        String total,
                        String cost,
                        String oldSku)
	{
        	this.sku=sku;
        	this.name=name;
        	this.categ=categ;
        	this.description=description;
        	this.active=active;
        	this.total=total;
        	this.cost=cost;
        	this.oldId=oldId; 
    	}

    public String getSku ()
	{
        	return sku;        
    	}

    public String getName ()
	{
        	return name;
    	}

    public String getCateg ()
	{
        	return categ;
    	}

    public String getOldSku ()
	{
        	return oldSku;
    	}

    public String getActive ()
	{
        	return active;
    	}
	
    public String getCost ()
	{
        	return cost;
    	}

    public String getTotal ()
	{
        	return total;
    	}

    public String getDesc ()
	{
        	return description;
    	}

    public void setName (String name)
	{
        	this.name=name;
    	}

    public void setSku (String sku)
	{
        	this.sku=sku;
    	}
	
    public void setPrice (String cost)
	{
        	this.cost=cost;
    	}

    public void setTotal (String total)
	{
        	this.total=total;
    	}

    public void setDesc (String description)
	{
        	this.description=description;
    	}

    public void setCateg (String categ)
	{
        	this.categ=categ;
    	}

    public void setPrevSku (String oldSku)
	{
        	this.olSku=oldSku;
    	}
	
    public void setActive (String active)
	{
        	this.active=active;
    	}

    public boolean isEmpty()
	{
        	return "".equals(sku);
    	}

    @Override
    public String toString()
	{
        	return name.split("-")[0]+"    "+total+"     "+cost+"$";
   	}
    
    private String sku;
    private String name;
    private String categ;
    private String description;
    private String active;
    private String total;
    private String cost;
    private String oldSku;
}
