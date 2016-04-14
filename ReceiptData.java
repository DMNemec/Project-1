package POS_DAO;

import java.util.ArrayList;
import java.util.Calendar;



public class ReceiptData 
{
    private  String saleSku;
    private  String employee;
    private  ArrayList<InventoryItem> shopCart;
    private  String time;
    
    public Receipt()
	{
        	this.saleSku=null;
        	this.employee=null;
        	this.shopCart=null;
        	this.time=null;
   	}

    public ReceiptInfo(String saleSku, String employee, ArrayList<InventoryItem> shopCart)
	{
        	if(saleSku != null)this.saleSku=saleSku;
        	if(employee != null)this.employee=employee;
        	if(shopCart != null)this.shopCart=shopCart;
        	this.time=Calendar.getInstance().getTime().toString();

    	}
    
    public String getSaleSku()
	{
        	return saleSku;
    	}

    public String getEmployee()
	{
        	return employee;
    	}

    public String getTime()
	{
        	return time;
    	}

    public ArrayList<InventoryItem> getShopCart()
	{
        	return shopCart;
    	}

    public void setSaleSku(String sku)
	{
	        saleSku=sku;
    	}

    public void setEmpl(String per)
	{
        	employee=per;
    	}

    public void setTime(String date)
	{
        	time=date;
    	}

    public void setShopCart(ArrayList<InventoryItem> cart)
	{
        	shopCart=cart;
    	}
}
