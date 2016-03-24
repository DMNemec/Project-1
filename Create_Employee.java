
/**
 * Write a description of class Create_Employee here.
 * 
 * Dalton Lee
 * 
 * 3/17/2016
 * Version 1.0
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;

public class Create_Employee extends JFrame implements ActionListener
{
    private String ID;
    
    private JPanel container = new JPanel ();
    private JPanel left = new JPanel ();
    private JPanel right = new JPanel ();
    
    
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
        
        this.setSize (800, 700);
        this.setTitle ("ID: " + ID + " (Admin)");
        this.setLayout(new GridBagLayout()); /**Auto sets the JPanel to the center*/
        
        container.setLayout (new BoxLayout (container, BoxLayout.X_AXIS));
        left.setLayout (new BoxLayout (left, BoxLayout.Y_AXIS));
        right.setLayout (new BoxLayout (right, BoxLayout.Y_AXIS));
        
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
                }
            }
        });
        
        /**Left column*/
        left.add (lastLabel);
        left.add (lastName);
        left.add (IDLabel);
        left.add (empID);
        left.add (adminLabel);
        left.add (admin);
        admin.setSelected(false);
        left.add (save);

        /**Right column*/
        right.add (firstLabel);
        right.add (firstName);
        right.add (passLabel);
        right.add (password);
        right.add (rePassLabel);
        right.add (rePassword);
        right.add (cancel);
        
        /**Put everything together*/
        container.add (left);
        container.add (right);
        
        this.add (container);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack(); /**Opens in the middle of the screen*/
        this.setLocationRelativeTo(null); /**Opens in the middle of the screen*/
        this.setVisible(true);
        
    }

    public void actionPerformed (ActionEvent e)
    {
        String action = e.getActionCommand();
    
        if (action.equals ("Save"))
        {
            /**Create employee*/
        }
        else if (action.equals ("Cancel"))
        {
            this.dispose ();
        }
    
    
    }
}
