
package PO_DAO;

import pos.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EmployeeDataBase {
    
   
    public EmployeeDataBase(String dataBaseRoute) 
	{
        
        	try 
		{
            
            		accBase=DriverManager.getConnection(dataBaseRoute);
	                message= accBase.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                    ResultSet.CONCUR_READ_ONLY);
        	}
		catch (SQLException ex)
		{
           	 Logger.getLogger(EmployeeDataBase.class.getName()).log(Level.SEVERE, null, ex);
        	}
    	}



 public ArrayList<User> empData(boolean correct)
	 {
        	ArrayList<User> answer=new ArrayList<>();
        	try
		 {

	       		numb=message.executeQuery("select * from LOGINTABLE1");
            		
		    	while(numb.next())
			{
                		if(correct==false)
				{
                    			if("TRUE".equals(numb.getString("Active")))
					{
                        			User dataRows=new User();
                       				dataRows.setUsername(numb.getString("USERNAME"));
                        			dataRows.setDept(numb.getString("ACCESS"));
                        			dataRows.setID(numb.getString("ID"));
                        			dataRows.setOldID(numb.getString("OLDID"));
                        			dataRows.setActive(numb.getString("Active"));
                        			dataRows.setPassword(numb.getString("PASSWORD"));
                        			answer.add(dataRows);
                    			} 
                		}
				else
				{
                    			User dataRows=new User();
                    			dataRows.setUsername(numb.getString("USERNAME"));
                    			dataRows.setDept(numb.getString("ACCESS"));
                    			dataRows.setID(numb.getString("ID"));
                    			dataRows.setOldID(numb.getString("OLDID"));
                    			dataRows.setActive(numb.getString("Active"));
                    			dataRows.setPassword(numb.getString("PASSWORD"));
                    			result.add(dataRows);
                		}
         	  	 }
        	}
		 catch (SQLException ex) 
		{
            		Logger.getLogger(EmployeeDataBase.class.getName()).log(Level.SEVERE, null, ex);
      		}
        	return answer;
    	}

   public User getUserInfo(String passPhrase) throws SQLException
	{
        	User answer=new User();
      
      		  numb=message.executeQuery("select * from LOGINTABLE1 where ID='"+ passPhrase +"'");
       		  numb.next();
        	  answer.setUsername(numb.getString("USERNAME"));
        	  answer.setDept(numb.getString("ACCESS"));
        	  answer.setID(numb.getString("ID"));
        	  answer.setActive(numb.getString("Active"));
        	  answer.setOldID(numb.getString("OLDID"));
     		  answer.setPassword(numb.getString("PASSWORD"));
            
        	return answer;
    	}


   
    
    public ArrayList<User> EmplInfo(String empName, String name, String empIds, boolean correct)
	 {
      		  ArrayList<User> answer = new ArrayList<>();
        	  if(!empName.isEmpty())
			{
            			sqlStat="select * from LOGINTABLE1 where USERNAME='"+ userN +"'";
          			if(!name.isEmpty()) SQL +=("and ACCESS='"+name+"'");
            			if(!empIds.isEmpty()) SQL +=("and ID='"+ empIds +"'");
            		}
			else if(!name.isEmpty())
			{
                		sqlStat="select * from LOGINTABLE1 where ACCESS='"+ name +"'";
     			        if(!empIds.isEmpty()) SQL +=("and ID='"+ empIds+"'");
    		    }
		else if(!empIds.isEmpty()) SQL="select * from LOGINTABLE1 where ID='"+ empIds +"'";
           
    	    try 
		{
            		numb=message.executeQuery(sqlStat);
            
            		while(numb.next())
			{
                		if(correct==false)
				{
                    			if("TRUE".equals(numb.getString("Active")))
					{
                        			User dataRows=new User();
                        			dataRows.setUsername(numb.getString("USERNAME"));
                        			dataRows.setDept(numb.getString("ACCESS"));
                        			dataRows.setID(numb.getString("ID"));
                        			dataRows.setOldID(numb.getString("OLDID"));
                        			dataRows.setActive(numb.getString("Active"));
                        			dataRows.setPassword(numb.getString("PASSWORD"));
                        			result.add(dataRows);
                    			}
                		}
				else
				{
						User dataRows=new User();
                        			dataRows.setUsername(numb.getString("USERNAME"));
                        			dataRows.setDept(numb.getString("ACCESS"));
                        			dataRows.setID(numb.getString("ID"));
                        			dataRows.setOldID(numb.getString("OLDID"));
                        			dataRows.setActive(numb.getString("Active"));
                        			dataRows.setPassword(numb.getString("PASSWORD"));
                        			result.add(dataRows);
                  		  	
                		}
            		}
        	} 
		catch (SQLException ex) 
		{
            		Logger.getLogger(EmployeeDataBase.class.getName()).log(Level.SEVERE, null, ex);
        	}
        
        return answer;
    }
   

    public void userAct(String usrName) throws SQLException
	{
        	message.execute("update LOGINTABLE1 set Active='TRUE' where ID='"+ usrName +"'");
    	}

    public String addNewUsername(String name)
	{
        	int digit; 
		String createdId="";
		boolean isEmpty = true; 
		int counter = 0;
        
		try
		 {
            		sqlStat="select * from LOGINTABLE1 where ACCESS = '" + name +"'";
          		numb=message.executeQuery(sqlStat);
            		
			while(numb.next())
			{
                		isEmpty=false;
				counter++;
            		}
	
        	       if(isEmpty==true)
			{
                		switch(name)
				{
                    			case "Sales": name ="S-"; 
					break;
                    			case "Inventory": name="I-"; 
					break;
                    			case "Management": name="M-"; 
					break;
                		}
                	createdId=name+"2016";
            		}
            		else
			{
                		digit=counter+100000+1;
                		createdId=name.substring(0, 1) + "-" + String.valueOf(digit);
           		}
        	}
		 catch (SQLException ex)
		{
            		Logger.getLogger(EmployeeDataBase.class.getName()).log(Level.SEVERE, null, ex);
       		}
        return createdId;
    	}

   public void addNewEmp(String userName,String depNum, String usrId,String passPhrase) throws SQLException
	{
        	message.execute("insert into LOGINTABLE1 (USERNAME,PASSWORD,ACCESS,ID) values('"
                +userName+"','"+passPhrase+"','"+depNum+"','"+usrId+"')"); 
        }

    
    public void deleteUsr(String usrName) throws SQLException
	{

       		message.execute("update LOGINTABLE1 set Active='FALSE' where ID='"+ usrName +"'");
    	}

   public void updateUsrInfo(String usrName,String count,String prevNum) throws SQLException 
	{
        	String newUsrId= addNewUsername(count);
        	User oldUsrId=EmplInfo("","",prevNum,true).get(0);
        
        if(oldUsrId.getDept().equals(count))
	{
        	    message.execute("update LOGINTABLE1 set USERNAME='"+usrName+"' where ID='"+oldUsrId+"'");
        }
	else
	{
            if(oldUsrId.getOldID() == null)
		oldUsrId.setOldID("No previous.");
            
	    message.execute("update LOGINTABLE1 set USERNAME='"+usrName+"',ACCESS='"+count+
                    "',ID='"+newUsrId +"', OLDID='"+oldUsrId+"' where ID='"+prevNum+"'");
            
	    message.execute("insert into LOGINTABLE1 (USERNAME,PASSWORD,ACCESS,ID,Active,OLDID) values('"
                 +usrName+" -"+Calendar.getInstance().getTime()+"','"+"Disabled"+"','"+oldUsrId.getDept()+
                    "','"+prevNum+"','FALSE','"+oldUsrId.getOldID()+"')"); 
        }
    }
    
    
    
    private Connection accBase;
    private Statement message;
    private String sqlStat;
    private ResultSet numb;
}
