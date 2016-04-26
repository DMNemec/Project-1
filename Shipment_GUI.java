
/**
 * Interface for a employee to update thier inventory after they take a shipment.
 * They have to enter the item ID number, how much they paid for it (Positive),
 * and the amount recieved (Positive). On "OK" the inventory is updated and the 
 * TextFields are cleared. On "Cancel" the JFrame is destroyed.
 * 
 * Dalton Lee
 * 3/11/2016
 * 1.0
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;

public class Shipment_GUI extends JFrame implements ActionListener
{
    private JLabel itemLabel = new JLabel ("Item ID");
    private JTextField itemID = new JTextField(20);
    
    private JLabel amountLabel = new JLabel ("Amount Received");
    private JTextField amount = new JTextField(20);
    
    private JLabel priceLabel = new JLabel ("Purchased Price");
    private JTextField price = new JTextField(20);
    
    private JButton submit = new JButton ("Submit");
    private JButton cancel = new JButton ("Cancel");

    public static void main (String [] args) /**For Testing*/
    {

        Shipment_GUI test = new Shipment_GUI ("5067759");

    }
    
    /**
     * Constructor for objects of class Shipment
     */
    public Shipment_GUI(String ID)
    {
        this.setTitle ("ID: " + ID);
        this.setLayout(null);
        
        submit.addActionListener (this);
        cancel.addActionListener (this);
        
        /**Absolute Positioning of the components*/
        Insets insets = this.getInsets(); /**The dimentsions of the JFrame*/
        
        this.add (itemLabel);
        itemLabel.setBounds (175 + insets.left, 25 + insets.top,
                             250, 25);
        this.add (itemID);
        itemID.setBounds (120 + insets.left, 50 + insets.top,
                          150, 25);
        this.add (amountLabel);
        amountLabel.setBounds (145 + insets.left, 90 + insets.top,
                               250, 25);
        this.add (amount);
        amount.setBounds (120 + insets.left, 115 + insets.top,
                          150, 25);
        this.add (priceLabel);
        priceLabel.setBounds (145 + insets.left, 155 + insets.top,
                              150, 25);
        this.add (price);
        price.setBounds (120 + insets.left, 180 + insets.top,
                          150, 25);
        this.add (submit);
        submit.setBounds (85 + insets.left, 225 + insets.top,
                          100, 40);
        this.add (cancel);
        cancel.setBounds (210 + insets.left, 225 + insets.top,
                          100, 40);
        
        
        this.setResizable (false);
        this.setPreferredSize(new Dimension(400,400));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack(); /**Opens in the middle of the screen*/
        this.setLocationRelativeTo(null); /**Opens in the middle of the screen*/
        this.setVisible(true);
    }

    public void actionPerformed (ActionEvent e)
    {
        String action = e.getActionCommand();
        
        if (action.equals ("Submit"))
        {
            itemID.setText(""); /**Clears the text from the field*/
            price.setText("");
            amount.setText("");
            
            /**Stuff gets sent to the audit and the database*/
        }
        else if (action.equals ("Cancel"))
        {
            dispose(); /**Destroy the JFrame object*/
        }
    }
}
