/**
 * When an Admin logs in this loads and lists everything
 * that an Admin can do
 * 
 * Writen by Dalton Lee
 * 
 * Version 1.0
 * 3/11/2016
 */
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;

public class Admin_GUI extends JFrame implements ActionListener
{
    // instance variables - replace the example below with your own
    private String ID;
    private JPanel container = new JPanel ();
    private JPanel buttonContainer = new JPanel(); /**Random panel that doesn't do much*/
    private JPanel reset     = new JPanel();
    private JPanel buttons1  = new JPanel();
    private JPanel buttons2  = new JPanel();
    
    /**Change password*/
    private JButton settings;
    private Icon buttonIcon;
    
    /**Left column*/
    private JButton searchItem;
    private JButton shipment;
    private JButton createItem;
    private JButton audit;
    
    /**right column*/
    private JButton checkOut;
    private JButton searchEmp;
    private JButton createEmp;
    private JButton categories;

     public static void main (String [] args) /**For Testing*/
    {

        Admin_GUI test = new Admin_GUI ("5067759");

    }
    
    
    /**
     * Constructor for objects of class Admin_GUI
     */
    public Admin_GUI(String emp)
    {
        ID = emp;
        this.setMinimumSize (new Dimension (800, 700));
        this.setTitle ("ID: " + ID + " (Admin)");
        this.setLayout(new GridBagLayout()); /**Auto sets the JPanel to the center*/
        
        container.setLayout (new BoxLayout (container, BoxLayout.Y_AXIS));
        buttonContainer.setLayout (new BoxLayout (buttonContainer, BoxLayout.X_AXIS));
        reset.setLayout     (new BoxLayout (reset, BoxLayout.X_AXIS));
        buttons1.setLayout  (new BoxLayout (buttons1, BoxLayout.Y_AXIS));
        buttons2.setLayout  (new BoxLayout (buttons2, BoxLayout.Y_AXIS));
        
        buttons1.add(Box.createRigidArea (new Dimension (50,0)));
        buttons2.add(Box.createRigidArea (new Dimension (50,0)));
        
        /**Reset password button*/
        //buttonIcon = new ImageIcon("settingsGear.gif"); /**finds the button*/
        buttonIcon = new ImageIcon(getClass().getResource("settingsGear.png"));
        settings = new JButton (buttonIcon); /**adds it to the button*/
        settings.setMaximumSize (new Dimension (50, 50));
        reset.setAlignmentX (Component.RIGHT_ALIGNMENT);
        reset.add (settings);
                
        /**Left column*/
        searchItem  = new JButton ("Search Inventory");
        shipment    = new JButton ("Receive Shipment");
        createItem  = new JButton ("Create Item");
        audit       = new JButton ("Audit");
       
        /**Right column*/
        checkOut   = new JButton ("Check-Out");
        searchEmp  = new JButton ("Search Employee");
        createEmp  = new JButton ("Create Employee");
        categories = new JButton ("Item Categories");

        /**All the button action listeners*/
        settings.addActionListener (this);
        searchItem.addActionListener(this);
        shipment.addActionListener(this);
        createItem.addActionListener(this);
        audit.addActionListener(this);
        checkOut.addActionListener(this);
        searchEmp.addActionListener(this);
        createEmp.addActionListener(this);
        categories.addActionListener(this);
        
        /**Add left*/
        buttons1.add (searchItem);
        buttons1.add(Box.createVerticalStrut(10)); /**Vertical space between buttons in a column*/
        buttons1.add (shipment);
        buttons1.add(Box.createVerticalStrut(10));
        buttons1.add (createItem);
        buttons1.add(Box.createVerticalStrut(10));
        buttons1.add (audit);
        
        /**Add right*/
        buttons2.add (checkOut);
        buttons2.add(Box.createVerticalStrut(10));
        buttons2.add (searchEmp);
        buttons2.add(Box.createVerticalStrut(10));
        buttons2.add (createEmp);
        buttons2.add(Box.createVerticalStrut(10));
        buttons2.add (categories);

        buttonContainer.add (buttons1);
        buttonContainer.add (buttons2);
        
        container.add (reset);
        container.add (buttonContainer);
       
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
            System.out.println ("settings");
        }
        else if (action.equals ("Search Inventory"))
        {
            
        }
        else if (action.equals ("Recieve Shipment"))
        {
            Shipment_GUI shipmentInterface = new Shipment_GUI (ID);
        }
        else if (action.equals ("Create Item"))
        {
            
        }
        else if (action.equals ("Audit"))
        {
            Audit auditInterface = new Audit (ID);
        }
        else if (action.equals ("Check Out"))
        {
            
        }
        else if (action.equals ("Search Employee"))
        {
            
        }
        else if (action.equals ("Create Employee"))
        {
            Create_Employee newInterface = new Create_Employee (ID);
        }
        else if (action.equals ("Item Categories"))
        {
            
        }

    }
}
