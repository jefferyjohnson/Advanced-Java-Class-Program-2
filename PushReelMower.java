/****************************************************************
 *  PushReelMower.java                                          *
 *  Jeffery Johnson                                             *
 *  GEEN 165-002                                                *
 *  10/11/15                                                    *
 *                                                              *
 *  This class inherits from WalkBehindMower class. It creates  *
 *  PushReelMower objects                                       *
 *                                                              *
 ***************************************************************/
package mowerstore;

public class PushReelMower extends WalkBehindMower{
    
    private int numWheels;  // holds number of wheels on the mower
    
    public PushReelMower() {
        super();
    } // end no arg constructor with call to no arg constructor in super class
    
    public PushReelMower(String manufacturer,int year,String serialNumber,double cutWidth,double wheelDiameter,int numWheels) {
        super(manufacturer,year,serialNumber,cutWidth,wheelDiameter);
        this.numWheels = numWheels;
    } // end constructor with all parameters for this class and super classes

    public int getNumWheels() {
        return numWheels;
    } // end getNumWheels

    public void setNumWheels(int numWheels) {
        this.numWheels = numWheels;
    } // end setNumWheels
    
    @Override
    public String toString() {
        // return each property on separate line
        String tempString = super.toString() +System.getProperty("line.separator") +numWheels +System.getProperty("line.separator");
        return tempString;
    } // end toString
    
    
    
} // end class PushReelMower
