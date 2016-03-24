
/**
 * Write a description of class Item_Categories here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;

public class Item_Categories extends JFrame implements ActionListener
{
    private String ID;
    
    private JPanel container = new JPanel ();
    private JPanel topRow = new JPanel ();
    private JPanel results;
    
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
        results  = new JPanel ();
        
        this.setSize (800, 700);
        this.setPreferredSize(new Dimension(800, 700));
        this.setTitle ("ID: " + ID + " (Admin)");
        this.setLayout(new GridBagLayout()); /**Auto sets the JPanel to the center*/
        
        container.setLayout (new BoxLayout (container, BoxLayout.Y_AXIS));
        topRow.setLayout    (new BoxLayout (topRow, BoxLayout.X_AXIS));
        results.setLayout   (new BoxLayout (results, BoxLayout.Y_AXIS));
        
        /**Add things to topRow*/
        topRow.add (newCat);
        topRow.add (items);
        topRow.add (discount);
        
        /**Add basic things to results*/
        refresh();
        results.setPreferredSize(new Dimension(500,500));
        results.setMinimumSize (new Dimension (500, 500));
        results.setBorder (BorderFactory.createLineBorder(Color.black));
        
        /**Putting everything into container*/
        container.add (topRow);
        container.add (results);
        
        this.add (container);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack(); /**Opens in the middle of the screen*/
        this.setLocationRelativeTo(null); /**Opens in the middle of the screen*/
        this.setVisible(true);
    }

    private void refresh () /**Refreshes the results JPanel*/
    {
        results  = new JPanel ();
    }
    
    
    public void actionPerformed (ActionEvent e)
    {
        String action = e.getActionCommand();
        
        if (action.equals ("New"))
        {
            /**Option panel pops up with a textbox and an OK and Cancel buttons
             * On OK it adds it to that database and refreshes the results JPanel
             */
        }
        
    }
}
