
/**
 * Three buttons that allow the customer to pay with either a credit/debit card,
 * a check, or cash. if they use the the frist two, then the sale will be recorded
 * in the store's profits. If they use cash then they load the Cash_Payment interface.
 * 
 * Dalton Lee
 * 3/11/2016
 * Version 1.0
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;

public class Payment_Options extends JFrame implements ActionListener
{
    // instance variables - replace the example below with your own
    private double cost;
    
    private JPanel buttons    = new JPanel ();
    private JPanel topButtons = new JPanel ();
    private JPanel lowButtons = new JPanel ();

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
        
        this.setMinimumSize (new Dimension (800, 700));
        this.setTitle ("ID: " + ID);
        this.setLayout(new GridBagLayout()); //Auto sets the JPanel to the center
        
        construct ();  
    }
    
    public Payment_Options(String ID, boolean admin, double total)
    {
        cost = total;
        
        if (admin == false)
        {
            this.setTitle ("ID: " + ID);
        }
        else
        {
            this.setTitle ("ID: " + ID + " Admin");
        }
        
        this.setLayout(new GridBagLayout()); //Auto sets the JPanel to the center
        this.setSize (800, 700);
        construct ();
    }

    private void construct ()
    {
        buttons.setLayout (new BoxLayout (buttons, BoxLayout.Y_AXIS));
        topButtons.setLayout (new BoxLayout (topButtons, BoxLayout.X_AXIS));
        lowButtons.setLayout (new BoxLayout (lowButtons, BoxLayout.X_AXIS));
        
        plastic.addActionListener (this);
        check.addActionListener (this);
        cash.addActionListener (this);
        
        topButtons.add (plastic);
        topButtons.add (check);
        
        lowButtons.add (cash);
        
        buttons.add (topButtons);
        buttons.add (lowButtons);
        
        this.add (buttons);
        
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
