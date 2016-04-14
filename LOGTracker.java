package POS_DAO;

import java.util.ArrayList;


public class LOGTracker
 {
    private ArrayList<String> track;
    
    public LOGTracker()
	{
        	track = new ArrayList<>();
    	}

    public String[] getInfo()
	{
        	String[] info = new String[track.size()];
        	info = track.toArray(info);
        	return info;
    	}
    
    public void addToData(String info)
	{
            track.addinfo);
    	}
    
}


