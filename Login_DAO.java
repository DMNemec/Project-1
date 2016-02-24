
/**
 * This takes in an encrypted password and a user ID
 * and checks them against a file of users and returns
 * the ID, whether it was a successful login, and if the
 * have Admin rights
 * 
 * Writen by Dalton Lee
 * 
 * Version 2.0
 * 2/24/2016
 */

import java.lang.*;
import java.io.*; //For file IO
import java.util.*;
import java.awt.*; //For pop-up error message
import java.awt.event.*;
import javax.swing.*;

public class Login_DAO
{
    private String fileName = "C:\\Users\\Dalton\\Desktop\\Software Engineering\\Test.txt"; //Constant file location   
    private Scanner inFile;
    
    private String userID;
    private String userCode;
    private static boolean [] userInfo = new boolean [3];
    
    public static void main (String [] args) /**For Testing*/
    {
        boolean [] info = new boolean [3];
        Login_DAO test;

        test = new Login_DAO ();
        System.out.println ("Bad Admin password");
        info = test.findEmployee ("5067759", "fail");
        System.out.println ("rightID(T): " + info [0]);
        System.out.println ("Login(F): "   + info [1]);
        System.out.println ("Admin(T): "   + info [2] + "\n");
        
        test = new Login_DAO ();
        System.out.println ("Last Employee");
        info = test.findEmployee ("45864650", "More");
        System.out.println ("rightID(F): " + info [0]);
        System.out.println ("Login(F): "   + info [1]);
        System.out.println ("Admin(F): "   + info [2] + "\n");
        
        test = new Login_DAO ();
        System.out.println ("Regular Employee");
        info = test.findEmployee ("8496738", "Bespin80");
        System.out.println ("rightID(T): " + info [0]);
        System.out.println ("Login(T): "   + info [1]);
        System.out.println ("Admin(F): "   + info [2] + "\n");
        
        test = new Login_DAO ();
        System.out.println ("Admin");
        info = test.findEmployee ("5067759", "Naboo99");
        System.out.println ("rightID(T): " + info [0]);
        System.out.println ("Login(T): "   + info [1]);
        System.out.println ("Admin(T): "   + info [2] + "\n");
    }
    
    /**
     * Constructor for objects of class Login_DAO
     */
    public  Login_DAO ()
    {        
        userInfo [0] = false;
        userInfo [1] = false;
        userInfo [2] = false;
        
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
    public boolean [] findEmployee (String ID, String code)
    {
        String [] array = new String [3];
        String info;
        userID = ID;
        userCode = code;
        
        while (inFile.hasNextLine())
        {
            info = inFile.nextLine();
            array = info.split("\\*");

            if (array[0].equals (userID))
            {
                System.out.println ("Found ID DAO");
                userInfo [0] = true;

                if (array[1].equals(userCode))
                {
                    System.out.println ("Correct password DAO");
                    userInfo [1] = true;
                }

                userInfo [2] = Boolean.parseBoolean (array [2]); //false unless we have a correct ID
                return userInfo;
            }
        }

        inFile.close();
        return userInfo;
    }
}
