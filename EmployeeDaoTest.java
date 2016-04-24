import java.io.IOException;

import POS_DAO.Employee_DAO;

public class EmployeeDaoTest {

	public static void main(String[] args) throws IOException {
		//Employee_DAO tester1 = new Employee_DAO("jdbc:mysql://localhost:3306/database1");
		Employee_DAO tester1 = new Employee_DAO();
		//Employee_DAO tester1 = new Employee_DAO("jdbc:ucanaccess://"+System.getenv("APPDATA")+"\MainDB.accdb");
		
		tester1.createEmployee("12345", "stupid", "Fake", "Person");
		tester1.createAdmin("67890", "test", "Testie", "McTesterson", "testie.mctesterson@test.edu");
		tester1.deleteEmployee("12345");
		
		//boolean[] testResult = new boolean[3];
		
		/*testResult = tester1.loginInfo("testuser","testpassword");
		if(testResult[0]){System.out.println("Username is correct");}
		if(testResult[1]){System.out.println("Password is correct");}
		if(testResult[2]){System.out.println("User is an Administrator");}
		*/
	}

}
