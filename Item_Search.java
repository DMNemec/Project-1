
/**
 * Write a description of class Item_Search here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.lang.*;

public class Item_Search extends JPanel implements ActionListener
{
    private JLabel name;
    private JLabel price;
    private JLabel stock;
    private JButton select = new JButton ("Select");

    /**
     * Constructor for objects of class Item_Search
     */
    public Item_Search()
    {
        this.setLayout (null);
        this.setMaximumSize(new Dimension(1400, 50));

        /**Create the DAO here*/
        name  = new JLabel ("Test");
        price = new JLabel ("Price:   $0.00");
        stock = new JLabel ("Stock:   42");
        
        select.addActionListener (this);
        
        /**Absolute Positioning of the components*/
        Insets insets = this.getInsets(); /**The dimentsions of the JPanel*/
        
        this.add (name);
        name.setBounds (50 + insets.left, 10 + insets.top,
                        250, 25);
        this.add (price);
        price.setBounds (200 + insets.left, 10 + insets.top,
                         250, 25);
        this.add (stock);
        stock.setBounds (400 + insets.left, 10 + insets.top,
                         250, 25);
        this.add (select);
        select.setBounds (575 + insets.left, 10 + insets.top,
                          75, 25);
        
        this.setVisible (true);
    }

    public void actionPerformed (ActionEvent e)
    {
        String action = e.getActionCommand();
        
        if (action.equals ("Go"))
        {
            System.out.println ("Searching");
        }

    }
}
