/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package my.currencyconverter;

import java.io.FileNotFoundException;  
import java.io.FileReader;  
import java.io.IOException;  
import java.util.Iterator;  
import org.json.simple.JSONArray;  
import org.json.simple.JSONObject;  
import org.json.simple.parser.JSONParser;  
import org.json.simple.parser.ParseException;

/**
 *
 * @author Drew
 */
public class jsonReader {
        //Country[] CountryArray = new Country[90];
        JSONParser parser = new JSONParser();  
        
        public void readjson (String userSelection) {
            try {  
            Object obj = parser.parse(new FileReader("C:\\Users\\Drew"
                    + "\\Documents\\Programming\\Java\\NetBeans"
                    + "\\CurrencyConverter\\CountryJSONFile.json"));  

            JSONObject jsonObject = (JSONObject) obj;  

            //String nameOfCountry = (String) jsonObject.get("Name");  
            //System.out.println("Name Of Country: "+nameOfCountry);  
            //
            //long population = (long) jsonObject.get("Population");  
            //System.out.println("Population: "+population);  
            //
            //System.out.println("States are :");  
            JSONArray listOfCountries = (JSONArray) jsonObject.get("Country");  
            Iterator<String> iterator = listOfCountries.iterator();  
            while (iterator.hasNext()) {  
             System.out.println(iterator.next());  
            }  
            } catch (FileNotFoundException e) {  
               e.printStackTrace();  
            } catch (IOException e) {  
               e.printStackTrace();  
            } catch (ParseException e) {  
               e.printStackTrace();  
            }  
        }
        
        
    
}

//combo box model is the data model
//from reader convert to object (array)
//
//oracle java how to use models
//
///use json file to store each url for rss feed
//money converter.com
//model file will read json do all converting and send value to the ui