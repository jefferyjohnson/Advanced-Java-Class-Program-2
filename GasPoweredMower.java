/****************************************************************
 *  GasPoweredMower.java                                        *
 *  Jeffery Johnson                                             *
 *  GEEN 165-002                                                *
 *  10/11/15                                                    *
 *                                                              *
 *  This class inherits from Mower class and has an Engine      *
 *  object included in it. Creates GasPoweredMower objects      *
 *                                                              *
 ***************************************************************/
package mowerstore;

public class GasPoweredMower extends WalkBehindMower{
    
    private Engine engine;         // holds engine object for new mower object
    private boolean selfPropelled; // lets user know if mower is self proplled or not
    
    public GasPoweredMower() {
        super();
    } // end no arg constructor that calls super class no arg constructor
    
    public GasPoweredMower (String manufacturer,int year,String serialNumber,double cutWidth,double wheelDiameter,Engine engine,boolean selfPropelled) {
        super(manufacturer,year,serialNumber,cutWidth,wheelDiameter);
        this.engine = engine;
        this.selfPropelled = selfPropelled;
    } // end constructor with all parameters for class and super classes

    public Engine getEngine() {
        return engine;
    } // end getEngine

    public void setEngine(Engine engine) {
        this.engine = engine;
    } // end setEngine

    public boolean isSelfPropelled() {
        return selfPropelled;
    } // end isSelfPropelled

    public void setSelfPropelled(boolean selfPropelled) {
        this.selfPropelled = selfPropelled;
    } // end setSelfPropelled
    
    @Override
    public String toString() {
        //return each propterty on separate line
        String tempString = super.toString() +System.getProperty("line.separator") 
                +engine.toString() +System.getProperty("line.separator") +selfPropelled 
                +System.getProperty("line.separator");
        return tempString;
    } // end toString
    
} // end class GasPoweredMower
