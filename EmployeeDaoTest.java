import java.io.IOException;
import POS_DAO.Employee_DAO;

/*
 * Written by Devin Nemec
 * 2016 Software Engineering Final
*/
public class EmployeeDaoTest {

	public static void main(String[] args) throws IOException {
		Employee_DAO tester1 = new Employee_DAO();
		
		tester1.createEmployee("12345", "stupid", "Fake", "Person");
		tester1.createAdmin("67890", "test", "Testie", "McTesterson", "testie.mctesterson@test.edu");
		
		boolean[] testResult = new boolean[3];
		
		testResult = tester1.loginInfo("testuser","testpassword");
		if(testResult[0]){System.out.println("Username is correct");}
		if(testResult[1]){System.out.println("Password is correct");}
		if(testResult[2]){System.out.println("User is an Administrator");}
		
		//tester1.deleteEmployee("12345"); //Come back to this later, WAY too much work right now.
	}

}

/*
 * Written by Devin Nemec
 * 2016 Software Engineering Final
*/
