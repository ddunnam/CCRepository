/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package my.currencyconverter;

/**
 *
 * @author Drew
 */


public class Country {
    private String Name, Unit, rss;
    public Country () {}
    
    //Constructor
    Country(String name, String unit){
        super();
        Name = name;
        Unit = unit;
        rss = "http://themoneyconverter.com/rss-feed/" + unit + "/rss.xml";
    }
    
    public String getUnit(){
        return Unit;
    }
    
}
