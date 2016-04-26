
/**
 * Write a description of class Create_Employee here.
 * 
 * Dalton Lee
 * 
 * 4/21/2016
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import POS_DAO.Employee_DAO;

@SuppressWarnings("serial")
public class Create_Employee extends JFrame implements ActionListener
{
    private String ID;
    private String emailStr = "";

    /**Left side*/
    JLabel lastLabel  = new JLabel ("Last Name");
    JLabel IDLabel    = new JLabel ("Employee ID");
    JLabel adminLabel = new JLabel ("Admin Rights");
    
    JTextField lastName = new JTextField (20);
    JTextField empID    = new JTextField (20);
    JCheckBox admin     = new JCheckBox ();
    
    JLabel emailLabel = new JLabel ("E-Mail"); /**Only appears if they have admin rights*/
    JTextField email  = new JTextField (20);
    
    /**Right side*/
    JLabel firstLabel = new JLabel ("First Name");
    JLabel passLabel  = new JLabel  ("Password");
    JLabel rePassLabel = new JLabel ("Re-Enter Password");
    
    JTextField firstName = new JTextField (20);
    JTextField password = new JTextField (20);
    JTextField rePassword = new JTextField (20);
    
    /**Button layer*/
    JButton save   = new JButton ("Save");
    JButton cancel = new JButton ("Cancel");

    @SuppressWarnings("unused")
	public static void main (String [] args) /**For Testing*/
    {

        Create_Employee test = new Create_Employee ("5067759");

    }
    
    
    /**
     * Constructor for objects of class Create_Employee
     */
    public Create_Employee(String emp)
    {
        ID = emp;
        
        this.setTitle ("ID: " + ID + " (Admin)");
        this.setLayout(null);
        
        this.setResizable (false);
        this.setPreferredSize(new Dimension(600,500));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack(); /**Opens in the middle of the screen*/
        this.setLocationRelativeTo(null); /**Opens in the middle of the screen*/
        this.setVisible(true); 
        
        //basis();
        alternate();
    }
    
    private void basis ()
    {

        /**Adding ActionListeners*/
        save.addActionListener (this);
        cancel.addActionListener (this);
        admin.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if(e.getStateChange() == ItemEvent.SELECTED) 
                {//checkbox has been selected
                    /**Password protected
                     * if (correct password)
                     *     add emailLabel and email to left
                     */
                    System.out.println ("Alternate");
                    email.setText (emailStr);
                    emailLabel.setVisible (true);
                    email.setVisible (true);
                    alternate();
                } 
                else 
                {//checkbox has been deselected
                    /**Password protected
                     * if (correct password)
                     *     remove emailLabel and email from left "left.remove (email);"
                     *     employee looses admin rights
                     */
                }
            }
        });
        

        /**Absolute Positioning of the components*/
        Insets insets = this.getInsets(); /**The dimentsions of the JFrame*/
        
        this.add (lastLabel);
        lastLabel.setBounds (145 + insets.left, 25 + insets.top,
                             250, 25);
        this.add (lastName);
        lastName.setBounds (110 + insets.left, 50 + insets.top,
                            150, 25);
        this.add (IDLabel);
        IDLabel.setBounds (145 + insets.left, 110 + insets.top,
                           250, 25);
        this.add (empID);
        empID.setBounds (110 + insets.left, 135 + insets.top,
                         150, 25);
        this.add (adminLabel);
        adminLabel.setBounds (145 + insets.left, 195 + insets.top,
                              250, 25);
        this.add (admin);
        admin.setBounds (170 + insets.left, 220 + insets.top,
                         150, 25);
        
        this.add (firstLabel);
        firstLabel.setBounds (390 + insets.left, 25 + insets.top,
                              250, 25);
        this.add (firstName);
        firstName.setBounds (350 + insets.left, 50 + insets.top,
                             150, 25);
        this.add (passLabel);
        passLabel.setBounds (390 + insets.left, 110 + insets.top,
                             250, 25);
        this.add (password);
        password.setBounds (350 + insets.left, 135 + insets.top,
                            150, 25);
        this.add (rePassLabel);
        rePassLabel.setBounds (370 + insets.left, 195 + insets.top,
                               250, 25);
        this.add (rePassword);
        rePassword.setBounds (350 + insets.left, 220 + insets.top,
                              150, 25);
        this.add (save);
        save.setBounds (130 + insets.left, 260 + insets.top,
                        100, 40);
        this.add (cancel);
        cancel.setBounds (375 + insets.left, 260 + insets.top,
                          100, 40);
        
        this.validate();
    }
    
    private void alternate ()
    {
        /**Adding ActionListeners*/
        save.addActionListener (this);
        cancel.addActionListener (this);
        admin.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if(e.getStateChange() == ItemEvent.SELECTED) 
                {//checkbox has been selected
                    /**Password protected
                     * if (correct password)
                     *     add emailLabel and email to left
                     */
                    
                    
                } 
                else 
                {//checkbox has been deselected
                    /**Password protected
                     * if (correct password)
                     *     remove emailLabel and email from left "left.remove (email);"
                     *     employee looses admin rights
                     */
                    System.out.println ("Basis");
                    emailStr = email.getText(); //Save the value of email
                    emailLabel.setVisible (false);
                    email.setVisible (false);
                    basis();
                }
            }
        });
        

        /**Absolute Positioning of the components*/
        Insets insets = this.getInsets(); /**The dimentsions of the JFrame*/
        
        this.add (lastLabel);
        lastLabel.setBounds (145 + insets.left, 25 + insets.top,
                             250, 25);
        this.add (lastName);
        lastName.setBounds (110 + insets.left, 50 + insets.top,
                            150, 25);
        this.add (IDLabel);
        IDLabel.setBounds (145 + insets.left, 110 + insets.top,
                           250, 25);
        this.add (empID);
        empID.setBounds (110 + insets.left, 135 + insets.top,
                         150, 25);
        this.add (adminLabel);
        adminLabel.setBounds (145 + insets.left, 195 + insets.top,
                              250, 25);
        this.add (admin);
        admin.setBounds (170 + insets.left, 220 + insets.top,
                         150, 25);
        this.add (emailLabel);
        emailLabel.setBounds (160 + insets.left, 255 + insets.top,
                              250, 25);
        this.add (email);
        email.setBounds (110 + insets.left, 280 + insets.top,
                         150, 25);
        
        this.add (firstLabel);
        firstLabel.setBounds (390 + insets.left, 25 + insets.top,
                              250, 25);
        this.add (firstName);
        firstName.setBounds (350 + insets.left, 50 + insets.top,
                             150, 25);
        this.add (passLabel);
        passLabel.setBounds (390 + insets.left, 110 + insets.top,
                             250, 25);
        this.add (password);
        password.setBounds (350 + insets.left, 135 + insets.top,
                            150, 25);
        this.add (rePassLabel);
        rePassLabel.setBounds (370 + insets.left, 195 + insets.top,
                               250, 25);
        this.add (rePassword);
        rePassword.setBounds (350 + insets.left, 220 + insets.top,
                              150, 25);
        this.add (save);
        save.setBounds (130 + insets.left, 320 + insets.top,
                        100, 40);
        this.add (cancel);
        cancel.setBounds (375 + insets.left, 320 + insets.top,
                          100, 40);
        
        this.validate();
    }

    public void actionPerformed (ActionEvent e)
    {
        String action = e.getActionCommand();
    
        if (action.equals ("Save"))
        {
            Employee_DAO employees = new Employee_DAO();
            if (password.getText().equals(rePassword.getText())){
		        if (admin.isSelected()){
		        	employees.createAdmin(empID.getText(), password.getText(), firstName.getText(), lastName.getText(), email.getText());
		        } else {
		        	employees.createEmployee(empID.getText(), password.getText(), firstName.getText(), lastName.getText());
		        }
            }
        }
        else if (action.equals ("Cancel"))
        {
            this.dispose ();
        }
    
    
    }
}
