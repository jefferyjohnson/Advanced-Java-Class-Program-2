/****************************************************************
 *  LawnTractor.java                                            *
 *  Jeffery Johnson                                             *
 *  GEEN 165-002                                                *
 *  10/11/15                                                    *
 *                                                              *
 *  This class inherits from Mower and that CommercialMower will*
 *  inherit from.  It also has engine objects created in it.    *
 *  Creates LawnTractor objects                                 *
 ***************************************************************/
package mowerstore;

public class LawnTractor extends Mower{
    
    private Engine engine;    // holds engine object for mower
    private String model;     // holds model of the mower
    private double deckWidth; // holds the width of the mower deck
    
    public LawnTractor () {
        super();
    } // end no arg constructor call to super class no arg constructor
    
    public LawnTractor (String manufacturer,int year,String serialNumber,Engine engine,String model,double deckWidth) {
        super(manufacturer,year,serialNumber);
        this.engine = engine;
        this.model = model;
        this.deckWidth = deckWidth;
    } // end constructor with all parameters, even paramenters for super class constructor

    public Engine getEngine() {
        return engine;
    } // end getEngine

    public void setEngine(Engine engine) {
        this.engine = engine;
    } // end setEngine

    public String getModel() {
        return model;
    } // end getModel

    public void setModel(String model) {
        this.model = model;
    } // end setModel

    public double getDeckWidth() {
        return deckWidth;
    } // end getDeckWidth

    public void setDeckWidth(double deckWidth) {
        this.deckWidth = deckWidth;
    } // end setDeckWidth
    
    @Override
    public String toString() {
        // return each property on seperate line
        String mowerType = "L";
        if (this instanceof CommercialMower) {
            mowerType = "C";
        } // end if
        String tempString = super.toString() +System.getProperty("line.separator") +mowerType +System.getProperty("line.separator") 
                +engine.toString() +System.getProperty("line.separator") +model +System.getProperty("line.separator") 
                +deckWidth  +System.getProperty("line.separator");
        return tempString;
    } // end toString
    
} // end class LawnTractor
