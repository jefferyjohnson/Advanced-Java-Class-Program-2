/****************************************************************
 *  Mower.java                                                  *
 *  Jeffery Johnson                                             *
 *  GEEN 165-002                                                *
 *  10/10/15                                                    *
 *                                                              *
 *  This is an abstract class that LawnTractor and WalkBehind   *
 *  Mower inherit from.                                         *
 ***************************************************************/
package mowerstore;

public abstract class Mower {
    
    private String manufacturer;  // holds name of mover manufacuturer
    private int year;             // holds manufactured year of mower
    private String serialNumber;  // holds the serial number of the mower
    
    public Mower () {
    } // end no-arg constructor
    
    public Mower (String manufacturer,int year,String serialNumber) {
        this.manufacturer = manufacturer;
        this.year = year;
        this.serialNumber = serialNumber;
    } // end constructor with all parameters

    public String getManufacturer() {
        return manufacturer;
    } // end getManufacturer

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    } // end setManufacturer

    public int getYear() {
        return year;
    } // end getYear

    public void setYear(int year) {
        this.year = year;
    } // end setYear

    public String getSerialNumber() {
        return serialNumber;
    } // end getSerialNumber

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    } // end setSerialNumber
    
    public String toString() {
        // return each property on seperate line
        String tempString = manufacturer +System.getProperty("line.separator") +year +System.getProperty("line.separator") 
                +serialNumber;
        return tempString;
    } // end toString
    
    
} // end class Mower
