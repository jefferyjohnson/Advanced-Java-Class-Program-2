/****************************************************************
 *  WalkBehindMower.java                                        *
 *  Jeffery Johnson                                             *
 *  GEEN 165-002                                                *
 *  10/11/15                                                    *
 *                                                              *
 *  This class inherits from Mower and will have GasPoweredMower*
 *  and PushReelMower classes inherit from it                   *
 *                                                              *
 ***************************************************************/
package mowerstore;

public abstract class WalkBehindMower extends Mower{
    
    private double cutWidth;      // holds the cut width of the mower
    private double wheelDiameter; // holds the diameter of the mower wheels
    
    public WalkBehindMower () {
        super();
    } // end no arg constructor with call to super class no arg constructor
    
    public WalkBehindMower (String manufacturer,int year,String serialNumber,double cutWidth,double wheelDiameter) {
        super(manufacturer,year,serialNumber);
        this.cutWidth = cutWidth;
        this.wheelDiameter = wheelDiameter;
    } // end constructor with all parameters for this and super classes

    public double getCutWidth() {
        return cutWidth;
    } // end getCutWidth

    public void setCutWidth(double cutWidth) {
        this.cutWidth = cutWidth;
    } // end setCutWidth

    public double getWheelDiameter() {
        return wheelDiameter;
    } // end getWheelDiameter

    public void setWheelDiameter(double wheelDiameter) {
        this.wheelDiameter = wheelDiameter;
    } // end setWheelDiameter
    
    @Override
    public String toString() {
        // return each property on serpate line
        String mowerType = "G";
        if (this instanceof PushReelMower) {
            mowerType = "P";        
        }
        String tempString = super.toString() +System.getProperty("line.separator") +mowerType 
                +System.getProperty("line.separator") +cutWidth +System.getProperty("line.separator") +wheelDiameter;
        return tempString;
    } // end toString

} // end class WalkBehindMower
