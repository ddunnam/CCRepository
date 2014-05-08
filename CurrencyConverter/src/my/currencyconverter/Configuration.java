
package my.currencyconverter;

import flexjson.*;
import java.nio.file.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Drew Dunnam
 */

class Configuration {
    private static String cwd;
    private static String configFile;
    List <String> unitList = new ArrayList<String>();
    private static final String path = ("C:\\Users\\Drew\\Documents\\"
       + "Programming\\Java\\NetBeans\\CurrencyConverter\\resources\\"
       + "CountryJSON.json\\");
    
    private class CountryCodes {
        String Country;
        String Units;
    }
    
    //
    //the constructor will read the json file and convert units
    //to an array that is used to populate comboBoxes
    Configuration () {
        byte[] rawFile;  // read the entire raw configuration file into this var
        
        try {
            cwd = new File( "." ).getCanonicalPath();  // grab the current working directory
            rawFile = Files.readAllBytes(Paths.get(path));
            configFile = new String(rawFile);
            JSONDeserializer<List<CountryCodes>> deserializer = new JSONDeserializer<List<CountryCodes>>();
            List stdMap = deserializer.deserialize(configFile);
            
            //parse the String of country entities and store into unitList
            String delims = "[{,}]";
            String[] token, tokenUnit, tokenCountry;
            String[] unitArray = new String[90];
            String[] nameArray = new String[90];
            for (int i = 0; i < stdMap.size(); i++){
                String str = stdMap.get(i).toString();
                token = str.split(delims);
                String first = token[1];
                tokenUnit = first.split("Units=");
                unitList.add(tokenUnit[1]);
            }
            
        } catch(Exception e) {
            System.out.println(e.toString());
            System.out.println("Something went wrong! Missing file: "+cwd+"/"+path+"?");
        }
    }//end of constructor
    
    public List<String> getUnitList() {return unitList;}
}//end of class
