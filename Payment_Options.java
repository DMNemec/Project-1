
/**
 * Three buttons that allow the customer to pay with either a credit/debit card,
 * a check, or cash. if they use the the frist two, then the sale will be recorded
 * in the store's profits. If they use cash then they load the Cash_Payment interface.
 * 
 * Dalton Lee
 * 4/20/2016
 * Version 1.0
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;

public class Payment_Options extends JFrame implements ActionListener
{
    private double cost;

    private JButton plastic = new JButton ("Credit/Debit");
    private JButton check   = new JButton ("Check");
    private JButton cash    = new JButton ("Cash");

    public static void main (String [] args) /**For Testing*/
    {

        Payment_Options test = new Payment_Options ("5067759",42.99);

    }
    
    /**
     * Constructor for objects of class Payment_Options
     */
    public Payment_Options(String ID, double total)
    {
        cost = total;
        
        this.setPreferredSize (new Dimension (500, 400));
        this.setTitle ("ID: " + ID);
        this.setLayout(null);
        
        plastic.addActionListener (this);
        check.addActionListener (this);
        cash.addActionListener (this);
        
        /**Absolute Positioning of the components*/
        Insets insets = this.getInsets(); /**The dimentsions of the JFrame*/
        this.add (plastic);
        plastic.setBounds (125 + insets.left, 95 + insets.top,
                           100, 40);
        this.add (check);
        check.setBounds (275 + insets.left, 95 + insets.top,
                         100, 40);
        this.add (cash);
        cash.setBounds (200 + insets.left, 155 + insets.top,
                        100, 40);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack(); /**Opens in the middle of the screen*/
        this.setLocationRelativeTo(null); /**Opens in the middle of the screen*/
        this.setVisible(true);
         
    }

    public void actionPerformed (ActionEvent e)
    {
        String action = e.getActionCommand();
        
        if (action.equals ("Credit/Debit"))
        {
            /**Adds the total to the store's profits*/
            dispose();
        }
        else if (action.equals ("Check"))
        {
             /**Adds the total to the store's profits*/
             dispose();
        }
        else if (action.equals ("Cash"))
        {
            /**Opens the cash payment GUI*/
        }
    }
}
