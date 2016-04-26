/**
 * When an employee logs in, this is loaded and shows
 * everything that an employee can do
 * 
 * Dalton Lee 
 * 1.0
 * 2/28/2016
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Employee_GUI extends JFrame implements ActionListener
{
    String ID;
    
    private JButton settings = new JButton ("Settings");
    private JButton shipment = new JButton ("Receive Shipment");
    private JButton checkOut = new JButton ("Check-out");
    
    @SuppressWarnings("unused")
	public static void main (String [] args) /**For Testing*/
    {

        Employee_GUI test = new Employee_GUI ("8496738");

    }

    /**
     * Constructor for objects of class Employee_View
     */
    public Employee_GUI(String emp)
    {
        ID = emp;
        
        this.setTitle ("ID: " + ID);
        this.setLayout(null);

        settings.addActionListener(this);
        shipment.addActionListener(this);
        checkOut.addActionListener(this);
        
        /**Absolute Positioning of the components*/
        Insets insets = this.getInsets(); /**The dimentsions of the JFrame*/
        
        /**Adding components*/
        this.add (settings);
        settings.setBounds (365 + insets.left, 20 + insets.top,
                            100, 25);
        this.add (shipment);
        shipment.setBounds (90 + insets.left, 145 + insets.top,
                            150, 50);
        this.add (checkOut);
        checkOut.setBounds (265 + insets.left, 145 + insets.top,
                            150, 50);

        this.setPreferredSize(new Dimension(500,400));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack(); /**Opens in the middle of the screen*/
        this.setLocationRelativeTo(null); /**Opens in the middle of the screen*/
        this.setVisible(true);
    }
    
    public void actionPerformed (ActionEvent e)
    {
        String action = e.getActionCommand();
        
        if (e.getSource() == settings) /**Settings button with gear picture*/
        {
            System.out.println ("Settings");
        }
        else if (action.equals ("Receive Shipment"))
        {
            //Shipment_GUI shipmentInterface = new Shipment_GUI (ID);
        }
        else if (action.equals ("Check-out"))
        {
            JOptionPane.showMessageDialog(null, "Check-out GUI");
        }
    }
}
