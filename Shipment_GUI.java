
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
    private JPanel container = new JPanel ();
    private JPanel buttons = new JPanel ();
    
    private JLabel itemLabel = new JLabel ("Item ID");
    private JTextField itemID = new JTextField(20);
    
    private JLabel priceLabel = new JLabel ("Purchased Price");
    private JTextField price = new JTextField(20);
    
    private JLabel amountLabel = new JLabel ("Amount Received");
    private JTextField amount = new JTextField(20);
    
    private JButton submit = new JButton ("Submit");
    private JButton cancel = new JButton ("Cancel");

    public static void main (String [] args) /**For Testing*/
    {

        Shipment_GUI test = new Shipment_GUI ("5067759", true);

    }
    
    /**
     * Constructor for objects of class Shipment
     */
    public Shipment_GUI(String ID)
    {
        this.setSize (800, 700);
        this.setTitle ("ID: " + ID);
        this.setLayout(new GridBagLayout()); //Auto sets the JPanel to the center
        
        construct ();
    }

    public Shipment_GUI(String ID, boolean admin)
    {
        if (admin == false)
        {
            this.setTitle ("ID: " + ID);
        }
        else
        {
            this.setTitle ("ID: " + ID + " Admin");
        }
        
        this.setLayout(new GridBagLayout()); //Auto sets the JPanel to the center
        
        construct ();
    }
    
    private void construct ()
    {
        this.setSize (800, 700);
        
        container.setLayout (new BoxLayout (container, BoxLayout.Y_AXIS));
        buttons.setLayout (new BoxLayout (buttons, BoxLayout.X_AXIS));

        submit.addActionListener (this);
        cancel.addActionListener (this);
        
        buttons.add (submit);
        buttons.add (cancel);
        
        itemID.setMaximumSize (new Dimension (250, 25)); /**Make the textFields size appropriatly*/
        price.setMaximumSize (new Dimension (250, 25));
        amount.setMaximumSize (new Dimension (250, 25));
        
        container.add (itemLabel);
        container.add (itemID);
        container.add (priceLabel);
        container.add (price);
        container.add (amountLabel);
        container.add (amount);
        container.add (buttons);
        
        this.add (container);
        
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
