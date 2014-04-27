/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package my.currencyconverter;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import flexjson.JSONSerializer;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Drew Dunnam
 */

public class CurrencyConverterUI extends javax.swing.JFrame {

    /**
     * Creates new form CurrencyConverterUI
     */
    
    //initialize global COUNTRY_LIST
    static List <Country> COUNTRY_LIST;
    
    @SuppressWarnings("empty-statement")
    public CurrencyConverterUI() {
        initComponents();
        
        //
        //THIS COMMENTED CODE SECTION WILL POPULATE BOTH JComboBoxes, BUT
        //THE DISPLAY IS THE OBJECT'S POINTER NAME
        //EXAMPLE: COUNTRY OBJECT 'AED' SHOWS UP IN THE JComboBox AS 
        //my.currencyconverter.Country@5cb42b
        //
        //ALSO (FOR SOME REASON) THESE COUNTRY OBJECTS AND THE LIST 'COUNTRY_LIST'
        //HAS TO BE INITIALIZED INSIDE OF MAIN IN ORDER TO PRINT THE FOLLOWING
        //IN THE OUPUT LINE WHEN THE PROGRAM IS RAN:
        //
        //[
        //    {
        //        "class": "my.currencyconverter.Country",
        //        "unit": "AED"
        //    },
        //    {
        //        "class": "my.currencyconverter.Country",
        //        "unit": "ARS"
        //    },
        //   ...
        //   ...
        //   ...
        //
        //
        /*
        //initialize country objects
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

        //Populate the countryList
        List <Country> COUNTRY_LIST  = Arrays.asList(AED,ARS,AUD,AWG,BAM,BGN,
                BHD,BMD,BOB,BRL,BSD,CAD,CHF,CLP,CNY,COP,CZK,DKK,DOP,EGP,EUR,
                FJD,GBP,GHS,GMD,GTQ,HKD,HRK,HUF,IDR,ILS,INR,ISK,JMD,JOD,JPY,
                KES,KHR,KRW,KWD,LAK,LBP,LKR,LTL,MAD,MDL,MGA,MKD,MUR,MVR,MXN,
                MYR,NAD,NGN,NOK,NPR,NZD,OMR,PAB,PEN,PHP,PKR,PLN,PYG,QAR,RON,
                RSD,RUB,SAR,SCR,SEK,SGD,SYP,THB,TND,TRY,TWD,UAH,UGX,USD,UYU,
                VEF,VND,XAF,XCD,XOF,XPF,ZAR);
        
        */
        List <String> unitList = Arrays.asList("Select","AED","ARS","AUD","AWG",
                    "BAM","BGN","BHD","BMD","BOB","BRL","BSD","CAD","CHF","CLP",
                    "CNY","COP","CZK","DKK","DOP","EGP","EUR","FJD","GBP","GHS",
                    "GMD","GTQ","HKD","HRK","HUF","IDR","ILS","INR","ISK","JMD",
                    "JOD","JPY","KES","KHR","KRW","KWD","LAK","LBP","LKR","LTL",
                    "MAD","MDL","MGA","MKD","MUR","MVR","MXN","MYR","NAD","NGN",
                    "NOK","NPR","NZD","OMR","PAB","PEN","PHP","PKR","PLN","PYG",
                    "QAR","RON","RSD","RUB","SAR","SCR","SEK","SGD","SYP","THB",
                    "TND","TRY","TWD","UAH","UGX","USD","UYU","VEF","VND","XAF",
                    "XCD","XOF","XPF","ZAR");
        
        //populate currentComboBox
        DefaultComboBoxModel currentModel = new DefaultComboBoxModel(unitList.toArray());
        DefaultComboBoxModel desiredModel = new DefaultComboBoxModel(unitList.toArray());
        currentComboBox.setModel(currentModel);
        desiredComboBox.setModel(desiredModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aboutDialog = new javax.swing.JDialog();
        currentLabel = new javax.swing.JLabel();
        desiredLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        currentValueText = new javax.swing.JTextField();
        currrencyLabel = new javax.swing.JLabel();
        crLabel = new javax.swing.JLabel();
        convertButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        rateText = new javax.swing.JTextField();
        currentComboBox = new javax.swing.JComboBox();
        desiredComboBox = new javax.swing.JComboBox();
        desiredText = new javax.swing.JTextField();
        Aboutdontuse = new javax.swing.JMenuBar();
        About = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();
        updateMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();

        aboutDialog.setAlwaysOnTop(true);
        aboutDialog.setName("About"); // NOI18N

        javax.swing.GroupLayout aboutDialogLayout = new javax.swing.GroupLayout(aboutDialog.getContentPane());
        aboutDialog.getContentPane().setLayout(aboutDialogLayout);
        aboutDialogLayout.setHorizontalGroup(
            aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        aboutDialogLayout.setVerticalGroup(
            aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        currentLabel.setText("Current ");

        desiredLabel.setText("Desired");

        valueLabel.setText("Value");

        currentValueText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentValueTextActionPerformed(evt);
            }
        });

        currrencyLabel.setText("Currency");

        crLabel.setText("Conversion Rate:");

        convertButton.setText("Convert");
        convertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        rateText.setEditable(false);
        rateText.setAutoscrolls(false);

        currentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        desiredComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        desiredText.setEditable(false);

        About.setText("Menu");

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        About.add(aboutMenuItem);

        updateMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        updateMenuItem.setText("Update");
        updateMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateMenuItemActionPerformed(evt);
            }
        });
        About.add(updateMenuItem);
        About.add(jSeparator1);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        About.add(exitMenuItem);

        Aboutdontuse.add(About);

        setJMenuBar(Aboutdontuse);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(desiredLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(desiredText, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(desiredComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(currentLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(currentValueText, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(68, 68, 68)
                                                .addComponent(valueLabel)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(currrencyLabel)
                                                .addGap(4, 4, 4))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(currentComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addGap(121, 121, 121))
                            .addComponent(crLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rateText, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(convertButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valueLabel)
                    .addComponent(currrencyLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(currentValueText, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(currentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(currentLabel))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(desiredLabel)
                            .addComponent(desiredComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(desiredText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(crLabel)
                            .addComponent(rateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(convertButton)
                    .addComponent(closeButton)
                    .addComponent(clearButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void convertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_convertButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeButtonActionPerformed

    private void currentValueTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentValueTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currentValueTextActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        
        //reset all editable fields to the default
        currentValueText.setText("");
        rateText.setText("");
        currentComboBox.setSelectedIndex(0);
        desiredComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_clearButtonActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(null, "Currency Converter Application\n\n"
                + "\t\t\tVerson 0.5\n\n\t© Copyright 2014 Drew Dunnam");
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void updateMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateMenuItemActionPerformed
        JOptionPane.showMessageDialog(null, "                Warning:\n"
                + "         Nothing to update.");
    }//GEN-LAST:event_updateMenuItemActionPerformed

    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        
        JSONSerializer serializer = new JSONSerializer().prettyPrint(true); 
        
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

        //Populate the countryList
        List <Country> COUNTRY_LIST  = Arrays.asList(AED,ARS,AUD,AWG,BAM,BBD,
                   BDT,BGN,BHD,BMD,BOB,BRL,BSD,CAD,CHF,CLP,CNY,COP,CZK,DKK,DOP,
                   EGP,EUR,FJD,GBP,GHS,GMD,GTQ,HKD,HRK,HUF,IDR,ILS,INR,ISK,JMD,
                   JOD,JPY,KES,KHR,KRW,KWD,LAK,LBP,LKR,LTL,MAD,MDL,MGA,MKD,MUR,
                   MVR,MXN,MYR,NAD,NGN,NOK,NPR,NZD,OMR,PAB,PEN,PHP,PKR,PLN,PYG,
                   QAR,RON,RSD,RUB,SAR,SCR,SEK,SGD,SYP,THB,TND,TRY,TWD,UAH,UGX,
                   USD,UYU,VEF,VND,XAF,XCD,XOF,XPF,ZAR);
        
        String jsonString = serializer.deepSerialize(COUNTRY_LIST);
        System.out.println(jsonString);
    
         
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CurrencyConverterUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu About;
    private javax.swing.JMenuBar Aboutdontuse;
    private javax.swing.JDialog aboutDialog;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton convertButton;
    private javax.swing.JLabel crLabel;
    private javax.swing.JComboBox currentComboBox;
    private javax.swing.JLabel currentLabel;
    private javax.swing.JTextField currentValueText;
    private javax.swing.JLabel currrencyLabel;
    private javax.swing.JComboBox desiredComboBox;
    private javax.swing.JLabel desiredLabel;
    private javax.swing.JTextField desiredText;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextField rateText;
    private javax.swing.JMenuItem updateMenuItem;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
