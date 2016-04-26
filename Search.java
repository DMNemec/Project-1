
/**
 * Write a description of class Search here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;

public class Search extends JFrame implements ActionListener
{
    private String ID;

    private JTextField search = new JTextField();
    private JButton go = new JButton ("Go");
    
    private JPanel results = new JPanel();
    
    public static void main (String [] args) /**For Testing*/
    {

        Search test = new Search ("5067759");

    }
    
    
    /**
     * Constructor for objects of class Search
     */
    public Search(String emp)
    {
        ID = emp;

        this.setPreferredSize(new Dimension(800, 700));
        this.setTitle ("ID: " + ID + " (Admin)");
        this.setLayout(null); /**Auto sets the JPanel to the center*/
        
        /**Absolute Positioning of the components*/
        Insets insets = this.getInsets(); /**The dimentsions of the JFrame*/
        
        this.add (search);
        search.setBounds (75 + insets.left, 40 + insets.top,
                          500, 25);
        this.add (go);
        go.addActionListener (this);
        go.setBounds (600 + insets.left, 25 + insets.top,
                      100, 40);
        this.add (results);
        results.setBounds (40 + insets.left, 95 + insets.top,
                           700, 550);
        results.setBorder (BorderFactory.createLineBorder(Color.black)); /** Puts a boarder on the JPanel*/
        
        this.setResizable (false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack(); /**Opens in the middle of the screen*/
        this.setLocationRelativeTo(null); /**Opens in the middle of the screen*/
        this.setVisible(true);
    }

    private void refresh ()
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
            results.add (new Item_Search ());
            results.add(Box.createVerticalStrut(20));
        }

        this.revalidate(); /**Need both revalidate and repaint*/
        this.repaint();
    }
    
    
    
     public void actionPerformed (ActionEvent e)
    {
        String action = e.getActionCommand();
        
        if (action.equals ("Go"))
        {
            refresh();
        }
    }
}
