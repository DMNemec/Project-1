package POS_DAO;

import pos.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class NowLoggedIN 
{

    
    public NowLoggedIN(String dataBaseRoute) 
	{
        	try 
		{
            		accBase = DriverManager.getConnection(dataBaseRoute);
            		message = accBase.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                    ResultSet.CONCUR_READ_ONLY);
        	}
		 catch (SQLException ex) 
		{
         	   	Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        	}
    	}
   
   
    public boolean login(String usrName, String password) 
	{
        	sqlStat ="select * from LOGINTABLE1 where LOGINTABLE1.USERNAME='"+usrName+"'";
        	try 
		{
            		numb=message.executeQuery(sqlStat);
            		if(numb.next())
			{
                    		return password.equals(numb.getString("PASSWORD")) && numb.getString("active").equals("TRUE");
            		}
        	}
		 catch (SQLException ex) 
		{
           		 Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        	}
        	return false;
    	}
	
    public void changePasswordW(User userName,String newPW)
	{
        	try 
		{
            		message.execute("update LOGINTABLE1 set LOGINTABLE1.PASSWORD ='" + newPW +"'"
                    	+ " where LOGINTABLE1.ID='"+userName.getId()+"'");
        	}
	        catch (SQLException ex) 
		{
            		Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        	}
              
    	}

    public User getUser() throws SQLException
	{
        	User empl = new User(accBase.getString("USERNAME"),accBase.getString("PASSWORD"),
                            accBase.getString("ACCESS"),accBase.getString("ID"),
                            accBase.getString("Active"),accBase.getString("OLDID"));
        	return empl;
    	}
   
    
    //Declarations
    private Connection accBase;
    private Statement message;
    private String sqlStat;
    private ResultSet numb;
    //End of declarations
}