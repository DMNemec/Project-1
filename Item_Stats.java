
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

        this.setTitle ("ID: " + ID);
        this.setLayout(null); /**Auto sets the JPanel to the center*/

        /**Buttons*/
        save.addActionListener (this);
        delete.addActionListener (this);
        
        /**Absolute Positioning of the components*/
        Insets insets = this.getInsets(); /**The dimentsions of the JFrame*/
        
        /**Left*/
        this.add (nameLabel);
        nameLabel.setBounds (110 + insets.left, 25 + insets.top,
                             250, 25);
        this.add (name);
        name.setBounds (50 + insets.left, 50 + insets.top,
                        150, 25);
        this.add (costLabel);
        costLabel.setBounds (80 + insets.left, 110 + insets.top,
                             250, 25);
        this.add (cost);
        cost.setBounds (50 + insets.left, 135 + insets.top,
                        150, 25);
        this.add (inventoryLabel);
        inventoryLabel.setBounds (75 + insets.left, 195 + insets.top,
                                  250, 25);
        this.add (inventory);
        inventory.setBounds (50 + insets.left, 220 + insets.top,
                             150, 25);
        
        /**Center*/
        this.add (IDLabel);
        IDLabel.setBounds (285 + insets.left, 25 + insets.top,
                           250, 25);
        this.add (IDNumber);
        IDNumber.setBounds (240 + insets.left, 50 + insets.top,
                            150, 25);
        this.add (priceLabel);
        priceLabel.setBounds (275 + insets.left, 110 + insets.top,
                              250, 25);
        this.add (sellPrice);
        sellPrice.setBounds (240 + insets.left, 135 + insets.top,
                             150, 25);
        this.add (idealLabel);
        idealLabel.setBounds (275 + insets.left, 195 + insets.top,
                              250, 25);
        this.add (ideal);
        ideal.setBounds (240 + insets.left, 220 + insets.top,
                         150, 25);
        this.add (discountLabel);
        discountLabel.setBounds (285 + insets.left, 280 + insets.top,
                                 250, 25);
        this.add (discount);
        discount.setBounds (240 + insets.left, 305+ insets.top,
                            150, 25);
        
        /**Right*/
        this.add (categoryLabel);
        categoryLabel.setBounds (475 + insets.left, 25 + insets.top,
                                 250, 25);
        this.add (categoryBox);
        categoryBox.setBounds (430 + insets.left, 50 + insets.top,
                               150, 25);
        this.add (markupLabel);
        markupLabel.setBounds (475 + insets.left, 110 + insets.top,
                               250, 25);
        this.add (markup);
        markup.setBounds (430 + insets.left, 135 + insets.top,
                          150, 25);
        this.add (minLabel);
        minLabel.setBounds (465 + insets.left, 195 + insets.top,
                            250, 25);
        this.add (minInventory);
        minInventory.setBounds (430 + insets.left, 220 + insets.top,
                                150, 25);
        
                                /**Buttons*/
        this.add (save);
        save.setBounds (195 + insets.left, 350 + insets.top,
                        100, 40);
        this.add (delete);
        delete.setBounds (330 + insets.left, 350 + insets.top,
                          100, 40);
        
        
        this.setResizable (false);
        this.setPreferredSize(new Dimension(650,550));
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
