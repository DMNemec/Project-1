
/**
 * Write a description of class Audit here.
 * 
 * Dalton Lee
 * 4/20/2016
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;

public class Audit extends JFrame implements ActionListener
{
    private String ID;
    
    private JLabel startLabel = new JLabel ("Start Date");
    private JLabel endLabel   = new JLabel ("End Date");
    private JLabel empLabel   = new JLabel ("Employee ID");
    
    private JTextField startDate = new JTextField (20);
    private JTextField endDate   = new JTextField (20);
    private JTextField empID     = new JTextField (20);
    
    private JButton sales    = new JButton ("Sales");
    private JButton both     = new JButton ("Both");
    private JButton shipment = new JButton ("Shipment");
    private JButton value    = new JButton ("Inv. Value");
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
        this.setLayout(null);
        
        /**Adding ActionListeners*/
        sales.addActionListener (this);
        both.addActionListener (this);
        shipment.addActionListener (this);
        value.addActionListener (this);
        income.addActionListener (this);
        
        /**Absolute Positioning of the components*/
        Insets insets = this.getInsets(); /**The dimentsions of the JFrame*/
        
        this.add (startLabel);
        startLabel.setBounds (125 + insets.left, 25 + insets.top,
                              250, 25);
        this.add (startDate);
        startDate.setBounds (75 + insets.left, 50 + insets.top,
                             150, 25);
        this.add (endLabel);
        endLabel.setBounds (300 + insets.left, 25 + insets.top,
                            250, 25);
        this.add (endDate);
        endDate.setBounds (250 + insets.left, 50 + insets.top,
                           150, 25);
        this.add (empLabel);
        empLabel.setBounds (205 + insets.left, 110 + insets.top,
                            250, 25);
        this.add (empID);
        empID.setBounds (160 + insets.left, 135 + insets.top,
                         150, 25);
        this.add (sales);
        sales.setBounds (50 + insets.left, 175 + insets.top,
                         100, 40);
        this.add (both);
        both.setBounds (190 + insets.left, 175 + insets.top,
                        100, 40);
        this.add (shipment);
        shipment.setBounds (330 + insets.left, 175 + insets.top,
                            100, 40);
        this.add (value);
        value.setBounds (125 + insets.left, 235 + insets.top,
                         100, 40);
        this.add (income);
        income.setBounds (265 + insets.left, 235 + insets.top,
                          100, 40);
        
        

        this.setResizable (false);
        this.setPreferredSize(new Dimension(500,400));
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
