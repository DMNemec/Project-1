
/**
 * Write a description of class Category here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import POS_DAO.Inventory_DAO;

@SuppressWarnings("serial")
public class Category extends JPanel implements ActionListener
{
    private JLabel name;
    private JLabel amount; //Number of Items with that category type
    private JTextField discount = new JTextField();
    private JButton remove = new JButton ("Remove");
    
    /**
     * Constructor for objects of class Category
     */
    public Category()//Going to accept a string
    {
        this.setLayout (null);
        this.setMaximumSize(new Dimension(1400, 50));
        
        /**Create the DAO here*/
        name = new JLabel ("Test");
        amount = new JLabel ("42");
        
        remove.addActionListener (this);
                
        /**Document Listener for discount*/
        discount.getDocument().addDocumentListener (new DocumentListener()
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
                /**Update the database here*/
                System.out.println ("Updating the database");
            }
            
        });
        
        /**Absolute Positioning of the components*/
        Insets insets = this.getInsets(); /**The dimensions of the JPanel*/
        
        this.add (name);
        name.setBounds (50 + insets.left, 10 + insets.top,
                        250, 25);
        this.add (amount);
        amount.setBounds (255 + insets.left, 10 + insets.top,
                          250, 25);
        this.add (discount);
        discount.setBounds (415 + insets.left, 10 + insets.top,
                            100, 25);
        this.add (remove);
        remove.setBounds (575 + insets.left, 10 + insets.top,
                          90, 25);
        
        this.setVisible(true);
    }

    public void actionPerformed (ActionEvent e)
    {
        String action = e.getActionCommand();
        
        if (action.equals ("Remove"))
        {
            //Delete the category from the database
        	Inventory_DAO inventory = new Inventory_DAO();
        	inventory.DeleteCategory(name.getText()); //TODO verify this works properly
            System.out.println ("Category removed");
            System.out.println ("Populating the frame");
        }
    }
}
