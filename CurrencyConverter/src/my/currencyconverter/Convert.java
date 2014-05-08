/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package my.currencyconverter;

import com.sun.syndication.feed.synd.*;
import com.sun.syndication.io.*;
import java.net.*;
import java.util.*;
import java.text.DecimalFormat;
/**
 *
 * @author Drew
 */
public class Convert {
    /**
     * @param args the command line arguments
     * -----NOTE: RSS TITLE FORMAT:    "TO_COUNTRY/FROM_COUNTRY"
     */
    
    String From, To;//these are sent from GUI, and are set by the user
    String URLstr = "http://themoneyconverter.com/rss-feed/";
    HashMap<String,Double> cMap;
    
    Convert() {
        //declare cMap
        cMap = new HashMap<String,Double>();
    }//end of constructor
    
    public void update(String f){
        From = f;
        SyndFeed feed = null;
        cMap.clear();
        
        try {
            URL feedUrl = new URL(URLstr+From+"/rss.xml");

            SyndFeedInput input = new SyndFeedInput();
            feed = input.build(new XmlReader(feedUrl));
        }
        
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ERROR: "+ex.getMessage());
        }
        
        String[] rateToken;
        if (feed != null) {
            for (SyndEntry entry : (List<SyndEntry>) feed.getEntries()) {
                String title = entry.getTitle();
                String descr = entry.getDescription().getValue();
                
                //PARSE FOR RATE
                rateToken = descr.split(" = ");
                String string1 = rateToken[1];
                String stringRate = string1.substring(0, string1.indexOf(" "));
                stringRate = stringRate.replace(",", "");
                Double rate = Double.valueOf(stringRate);
                
                //populate the hashmap
                cMap.put(title, rate);
            }
        } else {
            System.out.println("RSS Feed unavailable.");
        }
    }//end of update()
    
    public String getRate(String from, String to){
        From = from;
        To = to;
        String unit = To + "/" + From;
        String rate = String.valueOf(cMap.get(unit));
        return rate;
    }
    public String getConvertValue(String from, String to, String current){
        Double convert = Double.valueOf(current);
        String rate = getRate(from, to);//getRate from hashmap
        Double rateMultiplier = Double.valueOf(rate);//change getRate() to double
        convert *= rateMultiplier;//do the math
        
        //add 2 decimal places
        DecimalFormat decim = new DecimalFormat("0.00");
        Double dbl = Double.parseDouble(decim.format(convert));
        String desired = String.valueOf(dbl);//cast to string for GUI
        return desired;
    }//end of getRate
    
}//end of class
