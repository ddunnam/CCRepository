/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package my.currencyconverter;

import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 *
 * @author Drew
 */
public class jsonWriter {

    //FIRST COLUMN
    Country AED = new Country("United Arab Emirates Dirham", "AED");
    Country ARS = new Country("Argentine Peso", "ARS");
    Country AUD = new Country("Australian Dollar", "AUD");
    Country AWG = new Country("Aruban Florin", "AWG");
    Country BAM = new Country("Bosnia and Herzegovina convertible mark", "BAM");
    Country BBD = new Country("Barbadian Dollar", "BBD");
    Country BDT = new Country("Bangladeshi Taka", "BDT");
    Country BGN = new Country("Bulgarian Lev", "BGN");
    Country BHD = new Country("Bahraini Dinar", "BHD");
    Country BMD = new Country("Bermudian Dollar", "BHD");
    Country BOB = new Country("Bolivian Boliviano", "BOB");
    Country BRL = new Country("Brazilian Real", "BRL");
    Country BSD = new Country("Bahamain Dollar", "BSD");
    Country CAD = new Country("Canadian Dollar", "CAD");
    Country CHF = new Country("Swiss Franc", "CHF");
    Country CLP = new Country("Chilean Peso", "CLP");
    Country CNY = new Country("Chinese Yuan", "CNY");
    Country COP = new Country("Colombian Peso", "COP");
    Country CZK = new Country("Czech Koruna", "CZK");
    Country DKK = new Country("Danish Krone", "DKK");
    Country DOP = new Country("Dominican Peso", "DOP");
    Country EGP = new Country("Egyptian Pound", "EGP");
    Country EUR = new Country("Euro", "EUR");
    Country FJD = new Country("Fijian Dollar", "FJD");
    Country GBP = new Country("British Pound Sterling", "GBP");
    Country GHS = new Country("Ghana Cedi", "GHS");
    Country GMD = new Country("Gambian Dalasi", "GMD");
    Country GTQ = new Country("Guatemalan Quetzal", "GTQ");
    Country HKD = new Country("Hong Kong Dollar", "HKD");
    Country HRK = new Country("Croatian Kuna", "HRK");
    Country HUF = new Country("Hungarian Forint", "HUF");
    Country IDR = new Country("Indonesian Rupiah", "IDR");
    Country ILS = new Country("Israeli Sheqel", "ILS");
    Country INR = new Country("Indian Rupee", "INR");
    Country ISK = new Country("Icelandic Krona", "ISK");
    Country JMD = new Country("Jamaican Dollar", "JMD");
    Country JOD = new Country("Jordanian Dinar", "JOD");
    Country JPY = new Country("Japanese Yen", "JPY");
    Country KES = new Country("Kenyan Shilling", "KES");
    Country KHR = new Country("Cambodian Riel", "KHR");
    Country KRW = new Country("South Korean Won", "KRW");
    Country KWD = new Country("Kuwaiti Dinar", "KWD");
    Country LAK = new Country("Lao Kip", "LAK");
    Country LBP = new Country("Lebanese Pound", "LBP");
    Country LKR = new Country("Sri Lankan Rupee", "LKR");
    //SECOND COLUMN
    Country LTL = new Country("Lithuanian Litas", "LTL");
    Country MAD = new Country("Moroccan Dirham", "MAD");
    Country MDL = new Country("Moldovan Leu", "MDL");
    Country MGA = new Country("Malagasy Ariary", "MGA");
    Country MKD = new Country("Macedonian Denar", "MKD");
    Country MUR = new Country("Mauritian Rupee", "MUR");
    Country MVR = new Country("Maldivian Rufiyaa", "MVR");
    Country MXN = new Country("Mexican Peso", "MXN");
    Country MYR = new Country("Malaysian Ringgit", "MYR");
    Country NAD = new Country("Namibian Dollar", "NAD");
    Country NGN = new Country("Nigerian Naira", "NGN");
    Country NOK = new Country("Norwegian Krone", "NOK");
    Country NPR = new Country("Nepalese Rupee", "NPR");
    Country NZD = new Country("New Zealand Dollar", "NZD");
    Country OMR = new Country("Omani Rial", "OMR");
    Country PAB = new Country("Panamanian Balboa", "PAB");
    Country PEN = new Country("Peruvian Sol", "PEN");
    Country PHP = new Country("Philippine Peso", "PHP");
    Country PKR = new Country("Pakistani Rupee", "PKR");
    Country PLN = new Country("Polish Zloty", "PLN");
    Country PYG = new Country("Paraguayan Guaraní", "PYG");
    Country QAR = new Country("Qatari Riyal", "QAR");
    Country RON = new Country("Romanian Leu", "RON");
    Country RSD = new Country("Serbian Dinar", "RSD");
    Country RUB = new Country("Russian Rouble", "RUB");
    Country SAR = new Country("Saudi Riyal", "SAR");
    Country SCR = new Country("Seychellois Rupee", "SCR");
    Country SEK = new Country("Swedish Krona", "SEK");
    Country SGD = new Country("Singapore Dollar", "SGD");
    Country SYP = new Country("Syrian Pound", "SYP");
    Country THB = new Country("Thai Baht", "THB");
    Country TND = new Country("Tunisian Dinar", "TND");
    Country TRY = new Country("Turkish Lira", "TRY");
    Country TWD = new Country("Taiwanese Dollar", "TWD");
    Country UAH = new Country("Ukraine Hryvnia", "UAH");
    Country UGX = new Country("Ugandan Shilling", "UGX");
    Country USD = new Country("United States Dollar", "USD");
    Country UYU = new Country("Uruguayan Peso", "UYU");
    Country VEF = new Country("Venezuelan Bolívar", "VEF");
    Country VND = new Country("Vietnamese Dong", "VND");
    Country XAF = new Country("Central African Franc", "XAF");
    Country XCD = new Country("East Caribbean Dollar", "XCD");
    Country XOF = new Country("West African Franc", "XOF");
    Country XPF = new Country("CFP Franc", "XPF");
    Country ZAR = new Country("South African Rand", "ZAR");
    
