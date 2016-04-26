/**
 * Simple login screen that takes an Employee Number
 * and Password, encrypts the password, and compares it
 * to what is on file. If incorrect it prints out a message.
 * 
 * Writen by Dalton Lee
 * 
 * 4/20/2016
 */
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import POS_DAO.Employee_DAO;

@SuppressWarnings("serial")
public class Login_GUI extends JFrame implements ActionListener
{
    // instance variables - replace the example below with your own
    private JPasswordField passwordField = new JPasswordField(20);;
    private JTextField userID = new JTextField (20);;

    private JButton login;
    
    private JLabel passwordLabel = new JLabel("Enter the password: ");
    private JLabel userLabel = new JLabel ("Enter your user ID");
    
    private String ID;
    private String password;

    @SuppressWarnings("unused")
	public static void main (String [] args) /**For Testing*/
    {

        Login_GUI test = new Login_GUI ();

    }
    
    /**
     * Constructor for objects of class Login_GUI
     */
    public Login_GUI ()
    {
        //Use the default FlowLayout.
        this.setTitle ("Login");
        this.setLayout (null); /**Auto sets the JPanel to the center*/

        login = new JButton ("Login"); /**Create login button*/
        login.setSize (new Dimension (100, 40)); /**Set the size of the button*/
        login.addActionListener (this);
        
        userID.setMaximumSize (new Dimension (250, 25)); /**Make the textFields size appropriatly*/
        passwordField.setMaximumSize (new Dimension (250, 25));
        
        this.add (userLabel);
        this.add (userID);
        this.add (passwordLabel);
        this.add (passwordField);
        this.add (login);
        
        /**Absolute Positioning of the components*/
        Insets insets = this.getInsets(); /**The dimensions of the JFrame*/
        
        userLabel.setBounds (90 + insets.left, 15 + insets.top,
                             250, 25);
        userID.setBounds (20 + insets.left, 40 + insets.top,
                          250, 25);
        passwordLabel.setBounds (90 + insets.left, 80 + insets.top,
                                 250, 25);
        passwordField.setBounds (20 + insets.left, 105 + insets.top,
                                 250, 25);
        login.setBounds (95 + insets.left, 155 + insets.top,
                         100, 40);
        
        this.setResizable (false);
        this.setPreferredSize(new Dimension(300,300));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack(); /**Opens in the middle of the screen*/
        this.setLocationRelativeTo(null); /**Opens in the middle of the screen*/
        this.setVisible(true);
    }
    
    @SuppressWarnings("unused")
	private void loginAttempt ()
    {
        boolean [] userInfo = new boolean [3];
        
        //Login_DAO employees = new Login_DAO ();
        Employee_DAO employees = new Employee_DAO();
        
        userInfo = employees.loginInfo(ID, password);
        
        if (userInfo [1]) //The employee logged in
        {
            if (userInfo [2]) //Closes login and loads Admin GUI
            {
                JOptionPane.showMessageDialog(null, "You logged in with ADMIN rights");
                
                Admin_GUI newGUI = new Admin_GUI (ID);
                this.dispose(); /**Destroy the JFrame object*/
                
                /**Sends message to login autitor (ID, true)*/
                /**loads the admin GUI and closes the Login GUI*/
            }
            else //Closes login and loads Employee GUI
            {
                JOptionPane.showMessageDialog(null, "An EMPLOYEE logged in");
                
                Employee_GUI newGUI = new Employee_GUI (ID);
                
                /**Sends message to login auditor (ID, true)*/
                /**loads the employee GUI and closes the Login GUI*/
            }
        }
        else if (userInfo [0]) //Correct ID
        {
            JOptionPane.showMessageDialog(null, "Incorrect password");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Employee not found");
        }
    }
    
    
    public void actionPerformed (ActionEvent e)
    {
        String action = e.getActionCommand();

        
        if (action.equals ("Login"))
        {
            ID = userID.getText();
            password = new String (passwordField.getPassword());
            
            loginAttempt();
            userID.setText (""); /**Clears the text from the field*/
            passwordField.setText("");
            /**Sends message to login autitor (ID, false)*/
        }
    }
}
