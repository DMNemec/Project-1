
/**
 * Allows an employee to take a cash payment. The payment JTextField is live and
 * updates the change JLabel whenever the user puts in a value. When OK is entered
 * the sale will be recorded in the store's profits. (Only accepted if the value is positive)
 * 
 * Dalton Lee
 * 3/11/2016
 * version 1.0
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.Document;
import java.util.*;
import java.lang.*;
import java.text.*; /**For money format*/


public class Cash_Payment extends JFrame implements ActionListener
{
    private static double cost;
    private JPanel container = new JPanel ();
    private JPanel row2 = new JPanel ();
    private JPanel buttons = new JPanel ();
    
    private JLabel total;
    private JLabel paymentLabel = new JLabel ("Payment: ");
    private JTextField payment = new JTextField (20);
    private static JLabel changeLabel = new JLabel ("Cost:            $0.00");
    
    JButton ok = new JButton ("OK");
    JButton cancel = new JButton ("Cancel");
    
    public static void main (String [] args) /**For Testing*/
    {

        Cash_Payment test = new Cash_Payment (42.99);

    }
    
    
    /**
     * Constructor for objects of class Cash_Payment
     */
    public Cash_Payment(double cost)
    {
        this.cost = cost;
        total = new JLabel ("Total:           $" + cost); 
        
        container.setLayout (new BoxLayout (container, BoxLayout.Y_AXIS));
        row2.setLayout (new BoxLayout (row2, BoxLayout.X_AXIS));
        buttons.setLayout (new BoxLayout (buttons, BoxLayout.X_AXIS));
        
        
        /**Add actionListener to payment*/
        payment.getDocument().addDocumentListener (new DocumentListener() /**See ReadMe file under DocumentListener*/
        {
            @Override
            public void insertUpdate(DocumentEvent e)
            {
                textChange (e);
            }
        
            @Override
            public void removeUpdate(DocumentEvent e)
            {
                textChange (e);
            }
        
            @Override
            public void changedUpdate(DocumentEvent e)
            {
                textChange (e);
            }
        
            private void textChange (DocumentEvent e)
            {
                DecimalFormat moneyFormat = new DecimalFormat ("#.##"); /**Only 2 decimal places*/
                double change = 0.00;
                double money;
                
                DocumentEvent.EventType action = e.getType ();
                
                try /**So we don't crash when the luser enters letters*/
                {
                    money = Double.parseDouble (payment.getText ());
                    change = money - Cash_Payment.cost;
                }
                catch (Exception ex)
                {
                    
                }
                
                if (action.equals (DocumentEvent.EventType.CHANGE)) /**No clue what this does*/
                {
                    Cash_Payment.changeLabel.setText ("Cost:            $" + moneyFormat.format(change));
                }
                else if (action.equals (DocumentEvent.EventType.INSERT)) /**Adding text (Typing)*/
                {
                    Cash_Payment.changeLabel.setText ("Cost:            $" + moneyFormat.format(change));
                }
                else if (action.equals (DocumentEvent.EventType.REMOVE)) /**Removing text (Back space)*/
                {
                    Cash_Payment.changeLabel.setText ("Cost:            $" + moneyFormat.format(change));
                }
            }
        });

        row2.add (paymentLabel);
        row2.add (payment);
        
        ok.addActionListener (this);
        cancel.addActionListener (this);
        
        buttons.add (ok);
        buttons.add (cancel);
        
        container.setAlignmentX (total.LEFT_ALIGNMENT);
        
        container.add (total);
        container.add (row2);
        container.add (changeLabel);
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
        
        if (action.equals ("OK"))
        {
            /**Adds the total to the store's profits and closes itself and payment_Options*/
            dispose();
        }
        else if (action.equals ("Cancel"))
        {
            dispose(); /**Goes back to the payment_Options GUI*/
        }
    }
}
