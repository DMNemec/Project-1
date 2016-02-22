
/**
 * This takes in an encrypted password and a user ID
 * and checks them against a file of users and returns
 * the ID, whether it was a successful login, and if the
 * have Admin rights
 * 
 * Writen by Dalton Lee
 * 
 * Version 1.0
 * 2/19/2016
 */
import java.lang.*;
import java.io.*; //For file IO
import java.util.*;
import java.awt.*; //For pop-up error message
import java.awt.event.*;
import javax.swing.*;

public class Login_DAO
{
    private String fileName = "C:\\Users\\Dalton\\Desktop\\Software Engineering\\Login Test.txt";    
    private Scanner inFile;
    
    private int userID;
    private String userCode;
    private int fileID;
    private String fileCode;
    private boolean admin;
    private boolean found = false;
    private boolean correctID = false;
    
    public static void main (String [] args) /**For Testing*/
    {
        boolean success = false;
        Login_GUI test = new Login_GUI ();

        //success = test.findEmployee (5067759, "fail");
        System.out.println ("Bad Admin password");
        System.out.println ("Login(F): " + success);
        //success = test.isAdmin();
        System.out.println ("Admin(): " + success);
        //success = test.rightID();
        System.out.println ("rigthID(T): " + success + "\n");
        
        
    }
    
    /**
     * Constructor for objects of class Login_DAO
     */
    public  Login_DAO ()
    {        
        System.out.println ("Tried to open the file");
        
        try
        {
            inFile = new Scanner (new FileInputStream (fileName));
        }
        
        catch (IOException e)
        {
           JOptionPane.showMessageDialog(null, "The employee database can't be found"); 
        }
    }

    /**
     * Searches a file for a employee
     * with a matching userID and password
     */
    public boolean findEmployee (int ID, String code)
    {
        userID = ID;
        userCode = code;
        
        while (inFile.hasNext() || !found)
        {
            fileID = Integer.parseInt (inFile.nextLine());
            fileCode = inFile.nextLine();
            //rights = inFile.getLine ();
            admin = Boolean.parseBoolean (inFile.nextLine ());
            inFile.nextLine();
            
            if (userID == fileID && userCode == fileCode)
            {
                System.out.println ("Found ID and PASSWORD");
                found = true;
            }
            
            if (userID == fileID)
            {
                System.out.println ("Found ID");
                correctID = true;
            }
        }
        
        return found;
    }
    
    public boolean isAdmin () //used only after findEmployee()
    {
        if (found)
        {
            return admin;
        }
        else
        {
            return found;
        }
    }
    
    public boolean rightID ()
    {
        return correctID;
    }
}
