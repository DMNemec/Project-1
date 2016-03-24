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
import java.util.*;
import java.lang.*;

public class Employee_GUI extends JFrame implements ActionListener
{
    String ID;
    
    private JPanel container = new JPanel ();
    private JPanel reset     = new JPanel ();
    private JPanel buttons   = new JPanel ();
    
    /**Change password*/
    private JButton settings;
    private Icon buttonIcon;
    
    private JButton shipment;
    private JButton checkOut;
    
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
        
        this.setSize (800, 700);
        this.setTitle ("ID: " + ID);
        this.setLayout(new GridBagLayout()); /**Auto sets the JPanel to the center*/

        shipment = new JButton ("Receive Shipment");
        checkOut = new JButton ("Check-out");
        shipment.addActionListener(this);
        checkOut.addActionListener(this);

        container.setLayout (new BoxLayout (container, BoxLayout.Y_AXIS));
        reset.setLayout     (new BoxLayout (reset, BoxLayout.X_AXIS));
        buttons.setLayout   (new BoxLayout (buttons, BoxLayout.X_AXIS));

        /**Reset password button*/
        buttonIcon = new ImageIcon("settingsGear.gif");
        settings = new JButton (buttonIcon);
        settings.setMaximumSize (new Dimension (50, 50));
        reset.setAlignmentX (Component.RIGHT_ALIGNMENT);
        reset.add (settings);
        
        //buttons.setAlignmentX (Component.CENTER_ALIGNMENT);
        buttons.add (shipment);
        buttons.add(Box.createRigidArea (new Dimension (5,0))); //Have a gap between buttons
        buttons.add (checkOut);

        container.add (reset);
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
        
        if (e.getSource() == settings) /**Settings button with gear picture*/
        {
            System.out.println ("Settings");
        }
        else if (action.equals ("Receive Shipment"))
        {
            Shipment_GUI shipmentInterface = new Shipment_GUI (ID);
        }
        else if (action.equals ("Check-out"))
        {
            JOptionPane.showMessageDialog(null, "Check-out GUI");
        }
    }
}
