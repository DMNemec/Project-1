package POS_DAO;

import java.io.*;
import javax.swing.JOptionPane;

public class Employee_DAO {
	//Global Variables
	private File empFile = new File("databases\\employeeData.txt");
	private BufferedReader reader;
	private BufferedWriter writer;
	
	//Constructors
	public Employee_DAO() {
		if (empFile.exists()){
			System.out.println("Employee data found.");
		} else {
			try {
				empFile.createNewFile();
			} catch (IOException ex){
				JOptionPane.showMessageDialog(null, ex);				
			}
		}
	}
	
	//Public Methods
	public void createAdmin (String id, String pass, String fName, String lName, String mail) {
		//This version is for creating an admin
		//Local Variables
		try {
			writer = new BufferedWriter(new FileWriter(empFile, true));
		
			if (!employeeExists(id)){
				writer.write(id + ":" + pass + ":" + fName + ":" + lName + ":1:" + mail);
				writer.newLine();
			}
		} catch (IOException ex){
			JOptionPane.showMessageDialog(null, ex);				
		} finally {
			try {
				writer.close();
			} catch (IOException ex){
				JOptionPane.showMessageDialog(null, ex + "\nUnable to close file.");				
			}
		}
	}
	
	public void createEmployee (String id, String pass, String fName, String lName) throws IOException {
		//this version is for creating a regular user
		//Local Variables
		writer = new BufferedWriter(new FileWriter(empFile, true));
		
		if (!employeeExists(id)){
			try {
				writer.write(id + ":" + pass + ":" + fName + ":" + lName + ":0:");
				writer.newLine();
			} catch (IOException ex){
				JOptionPane.showMessageDialog(null, ex);				
			} finally {
				writer.close();
			}
		}
		
	}
	
	public String[] GetEmployee(String id) throws IOException
	{
		//retrieves a user's information
		//Local Variables
		String[] result = getEmployeeWithId(id);
		
		return result;
	}
	
	/*public void deleteEmployee (String id) throws IOException{	
		//removes the specified employee from the database
		//Local Variables
		writer = new BufferedWriter(new FileWriter(empFile, true));
		int line = getEmployeeLine(id);
		if (line > 1){
			writer.write("", line, 1);
		}
		writer.close();
	}*/
	
	public boolean[] loginInfo (String id, String pass) {
		//Returns a boolean array so the system can log in the employee
		//Local Variables
		boolean[] results = new boolean[] {false,false,false};
		String[] elements = null;

		elements = getEmployeeWithId(id);
	
		if (elements[0].equals(id)){
			results[0] = true;
		}
		if (elements[1].equals(pass)){
			results[1] = true;
		}
		if (elements[4].equals("1")){
			results[2] = true;
		}
		
		return results;
	}
	
	public void changePassword (String id, String pass)
	{
		//changes the employee's password in the database
		//Local Variables
	}
	
	//Private Methods
	private String[] getEmployeeWithId(String id) {
		//Returns the line number of the specified employee id
		//Local Variables
		String string = new String();
		String[] elements = new String[6];
		try {
			reader = new BufferedReader(new FileReader(empFile));
			
			while ((string = reader.readLine()) != null){
				elements = string.split(":");
				if (elements[0].contains(id)){
					break;
				}
			}
		} catch (IOException ex){
			JOptionPane.showMessageDialog(null, ex);				
		} finally {
			try {
				reader.close();
			} catch (IOException ex){
				JOptionPane.showMessageDialog(null, ex + "\nUnable to close file.");				
			}
		}
		return elements;
	}
	
	private boolean employeeExists (String id) {
		boolean result = false;
		String line = new String();
		String[] elements = new String[6];
		try {
			reader = new BufferedReader(new FileReader(empFile));
			
			while ((line = reader.readLine()) != null){
				elements = line.split(":");
				if (elements[0].contains(id)){
					result = true;
					break;
				}
			}
		}  catch (IOException ex){
			JOptionPane.showMessageDialog(null, ex);				
		} finally {
			try {
				reader.close();
			} catch (IOException ex){
				JOptionPane.showMessageDialog(null, ex + "\nUnable to close file.");				
			}
		}
		return result;
	}
}
