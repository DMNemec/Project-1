package POS_DAO;

import java.io.*;
import PosPanels.MainFrame;
import java.util.*;
import java.util.logging.*;



public class REPORTS 
	{
    
    		private final MainFrame window;
    
   		public REPORTS(MainFrame wins)
		{
        		window=wins;
    	}

    public void createReport()
    {
        
        FileWriter fileName;
        try 
	{
            fileName = new FileWriter(window.getLogFileName(),true);
            for (String logger : window.getUserLog().getLog())
		 {
                	fileName.write(cypherLog(logger + "\r\n"));
            	 }
            
	    fileName.close();  
            window.resetUserLog();

        }
	 catch (IOException ex) 
	{
            Logger.getLogger(REPORTS.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }


  public String[] showReport(String route)
	{
        	ArrayList<String> text= new ArrayList<>();
        try 
	{
            Scanner dataIn = new Scanner(new FileInputStream(route));
            
	    while(dataIn.hasNext())
		{
                    text.add(decypherLog(dataIn.nextLine()));
            	}
            
	    fileIn.close();
        } 
	catch (FileNotFoundException ex) {
            Logger.getLogger(REPORTS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String[] getDat= new String[text.size()];
        getDat = text.toArray(getDat);
        return getDat;
    }
 public void writeData(String route, String logTxt) 
    {
        
        FileWriter fileName;
        try 
	{
            fileName = new FileWriter(route);
            fileName.write(logTxt);
            fileName.close();  
        } 
	catch (IOException ex) 
	{
            Logger.getLogger(REPORTS.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }


  public String[] addDB() 
  {
        File usr = new File(System.getenv("APPDATA")+"/SE/Project/UsersTrack/"+window.getCurrentUser().getUsername());
        File time = new File(System.getenv("APPDATA")+"/SE/Project/UsersTrack/"+ window.getCurrentUser().getUsername()+"/"+
                Calendar.getInstance().get(Calendar.MONTH));
        
        if (!user.exists())
	{
            user.mkdir();
            time.mkdir();
        }
	else
	{
             if (!time.exists())time.mkdir();
        }
        
	String userRoute=System.getenv("APPDATA")+"/SE/Project/UsersTrack/"+window.getCurrentUser().getUsername()+"/"+
                Calendar.getInstance().get(Calendar.MONTH);    
        
        String text="/Log "+Calendar.getInstance().getTime()+".lg";
        
	String fileName=usr +text.replaceAll(":", "").substring(0, 18);
        
	String[] path={usr,fileName};
        
	return path;
  }

 public String deReport(String text) 
   {

        StringBuilder cool = new StringBuilder();
        for (char index : text.toCharArray()) 
        {
                    cool.append((char) ((i - 32 - 3) % 96 + 32));     
        }
        return cool.toString();
    }

 public String cyRep(String text) 
   {

        StringBuilder cool = new StringBuilder();
        for (char inex : text.toCharArray())
	 {
                    cool.append((char) ((i - 32 + 3) % 96 + 32));
         }
        return cool.toString();
   }

}


