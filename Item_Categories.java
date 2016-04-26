
/**
 * Write a description of class Item_Categories here.
 * 
 * Dalton Lee
 * 1.0 4/5/2016
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;

public class Item_Categories extends JFrame implements ActionListener
{
    private String ID;
    
    private JPanel results = new JPanel();
    
    private JButton newCat = new JButton ("New");
    
    private JLabel items = new JLabel ("# Items");
    private JLabel discount = new JLabel ("Discount %");
    
    
    public static void main (String [] args) /**For Testing*/
    {

        Item_Categories test = new Item_Categories ("5067759");

    }

    /**
     * Constructor for objects of class Item_Categories
     */
    public Item_Categories(String emp)
    {
        ID = emp;
        
        this.setTitle ("ID: " + ID);
        this.setPreferredSize(new Dimension(800, 700));
        this.setLayout(null);

        this.setResizable (false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack(); /**Opens in the middle of the screen*/
        this.setLocationRelativeTo(null); /**Opens in the middle of the screen*/
        this.setVisible(true);
        
        /**Absolute Positioning of the components*/
        Insets insets = this.getInsets(); /**The dimentsions of the JFrame*/
        
        newCat.addActionListener (this);
        this.add (newCat);
        newCat.setBounds (50 + insets.left, 0 + insets.top,
                          100, 30);
        this.add (items);
        items.setBounds (280 + insets.left, 5 + insets.top,
                         100, 25);
        this.add (discount);
        discount.setBounds (470 + insets.left, 5 + insets.top,
                            100, 30);
        this.add (results);
        results.setBounds (35 + insets.left, 40 + insets.top,
                           700, 550);
        results.setBorder (BorderFactory.createLineBorder(Color.black)); /** Puts a boarder on the JPanel*/
        
        while (true)
        {
            //always check the database to see if the count has changed
            //if changed repaint
            break;
            
        }
    }

    private void refresh () /**Refreshes the results JPanel*/
    {
        this.remove (results);
        results = new JPanel();
        results.setLayout (new BoxLayout (results, BoxLayout.Y_AXIS));
        Insets insets = this.getInsets(); /**The dimentsions of the JFrame*/
        this.add (results);
        results.setBounds (40 + insets.left, 95 + insets.top,
                           700, 550);
        
        results.setBorder (BorderFactory.createLineBorder(Color.black)); /** Puts a boarder on the JPanel*/
        
        results.add(Box.createVerticalStrut(10));
        
        for (int x = 0; x < 5; x++)
        {
            results.add (new Category ());
            results.add(Box.createVerticalStrut(20));
        }

        this.revalidate(); /**Need both revalidate and repaint*/
        this.repaint();
    }
    
    
    public void actionPerformed (ActionEvent e)
    {
        String action = e.getActionCommand();
        
        if (action.equals ("New"))
        {
            /**Option panel pops up with a textbox and an OK and Cancel buttons
             * On OK it adds it to that database and refreshes the results JPanel
             */
            System.out.println ("NEW CATEGORY");
            refresh();
        }
        
    }
    
    
    
    
    
    
    
    /** SCROLL BAR
     * limit each thing to a set number of panels
     * throw into an array of JPanels
     * move the pointer to a up one based on the scale of the scroll bar
     */
}
