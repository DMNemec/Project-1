package POS_DAO;



public class LoggedIn 
{
    
    public LoggedIn()
	{
        	empName="";
		empPW="";
		depart="";
		numbId="";
		active="";
		oldNumbId="";
    	}
    
    public LoggedIn(String empName,String empPW,String depart,String numbId,
            String active,String oldNumbId)
	{
        	this.empName=empName;
        	this.empPW=empPW;
        	this.depart=depart;
        	this.numbId=numbId;
       	 	this.active=active;
        	this.oldNumbId=oldNumbId;  
    	}

    public String getUsername()
	{
        	return empName;        
    	}

    public String getPW()
	{
        	return empPW;
    	}

    public String getDept()
	{
        	return depart;
    	}

    public String getId()
	{
        	return numbId;
    	}

    public String getActive()
	{
        	return active;
    	}

    public String getOldNumbId()
	{
        	return oldNumbId;
    	}

    public void setUsername(String usrName)
	{
        	this.empName=usrName;
    	}

    public void setPassword(String empPW)
	{
        	this.empPW=empPW;
    	}

    public void setDept(String depart)
	{
        	this.depart=depart;
    	}

    public void setNUMID(String numbId)
	{
        	this.numbId=numbId; 
    	}

    public void setActiveUsr(String active)
	{
        	this.active=active;      
    	}

    public void setOldNumb(String oldNumbId)
	{
        	this.oldNumbId=oldNumbId;  
    	}

    public User copyUsrData(User usr)
	{
        	usr.setActive(active);
        	usr.setDept(depart);
        	usr.setID(numbId);
        	usr.setPassword(empPW);
       	 	usr.setUsername(empName);
        	return usr;
    	}    
    
    private String empName,empPW,depart,numbId,active,oldNumbId;
}


