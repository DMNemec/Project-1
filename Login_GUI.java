/**
 * Simple login screen that takes an Employee Number
 * and Password, encrypts the password, and compares it
 * to what is on file. If incorrect it prints out a message.
 * 
 * Writen by Dalton Lee
 * 
 * Version 1.0
 * 2/18/2016
 */
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;

public class Login_GUI extends JFrame implements ActionListener
{
    // instance variables - replace the example below with your own
    //private JFrame controllingFrame; //needed for dialogs
    private JPasswordField passwordField;
    private JTextField userID;

    private JButton login;
    private JPanel  credentials;
    private JPanel  buttons;
    
    private JLabel passwordLabel = new JLabel("Enter the password: ");
    private JLabel userLabel = new JLabel ("Enter your user ID");
    
    private int ID;
    private String password;

    public static void main (String [] args) /**For Testing*/
    {

        Login_GUI test = new Login_GUI ();
        //System.out.println ("Test");

    }
    
    /**
     * Constructor for objects of class Login_GUI
     */
    public Login_GUI ()
    {
        //Use the default FlowLayout.
        this.setSize(800, 700);
        //this.setAlwaysOnTop (true);
        this.setLayout (new BorderLayout());

        buttons = new JPanel();
        buttons.setLayout (new GridLayout(0,1));
        credentials = new JPanel();
        credentials.setLayout (new GridLayout(4,0));

        login = new JButton ("Login"); //Create login button
        login.setPreferredSize (new Dimension (5, 40));
        login.addActionListener (this);
        
        userID        = new JTextField (20);
        passwordField = new JPasswordField(20);
        
        /**Add everything to panels*/
        buttons.add (login);
        credentials.add (userLabel);
        credentials.add (userID);
        credentials.add (passwordLabel);
        credentials.add (passwordField);

        add (credentials, BorderLayout.CENTER);
        add (buttons, BorderLayout.SOUTH);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private void loginAttempt ()
    {
        boolean found;
        boolean rights;
        
        System.out.println ("Jumped to loginAttempt()");
        
        Login_DAO employees = new Login_DAO ();
        
        if (employees.findEmployee (ID, password)) //we found our employee
        {
            if (employees.isAdmin()) //Closes login and loads Admin GUI
            {
                JOptionPane.showMessageDialog(null, "You logged in with ADMIN rights");
            }
            else //Closes login and loads Employee GUI
            {
                JOptionPane.showMessageDialog(null, "A EMPLOYEE logged in");
            }
        }
        else
        {
            if (employees.rightID()) //ID found
            {
                JOptionPane.showMessageDialog(null, "Incorrect password");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Employee not found");
            }
        }
    }
    
    
    public void actionPerformed (ActionEvent e)
    {
        String action = e.getActionCommand();
        
        if (action.equals ("Login"))
        {
            ID = Integer.parseInt (userID.getText());
            password = new String (passwordField.getPassword());
            
            System.out.println ("ID is: " + ID);
            System.out.println ("Password is: " + password);
            
            JOptionPane.showMessageDialog(null, "You tried to log in");
        }
    }
}
