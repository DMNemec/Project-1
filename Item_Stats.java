
/**
 * Write a description of class Item_Stats here.
 * 
 * Dalton Lee
 * 3/17/2016
 * Version 1.0
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;

public class Item_Stats extends JFrame implements ActionListener
{
    private String ID;
    private String[] categoryList;
    private JPanel mainContainer = new JPanel ();
    private JPanel container = new JPanel ();
    private JPanel left      = new JPanel ();
    private JPanel center    = new JPanel ();
    private JPanel right     = new JPanel ();
    private JPanel buttons   = new JPanel ();
    
    /**Left column*/
    private JLabel nameLabel = new JLabel ("Name");
    private JLabel costLabel = new JLabel ("Purchasing Cost");
    private JLabel inventoryLabel = new JLabel ("Current Inventory");
    
    private JTextField name = new JTextField (20);
    private JTextField cost = new JTextField (20);
    private JTextField inventory = new JTextField (20);
    
    /**Center column*/
    private JLabel IDLabel = new JLabel ("ID Number");
    private JLabel priceLabel = new JLabel ("Selling Price");
    private JLabel idealLabel = new JLabel ("Ideal Inventory");
    private JLabel discountLabel = new JLabel ("Discount %");
    
    private JTextField IDNumber = new JTextField (20);
    private JTextField sellPrice = new JTextField (20);
    private JTextField ideal = new JTextField (20);
    private JTextField discount = new JTextField (20);
    
    /**Right column*/
    private JLabel categoryLabel = new JLabel ("Category");
    private JLabel markupLabel = new JLabel ("Mark-up %");
    private JLabel minLabel = new JLabel ("Min Inventory");
    
    private JComboBox categoryBox;
    private JTextField markup = new JTextField (20);
    private JTextField minInventory = new JTextField (20);
    
    /**Bottom buttons*/
    private JButton save = new JButton ("Save");
    private JButton delete = new JButton ("Delete");
    
    public static void main (String [] args) /**For Testing*/
    {

        Item_Stats test = new Item_Stats ("5067759");

    }

    /**
     * Constructor for objects of class Audit
     */
    public Item_Stats (String emp)
    {
        ID = emp;
        categoryList = new String[] {"   ", "Cat", "Dog", "Hamster"}; /**Needs to auto fill itself*/
        categoryBox = new JComboBox <String>(categoryList); /**Needs <String> or else it thinks it's unsafe*/
        
        this.setSize (800, 700);
        this.setTitle ("ID: " + ID + " (Admin)");
        this.setLayout(new GridBagLayout()); /**Auto sets the JPanel to the center*/
        
        /**Format all the JPanels*/
        mainContainer.setLayout (new BoxLayout (mainContainer, BoxLayout.Y_AXIS));
        container.setLayout (new BoxLayout (container, BoxLayout.X_AXIS));
        left.setLayout      (new BoxLayout (left, BoxLayout.Y_AXIS));
        center.setLayout    (new BoxLayout (center, BoxLayout.Y_AXIS));
        right.setLayout     (new BoxLayout (right, BoxLayout.Y_AXIS));
        buttons.setLayout   (new BoxLayout (buttons, BoxLayout.X_AXIS));
        
        /**Left column*/
        left.add (nameLabel);
        left.add (name);
        left.add (costLabel);
        left.add (cost);
        left.add (inventoryLabel);
        left.add (inventory);
        
        /**Center column*/
        center.add (IDLabel);
        center.add (IDNumber);
        center.add (priceLabel);
        center.add (sellPrice);
        center.add (idealLabel);
        center.add (ideal);
        center.add (discountLabel);
        center.add (discount);
        
        /**Right column*/
        right.add (categoryLabel);
        right.add (categoryBox);
        right.add (markupLabel);
        right.add (markup);
        right.add (minLabel);
        right.add (minInventory);
        
        /**Buttons*/
        save.addActionListener (this);
        delete.addActionListener (this);
        buttons.add (save);
        buttons.add (delete);
        
        /**Add everything together*/
        container.add (left);
        container.add (center);
        container.add (right);
        mainContainer.add (container);
        mainContainer.add (buttons);
        
        this.add (mainContainer);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack(); /**Opens in the middle of the screen*/
        this.setLocationRelativeTo(null); /**Opens in the middle of the screen*/
        this.setVisible(true);
        
    }

    public void actionPerformed (ActionEvent e)
    {
        String action = e.getActionCommand();
        String comboBoxItem;

    
        if (action.equals ("Save"))
        {
            /**Writes everyting to the database*/
            comboBoxItem = categoryBox.getSelectedItem().toString(); /**Gets the selected value in the box and*/
            System.out.println (comboBoxItem);                       /**changes it to a string*/
            System.out.println ("Item saved");
        }
        else if (action.equals ("Delete"))
        {
            /**Calls a dialog Y/N warning box*/
            
            if (true)
            {
                /**Deletes the data*/
                System.out.println ("Item deleted");
            }
            else
            {
                /**Close the box*/
                System.out.println ("Deletion canceled");
            }
        }
    }
}
