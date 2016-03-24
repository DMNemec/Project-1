
/**
 * Write a description of class Audit here.
 * 
 * Dalton Lee
 * 3/17/2016
 * Version 1.0
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;

public class Audit extends JFrame implements ActionListener
{
    private String ID;
    
    private JPanel container = new JPanel ();
    private JPanel first    = new JPanel ();
    private JPanel left     = new JPanel ();
    private JPanel right    = new JPanel ();
    private JPanel second   = new JPanel ();
    private JPanel buttons1 = new JPanel ();
    private JPanel buttons2 = new JPanel ();
    
    private JLabel startLabel = new JLabel ("Start Date");
    private JLabel endLabel   = new JLabel ("End Date");
    private JLabel empLabel   = new JLabel ("Employee ID");
    
    private JTextField startDate = new JTextField (20);
    private JTextField endDate   = new JTextField (20);
    private JTextField empID     = new JTextField (20);
    
    private JButton sales    = new JButton ("Sales");
    private JButton both     = new JButton ("Both");
    private JButton shipment = new JButton ("Shipment");
    private JButton value    = new JButton ("Inventory Value");
    private JButton income   = new JButton ("Income");
    
    public static void main (String [] args) /**For Testing*/
    {

        Audit test = new Audit ("5067759");

    }

    /**
     * Constructor for objects of class Audit
     */
    public Audit (String emp)
    {
        ID = emp;
        
        this.setSize (800, 700);
        this.setTitle ("ID: " + ID + " (Admin)");
        this.setLayout(new GridBagLayout()); /**Auto sets the JPanel to the center*/
        
        /**Format JPanels*/
        container.setLayout (new BoxLayout (container, BoxLayout.Y_AXIS));
        first.setLayout (new BoxLayout (first, BoxLayout.X_AXIS));
        left.setLayout (new BoxLayout (left, BoxLayout.Y_AXIS));
        right.setLayout (new BoxLayout (right, BoxLayout.Y_AXIS));
        second.setLayout (new BoxLayout (second, BoxLayout.Y_AXIS));
        buttons1.setLayout (new BoxLayout (buttons1, BoxLayout.X_AXIS));
        buttons2.setLayout (new BoxLayout (buttons2, BoxLayout.X_AXIS));
        
        /**Setting up the first row*/
        left.add (startLabel);
        left.add (startDate);
        right.add (endLabel);
        right.add (endDate);
        first.add (left);
        first.add (right);
        
        /**Setting up the second row*/
        second.add (empLabel);
        second.add (empID);
        
        /**Adding ActionListeners*/
        sales.addActionListener (this);
        both.addActionListener (this);
        shipment.addActionListener (this);
        value.addActionListener (this);
        income.addActionListener (this);
        
        /**First button level*/
        buttons1.add (sales);
        buttons1.add (both);
        buttons1.add (shipment);
        
        /**Second button level*/
        buttons2.add (value);
        buttons2.add (income);
        
        
        /**Putting it all together*/
        container.add (first);
        container.add (second);
        container.add (buttons1);
        container.add (buttons2);
        
        this.add (container);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack(); /**Opens in the middle of the screen*/
        this.setLocationRelativeTo(null); /**Opens in the middle of the screen*/
        this.setVisible(true);
    }


    public void actionPerformed (ActionEvent e)
    {
        String action = e.getActionCommand();
    
        
    
    }
}
