package POS_DAO;

import pos.InventoryItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import pos.Receipt;



public class ShoppingCart 
  {
    
    public ShoppingCart(String route)
	{
        
           try
	   {
            
           	 accBase=DriverManager.getConnection(route);
            	 message= accBase.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                    ResultSet.CONCUR_READ_ONLY);
           }
	    catch (SQLException ex)
	   {
             Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
           }
       }

   public void getCount(ArrayList<InventoryItem> shopCart) throws SQLException 
	{
        	for (InventoryItem shopCart1 : shopCart)
		 {
            		sqlStat = "select * from INVENTORY where INVENTORY.ID='" + shopCart1.getId() + "'";
	            	numb=message.executeQuery(sqlStat);
               		numb.next();
            
			int count= Integer.valueOf(numb.getString("QNTY"));
            		message.execute("update INVENTORY set INVENTORY.QNTY='" + String.valueOf(count + Integer.valueOf(shopCart1.getQty())) + "' where ID='" + shopCart1.getId() + "'");
 	          }
        }

 public void changeQuant(ArrayList<InventoryItem> shopCart) throws SQLException 
	{
           for (InventoryItem shopCart1 : shopCart)
		{
            		sqlStat = "select * from INVENTORY where INVENTORY.ID='" + shopCart1.getId() + "'";
            		numb=message.executeQuery(sqlStat);
            		numb.next();
            
			int numb= Integer.valueOf(numb.getString("QNTY"));
            		message.execute("update INVENTORY set INVENTORY.QNTY='" + String.valueOf(numb - Integer.valueOf(shopCart1.getQty())) + "' where ID='" + shopCart1.getId() + "'");
                }
	}

 public InventoryItem getObject(String sku) throws SQLException 
	{
        	InventoryItem info=new InventoryItem();
      
     		numb=message.executeQuery("select * from INVENTORY,ItemCat,Cats where INVENTORY.ID='"+sku+
                 "' and INVENTORY.ID=ItemCat.Item and ItemCat.Cat=Cats.Cat");
        	
		numb.next();
        	info.setName(numb.getString("NAME"));
        	info.setActive(numb.getString("ACTIVE"));
      	  	info.setCategory(numb.getString("CAT"));
        	info.setDesc(numb.getString("DESC"));
        	info.setId(numb.getString("ID"));
        	info.setOldID(numb.getString("OLDID"));
        	info.setPrice(numb.getString("PRICE"));
        	info.setQty(numb.getString("QNTY"));
                    
	        return info;
      }

 public void receiptInfo(Receipt data) 
	{

	        try
		 {
            		message.execute("insert into RECEIPTS (RECEIPTS.ID,RECEIPTS.DATE,RECEIPTS.SELLER) values('"+data.getSaleID()+"','"
                    	+Calendar.getInstance().getTime()+"','"+data.getSeller()+"')");
            
			for(int index=0;index<data.getCart().size();index++)
			{
                
				int itemTotal=Integer.valueOf(data.getCart().get(index).getQty())*Integer.valueOf(data.getCart().get(index).getPrice());
                		
				message.execute("insert into ReceiptSellerItem (ReceiptSellerItem.receipt,ReceiptSellerItem.items,"
                        	+ "ReceiptSellerItem.QNTY,ReceiptSellerItem.PRICE,ReceiptSellerItem.UNITPRICE) "
                        	+ "values('"+data.getSaleID()+"','"+data.getCart().get(index).getId()+"','"
                       		+data.getCart().get(index).getQty()+"','"+itemTotal+"','"+data.getCart().get(index).getPrice()+"')");
            		}
      		  }
		 catch (SQLException ex) 
		  {
           		 Logger.getLogger(ShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
       		 }
        
    	}
    
   
    private Connection accBase;
    private Statement message;
    private String sqlStat;
    private ResultSet numb;
    
}











    