    /*Country[] CountryArray = {AED, ARS, AUD, AWG, BAM, BBD, BDT, BGN, BHD, BMD,
               BOB, BRL, BSD, CAD, CHF, CLP, CNY, COP, CZK, DKK, DOP, EGP, EUR,
               FJD, GBP, GHS, GMD, GTQ, HKD, HRK, HUF, IDR, ILS, INR, ISK, JMD,
               JOD, JPY, KES, KHR, KRW, KWD, LAK, LBP, LKR, LTL, MAD, MDL, MGA,
               MKD, MUR, MVR, MXN, MYR, NAD, NGN, NOK, NPR, NZD, OMR, PAB, PEN,
               PHP, PKR, PLN, PYG, QAR, RON, RSD, RUB, SAR, SCR, SEK, SGD, SYP,
               THB, TND, TRY, TWD, UAH, UGX, USD, UYU, VEF, VND, XAF, XCD, XOF,
               XPF, ZAR};
    */
    //JSONObject countryObj = new JSONObject();
    
    public void main(String[] args) {
        
         List <Country> countryList  = new ArrayList<Country> ();
         countryList.add(AED);
         countryList.add(ARS);
         countryList.add(AUD);
         countryList.add(AWG);
         countryList.add(BAM);
         countryList.add(BBD);
         countryList.add(BDT);
         countryList.add(BGN);
         countryList.add(BHD);
         countryList.add(BMD);
         countryList.add(BOB);
         countryList.add(BRL);
         countryList.add(BSD);
         countryList.add(CAD);
         countryList.add(CHF);
         countryList.add(CLP);
         countryList.add(CNY);
         countryList.add(COP);
         countryList.add(CZK);
         countryList.add(DKK);
         countryList.add(DOP);
         countryList.add(EGP);
         countryList.add(EUR);
         countryList.add(FJD);
         countryList.add(GBP);
         countryList.add(GHS);
         countryList.add(GMD);
         countryList.add(GTQ);
         countryList.add(HKD);
         countryList.add(HRK);
         countryList.add(HUF);
         countryList.add(IDR);
         countryList.add(ILS);
         countryList.add(INR);
         countryList.add(ISK);
         countryList.add(JMD);
         countryList.add(JPY);
         countryList.add(KES);
         countryList.add(KHR);
         countryList.add(KRW);
         countryList.add(KWD);
         countryList.add(LAK);
         countryList.add(LBP);
         countryList.add(LKR);
         countryList.add(LTL);
         countryList.add(MAD);
         countryList.add(MDL);
         countryList.add(MGA);
         countryList.add(MKD);
         countryList.add(MUR);
         countryList.add(MVR);
         countryList.add(MXN);
         countryList.add(MYR);
         countryList.add(NAD);
         countryList.add(NGN);
         countryList.add(NOK);
         countryList.add(NPR);
         countryList.add(NZD);
         countryList.add(OMR);
         countryList.add(PAB);
         countryList.add(PEN);
         countryList.add(PHP);
         countryList.add(PKR);
         countryList.add(PLN);
         countryList.add(PYG);
         countryList.add(QAR);
         countryList.add(RON);
         countryList.add(RSD);
         countryList.add(RUB);
         countryList.add(SAR);
         countryList.add(SCR);
         countryList.add(SEK);
         countryList.add(SGD);
         countryList.add(SYP);
         countryList.add(THB);
         countryList.add(TND);
         countryList.add(TRY);
         countryList.add(TWD);
         countryList.add(UAH);
         countryList.add(UGX);
         countryList.add(USD);
         countryList.add(UYU);
         countryList.add(VEF);
         countryList.add(VND);
         countryList.add(XAF);
         countryList.add(XCD);
         countryList.add(XOF);
         countryList.add(XPF);
         countryList.add(ZAR);

        JSONArray jsonArray = new JSONArray();
        
        for (int i = 0; i < countryList.size(); i++) {
            jsonArray.add(countryList.get(i));
        }
    /*  countryObj.put("Name", "India");
        countryObj.put("Population", new Integer(1000000));
    
        JSONArray listOfStates = new JSONArray();
        listOfStates.add("Madhya Pradesh");
        listOfStates.add("Maharastra");
        listOfStates.add("Rajasthan");
    */
        //JSONObject countryObj = new JSONObject();
        //countryObj.put("Country", jsonArray);
        
        try {
            //Writing to a file
            File file = new File("C:\\Users\\Drew\\Documents\\Programming\\Java"
                    + "\\NetBeans\\CurrencyConverter\\CountryJSONFile.json");
            
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            System.out.println("Writing JSON object to file");
            //System.out.print(countryObj);
            
            StringWriter out = new StringWriter();
            jsonArray.writeJSONString(out);
            //fileWriter.write(countryObj.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
