package POS_DAO;

import java.io.*;
import java.util.Scanner;

public class Employee_DAO {
	//Global Variables
	private String userId, password, firstName, lastName, email;
	private File empFile = new File("databases\\employeeData.txt");
	private BufferedReader reader;
	private BufferedWriter writer;
	
	//Constructors
	public Employee_DAO() throws IOException{
		if (empFile.exists()){
			System.out.println("Employee data found.");
		} else {
			try {
				empFile.createNewFile();
			} finally {}
		}
	}
	
	private boolean employeeExists (String id) throws IOException{
		boolean result = false;
		String line = new String();
		String[] elements = new String[6];
		reader = new BufferedReader(new FileReader(empFile));
		
		while ((line = reader.readLine()) != null){
			elements = line.split(":");
			if (elements[0].contains(id)){
				result = true;
				break;
			}
		}
		reader.close();
		return result;
	}
	
	//Methods
	public void createAdmin (String id, String pass, String fName, String lName, String mail) throws IOException
	{
		//This version is for creating an admin
		//Local Variables
		writer = new BufferedWriter(new FileWriter(empFile, true));
		
		if (!employeeExists(id)){
			try {
				writer.write(id + ":" + pass + ":" + fName + ":" + lName + ":1:" + mail);
				writer.newLine();
			} finally {
				writer.close();
			}
		}
	}
	
	public void createEmployee (String id, String pass, String fName, String lName) throws IOException{
		//this version is for creating a regular user
		//Local Variables
		writer = new BufferedWriter(new FileWriter(empFile, true));
		
		if (!employeeExists(id)){
			try {
				writer.write(id + ":" + pass + ":" + fName + ":" + lName + ":0:");
				writer.newLine();
			} finally {
				writer.close();
			}
		}
		
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
	
	public void deleteEmployee (String id) throws IOException{	
		//removes the specified employee from the database
		//Local Variables
		writer = new BufferedWriter(new FileWriter(empFile, true));
		int line = getEmployeeLine(id);
		if (line > 1){
			writer.write("", line, 1);
		}
		writer.close();
	}
	
	public boolean[] loginInfo (String id, String pass) throws IOException{
		//Returns a boolean array so the system can log in the employee
		//Local Variables
		int line;
		BufferedReader localReader = new BufferedReader(new FileReader(empFile));
		boolean[] results = new boolean[] {false,false,false};
		String[] elements = null;
		
		for (line = getEmployeeLine(id);line > 0;line--) {
			elements = localReader.readLine().split(":");
		}
		
		if (elements[0].equals(id)){
			results[0] = true;
		}
		if (elements[1].equals(pass)){
			results[1] = true;
		}
		if (elements[4].equals("1")){
			results[2] = true;
		}
		
		localReader.close();
		return results;
	}
	
	public void changePassword (String id, String pass)
	{
		//changes the employee's password in the database
		//Local Variables
		userId = id;
		password = pass;
	}
	
	private int getEmployeeLine(String id) throws IOException{
		//Returns the line number of the specified employee id
		//Local Variables
		int line = 0;
		String string = new String();
		String[] elements = new String[6];
		reader = new BufferedReader(new FileReader(empFile));
		
		while ((string = reader.readLine()) != null){
			line ++;
			elements = string.split(":");
			if (elements[0].contains(id)){
				break;
			}
		}
		
		reader.close();
		return line;
	}
}
