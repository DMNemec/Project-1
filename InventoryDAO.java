package POS_DAO;

import pos.InventoryItem;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InventoryDAO 
{
        
    public InventoryDAO(String dataBasePath)
	{
        
        	try 
		{
            
            		inventDB=DriverManager.getConnection(dataBasePath);
            		stmt= inventDB.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                    ResultSet.CONCUR_READ_ONLY);
        	}
		 catch (SQLException ex) 
		{
            		Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
     		}
    	}

     public String sizeOfInv()
	{
        	String totalInv="";
        	try
		 {
            		numb=message.executeQuery("select COUNT(*) from INVENTORY");
        		numb.next();
 	           	totalInv =numb.getString(1);
        	  }
		 catch (SQLException ex)
		 {
        	    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        	 }
        
   	     return totalInv;
        }


   public ArrayList<String> currentCatg()
	{
        	ArrayList<String> cats= new ArrayList<>();
        	String dept;
        	try
		 {
            		numb=message.executeQuery("select * from Cats");
  		        while(numb.next())
			{
                		dept=numb.getString("Cats.Cat");
		                if(!cats.contains(dept))categories.add(dept);
		        }
        	 } 
		catch (SQLException ex) 
		{
           		 Logger.getLogger(InventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
	        }
       		 return cats;
	}

    public InventoryItem itemSearch(String sku) throws SQLException
	 {
         	InventoryItem info=new InventoryItem();
      
      		numb=message.executeQuery("select * from INVENTORY,ItemCat,Cats where INVENTORY.ID='"
                              +sku+"'AND INVENTORY.ID=ItemCat.Item AND ItemCat.Cat=Cats.Cat");
      		numb.next();
        	result.setName(numb.getString("INVENTORY.NAME"));
        	result.setActive(numb.getString("INVENTORY.ACTIVE"));
        	result.setCategory(numb.getString("Cats.Cat"));
       		result.setDesc(numb.getString("INVENTORY.DESC"));
        	result.setId(numb.getString("INVENTORY.ID"));
        	result.setOldID(numb.getString("INVENTORY.OLDID"));
        	result.setPrice(numb.getString("INVENTORY.PRICE"));
        	result.setQty(numb.getString("INVENTORY.QNTY"));
                    
        return info;
    } 

	
 


 public ArrayList<InventoryItem> objectInfo(String name, String category, String sku,boolean correct) 
  {
        ArrayList<InventoryItem> answer=new ArrayList<>();
        if(!name.isEmpty())
	{
            SQL="select * from INVENTORY,ItemCat,Cats where INVENTORY.NAME='"+name+"'AND INVENTORY.ID=ItemCat.Item AND ItemCat.Cat=Cats.Cat ";
     
	    if(!category.isEmpty())SQL+=("and Cats.Cat='"+category+"'AND INVENTORY.ID=ItemCat.Item AND ItemCat.Cat=Cats.Cat ");
            
	    if(!sku.isEmpty())SQL+=("and INVENTORY.ID='"+sku+"'AND INVENTORY.ID=ItemCat.Item AND ItemCat.Cat=Cats.Cat ");
        }
	else if(!category.isEmpty())
	{
                SQL="select * from INVENTORY,ItemCat,Cats where Cats.Cat='"+category+"'AND INVENTORY.ID=ItemCat.Item AND ItemCat.Cat=Cats.Cat";
                
		if(!sku.isEmpty())SQL+=("and INVENTORY.ID='"+sku+"'AND INVENTORY.ID=ItemCat.Item AND ItemCat.Cat=Cats.Cat");
        }
	else if(!sku.isEmpty())SQL="select * from INVENTORY,ItemCat,Cats where INVENTORY.ID='"+sku+"'AND INVENTORY.ID=ItemCat.Item AND ItemCat.Cat=Cats.Cat";
           
        try 
	{
            numb=message.executeQuery(SQL);
            while(numb.next())
	     {
                if(correct)
		{
                    InventoryItem currentRow=new InventoryItem();
                    currentRow.setName(numb.getString("INVENTORY.NAME"));
                    currentRow.setActive(numb.getString("INVENTORY.ACTIVE"));
                    currentRow.setDesc(numb.getString("INVENTORY.DESC"));
                    currentRow.setId(numb.getString("INVENTORY.ID"));
                    currentRow.setCategory(numb.getString("Cats.Cat"));
                    currentRow.setOldID(numb.getString("INVENTORY.OLDID"));
                    currentRow.setPrice(numb.getString("INVENTORY.PRICE"));
                    currentRow.setQty(numb.getString("INVENTORY.QNTY"));
                    answer.add(currentRow);
                }
		else
		{
                    if("TRUE".equals(numb.getString("INVENTORY.Active")))
			{
                        InventoryItem currentRow=new InventoryItem();
                        currentRow.setName(numb.getString("INVENTORY.NAME"));
                        currentRow.setActive(numb.getString("INVENTORY.ACTIVE"));
                        currentRow.setDesc(numb.getString("INVENTORY.DESC"));
                        currentRow.setId(numb.getString("INVENTORY.ID"));
                        currentRow.setCategory(numb.getString("Cats.Cat"));
                        currentRow.setOldID(numb.getString("INVENTORY.OLDID"));
                        currentRow.setPrice(numb.getString("INVENTORY.PRICE"));
                        currentRow.setQty(numb.getString("INVENTORY.QNTY"));
                        answer.add(currentRow);
                	}
                }
            }

        } 
	catch (SQLException ex) 
	{
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return answer;
    }


public ArrayList<InventoryItem> itemInfo(boolean correct) {
        ArrayList<InventoryItem> answer=new ArrayList<>();
        try 
	{
            numb=message.executeQuery("select * from INVENTORY,ItemCat,Cats where INVENTORY.ID=ItemCat.Item "
                    + "AND ItemCat.Cat=Cats.Cat");
            while(numb.next())
	    {
                if(correct)
		{
                    InventoryItem currentRow=new InventoryItem();
                    currentRow.setName(numb.getString("INVENTORY.NAME"));
                    currentRow.setActive(numb.getString("INVENTORY.ACTIVE"));
                    currentRow.setDesc(numb.getString("INVENTORY.DESC"));
                    currentRow.setId(numb.getString("INVENTORY.ID"));
                    currentRow.setCategory(numb.getString("Cats.Cat"));
                    currentRow.setOldID(numb.getString("INVENTORY.OLDID"));
                    currentRow.setPrice(numb.getString("INVENTORY.PRICE"));
                    currentRow.setQty(numb.getString("INVENTORY.QNTY"));
                    answer.add(currentRow);
                }
		else
		{
                    if("TRUE".equals(numb.getString("INVENTORY.Active"))){
                        InventoryItem currentRow=new InventoryItem();
                        currentRow.setName(numb.getString("INVENTORY.NAME"));
                        currentRow.setActive(numb.getString("INVENTORY.ACTIVE"));
                        currentRow.setDesc(numb.getString("INVENTORY.DESC"));
                        currentRow.setId(numb.getString("INVENTORY.ID"));
                        currentRow.setCategory(numb.getString("Cats.Cat"));
                        currentRow.setOldID(numb.getString("INVENTORY.OLDID"));
                        currentRow.setPrice(numb.getString("INVENTORY.PRICE"));
                        currentRow.setQty(numb.getString("INVENTORY.QNTY"));
                        answer.add(currentRow);
                    }
                }         
            }
            
        } 
	catch (SQLException ex) 
	{
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return answer;
    }

  public void wakeItem(String id) throws SQLException
    {
        message.execute("update INVENTORY set INVENTORY.Active='TRUE' where INVENTORY.ID='"+id+"'");
    }  

   public InventoryItem updateInfo(InventoryItem item, String oldName) throws SQLException
	 {
        
        	InventoryItem old=itemsResult("","",oldName,true).get(0);
        
        	if(old.getCategory().equals(item.getCategory()))
		{
            
            		message.execute("update INVENTORY set INVENTORY.NAME='"+item.getName()+
                    "',INVENTORY.DESC='"+item.getDesc()+"',INVENTORY.PRICE='"+item.getPrice()+
                    "', INVENTORY.QNTY='"+item.getQty()+"' where INVENTORY.ID='"+oldName+"'");
 	        }
		else
		{
            		item.setId(newItemID(item.getCategory()));
            		
			if(old.getOldID() == null)old.setOldID("No previous.");
            		
			message.execute("update INVENTORY set INVENTORY.NAME='"+old.getName()+" -"+Calendar.getInstance().getTime()+
                    	"',INVENTORY.ACTIVE='FALSE',OLDID='"+old.getOldID()+"'  where INVENTORY.ID='"+old.getId()+"'");    
            
	 	        message.execute("insert into INVENTORY (INVENTORY.ID,INVENTORY.NAME,INVENTORY.PRICE,"
     	               	+ "INVENTORY.QNTY,INVENTORY.DESC,"
        	        + "INVENTORY.ACTIVE,INVENTORY.OLDID) values('"
                    	+item.getId()+"','"+item.getName()+"','"+item.getPrice()+"','"
                    	+item.getQty()+"','"+item.getDesc()+"','TRUE','"+
                    	oldName+"')"); 

	            	message.execute("insert into ItemCat (ItemCat.Item,ItemCat.Cat) values('"+item.getId()+"','"+item.getCategory()+"')");
        	}
	        return item;
	}

  public String newItem(String dept) 
    {
        int sku;
        String newName="";
        boolean empty=true;
        int count=0;
        
	try
	 {
            sqlStat="select * from INVENTORY,ItemCat,Cats where Cats.CAT='"+dept+"' AND INVENTORY.ID=ItemCat.Item and ItemCat.Cat=Cats.Cat";
            numb=message.executeQuery(sqlStat);
            while(numb.next())
		{
                	empty=false;
                	count++;
            	}
            if(empty==true)
		{
                	newName=dept.substring(0, 3)+"-10";
            	}
            else
		{
                
                	sku=count+100;
                	newName=dept.substring(0,3)+"-"+String.valueOf(sku);
            	}
         } 
	catch (SQLException ex)
	 {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        return newName;
   }

   public void addDept(String dept) throws SQLException
    {

            message.execute("insert into Cats (Cats.Cat) values('"+dept+"')");

    }

    public void newItemDB(InventoryItem object) throws SQLException
    {
        message.execute("insert into INVENTORY (INVENTORY.ID,INVENTORY.NAME,INVENTORY.PRICE,"
                + "INVENTORY.QNTY,INVENTORY.DESC,INVENTORY.ACTIVE,INVENTORY.OLDID)"
                + " values('"+object.getId()+"','"+object.getName()+"','"+object.getPrice()
                + "','"+object.getQty()+"','"+object.getDesc()+ "','TRUE','')"); 

        message.execute("insert into ItemCat (ItemCat.Item,ItemCat.Cat) values('"+object.getId()+"','"+object.getCategory()+"')");
    }
    

    public void deleteCat(String dept) throws SQLException
    {

            message.execute("delete from Cats where Cats.Cat='"+dept+"'");

    }

   public void removeItem(String id) throws SQLException
    {
        message.execute("update INVENTORY set INVENTORY.Active='FALSE' where INVENTORY.ID='"+id+"'");
    }
    

    //Declarations
    private Connection inventDB;
    private Statement message;
    private String sqlStat;
    private ResultSet numb;
    //End
}







