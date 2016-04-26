/**
 * When an Admin logs in this loads and lists everything
 * that an Admin can do
 * 
 * Writen by Dalton Lee
 * 
 * 4/20/2016
 */
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Admin_GUI extends JFrame implements ActionListener
{
    // instance variables - replace the example below with your own
    private String ID;
    
    /**Change password*/
    private JButton settings = new JButton ("Settings");
    
    /**Left column*/
    private JButton searchItem = new JButton ("Search Inventory");
    private JButton shipment = new JButton ("Receive Shipment");
    private JButton createItem = new JButton ("Create Item");
    private JButton audit = new JButton ("Audit");
    
    /**right column*/
    private JButton checkOut = new JButton ("Check-Out");
    private JButton searchEmp = new JButton ("Search Employee");
    private JButton createEmp = new JButton ("Create Employee");
    private JButton categories = new JButton ("Item Categories");


     @SuppressWarnings("unused")
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
        this.setLayout (null);
        this.setMinimumSize (new Dimension (650, 550));
        this.setTitle ("ID: " + ID + " (Admin)");

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
        
        /**Absolute Positioning of the components*/
        Insets insets = this.getInsets(); /**The dimentsions of the JFrame*/
        
        /**Add settings*/
        this.add (settings);
        settings.setBounds (500 + insets.left, 35 + insets.top,
                            100, 25);
        
        /**Add left*/
        this.add (searchItem);
        searchItem.setBounds (125 + insets.left, 125 + insets.top,
                              150, 50);
        this.add (shipment);
        shipment.setBounds (125 + insets.left, 190 + insets.top,
                            150, 50);
        this.add (createItem);
        createItem.setBounds (125 + insets.left, 255 + insets.top,
                              150, 50);
        this.add (audit);
        audit.setBounds (125 + insets.left, 325 + insets.top,
                         150, 50);
        
        /**Add right*/
        this.add (checkOut);
        checkOut.setBounds (350 + insets.left, 125 + insets.top,
                            150, 50);
        this.add (searchEmp);
        searchEmp.setBounds (350 + insets.left, 190 + insets.top,
                             150, 50);
        this.add (createEmp);
        createEmp.setBounds (350 + insets.left, 255 + insets.top,
                             150, 50);
        this.add (categories);
        categories.setBounds (350 + insets.left, 325 + insets.top,
                              150, 50);
        
        this.setResizable (false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack(); /**Opens in the middle of the screen*/
        this.setLocationRelativeTo(null); /**Opens in the middle of the screen*/
        this.setVisible(true);
    }

    public void actionPerformed (ActionEvent e)
    {
    	//TODO - Everything
        String action = e.getActionCommand();
        
        if (action.equals ("Settings")) /**Settings button with gear picture e.getSource() = settings*/
        {
            System.out.println ("settings");
        }
        else if (action.equals ("Search Inventory"))
        {
            
        }
        else if (action.equals ("Recieve Shipment"))
        {
            //Shipment_GUI shipmentInterface = new Shipment_GUI (ID);
        }
        else if (action.equals ("Create Item"))
        {
            
        }
        else if (action.equals ("Audit"))
        {
            //Audit auditInterface = new Audit (ID);
        }
        else if (action.equals ("Check Out"))
        {
            
        }
        else if (action.equals ("Search Employee"))
        {
            
        }
        else if (action.equals ("Create Employee"))
        {
            //Create_Employee newInterface = new Create_Employee (ID);
        }
        else if (action.equals ("Item Categories"))
        {
            
        }

    }
}
