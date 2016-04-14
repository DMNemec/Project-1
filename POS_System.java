package POS_DAO;

import DAOs.ReportsDAO;
import PosPanels.LoginPanel;
import PosPanels.MainFrame;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class POS_System {

    
    public static void main(String[] args)
	 {
        	MainFrame window = new MainFrame();
        
        
       	 	java.awt.EventQueue.invokeLater(new Runnable()
		 {
            		@Override
            		public void runNow() 
			{
                
               	 		System.out.println(System.getenv("APPDATA")+"/SE/Project/UsersTrack/");
                		window.setVisible(true);
                		window.add(new LoginPanel(window));
            		}
        	});
    	}
    
}