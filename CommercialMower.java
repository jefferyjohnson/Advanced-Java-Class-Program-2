/****************************************************************
 *  CommercialMower.java                                        *
 *  Jeffery Johnson                                             *
 *  GEEN 165-002                                                *
 *  10/11/15                                                    *
 *                                                              *
 *  This class inherits from LawnTractor directly and Mower     *
 *  indirectly. Creates commercialMower objects.                *
 ***************************************************************/
package mowerstore;

public class CommercialMower extends LawnTractor{
    
    private double operatingHours;  // holds value for number of hours the mower has been in operation
    private boolean zeroTurnRadius; // lets user know if mower has a zero turn radius or not.
    
    public CommercialMower() {
        super();
    } // end no arg constructor that calls no arg constructor in super class
    
    public CommercialMower(String manufacturer,int year,String serialNumber,Engine engine,String model,double deckWidth,double operatingHours,boolean zeroTurnRadius){
        super(manufacturer,year,serialNumber,engine,model,deckWidth);
        this.operatingHours = operatingHours;
        this.zeroTurnRadius = zeroTurnRadius;
    } // end construtor with all parameters for direct and indirect super classes

    public double getOperatingHours() {
        return operatingHours;
    } // end getOperatingHours

    public void setOperatingHours(double operatingHours) {
        this.operatingHours = operatingHours;
    } // end setOperatingHours

    public boolean isZeroTurnRadius() {
        return zeroTurnRadius;
    } // end isZeroTurnRadius

    public void setZeroTurnRadius(boolean zeroTurnRadius) {
        this.zeroTurnRadius = zeroTurnRadius;
    } // end setZeroTurnRadius
    
    @Override
    public String toString() {
        // return each property on seperate line
        String tempString = super.toString() +operatingHours +System.getProperty("line.separator") 
                +zeroTurnRadius +System.getProperty("line.separator");
        return tempString;
    } // end toString
    
} // end class CommercialMower
