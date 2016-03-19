/****************************************************************
 *  Engine.java                                                 *
 *  Jeffery Johnson                                             *
 *  GEEN 165-002                                                *
 *  10/10/15                                                    *
 *                                                              *
 *  This class creates engine objects that are used in          *
 *  gasPoweredMower and LawnTractor classes                     *
 ***************************************************************/
package mowerstore;

public class Engine {
    
    private String manufacturer; // name of engine manufacturer
    private double horsePower;   // horse power of the engine
    private int cylinders;       // number of cylinders in the engine
    
    public Engine() {
    } // end no-arg constructor
    
    public Engine(String manufacturer,Double horsePower,int cylinders){
        this.manufacturer = manufacturer;
        this.horsePower = horsePower;
        this.cylinders = cylinders;
    } // end constructor with all parameters

    public String getManufacturer() {
        return manufacturer;
    } // end getManufacturer

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    } // end setManufacturer

    public double getHorsePower() {
        return horsePower;
    } // end getHorsePower

    public void setHorsePower(double horsePower) {
        this.horsePower = horsePower;
    } // end setHorsePower

    public int getCylinders() {
        return cylinders;
    } // end getCylinders

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    } // end setCylinders
    
    public String toString() {
        // return each property on seperate line
        String tempString = manufacturer +System.getProperty("line.separator") +horsePower +System.getProperty("line.separator")
                +cylinders;
        
        return tempString;
    } // end toString
    
} // end Engine Class
