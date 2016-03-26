package POS_DAO;

public class Employee_DAO {
	//Global Variables
	private String userId, password, firstName, lastName, email;
	
	//Constructors
	public Employee_DAO(){}
	
	//Methods
	public void createAdmin (String id, String pass, String fName, String lName, String mail)
	{
		//This version is for creating an admin
		//Local Variables
		userId = id;
		password = pass;
		firstName = fName;
		lastName = lName;
		email = mail;
	}
	
	public void createEmployee (String id, String pass, String fName, String lName)
	{
		//this version is for creating a regular user
		//Local Variables
		userId = id;
		password = pass;
		firstName = fName;
		lastName = lName;
	}
	
	public String[] GetEmployee(String id)
	{
		//retrieves a user's information
		//Local Variables
		userId = id;
		String[] result = new String[4];
		
		result[0] = "Testie";
		result[1] = "McTesterson";
		result[2] = "1";
		result[3] = "testie.mctesterson@test.edu";
		
		return result;
	}
	
	public void deleteEmployee (String id)
	{
		//removes the specified employee from the database
		//Local Variables
		userId = id;
	}
	
	public boolean[] loginInfo (String id, String pass)
	{
		//returns an array about whether the employee can login or not
		//Local Variables
		boolean[] result = new boolean[] {true,true,true};
		userId = id;
		password = pass;
		
		return result;
	}
	
	public void changePassword (String id, String pass)
	{
		//changes the employee's password in the database
		//Local Variables
		userId = id;
		password = pass;
	}
	
}
