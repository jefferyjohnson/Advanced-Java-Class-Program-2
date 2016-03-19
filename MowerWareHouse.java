/****************************************************************
 *  MowerWareHouse.java                                         *
 *  Jeffery Johnson                                             *
 *  GEEN 165-002                                                *
 *  10/11/15                                                    *
 *                                                              *
 *  This class has the warehouse name, and the list of mower    *
 *  objects.  creates MowerWareHouse objects.                   *
 *                                                              *
 ***************************************************************/
package mowerstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class MowerWareHouse {
    
    private String storeName;        // holds the name of the mowerStore
    private ArrayList<Mower> mowers; // holds the list of mower objects that are created
    
    // only need no arg constructore since store name and arrayList will be popluated by the other Methods
    public MowerWareHouse() {
        mowers = new ArrayList();
    } // end no arg constructor

    public String getStoreName() {
        return storeName;
    } // end getStoreName

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    } // end setStoreName

    public Mower getMowers(int index) {
        return mowers.get(index);
    } // end getMowers

    public void setMowers(int index,Mower mower) {
        mowers.add(index, mower);
    } // end setMowers
    
    public int getNumMowers() {
        return mowers.size();
    } // end getNumMowers
    
    public void addMower(Mower mower) {
        mowers.add(mower);
    } // end addMower
    
    public void removeMower(int index) {
        mowers.remove(index);
    } // end removeMower
    
    public void readMowerData(String inputFileName) {
        try {
            Scanner file = new Scanner(new File(inputFileName));
            // temp variables to hold corresponding values
            Engine tempEngine = null;
            String tempManufacturer = "";
            int tempYear = 0;
            String tempSerialNumber = "";
            
            // get name of mower store
            if (file.hasNext()) {
                storeName = file.nextLine();
            } // end if
            
            // populate the mowers list with mower items
            while (file.hasNext()) {
                
                // set mower data into temp variables
                tempEngine = null;
                tempManufacturer = file.nextLine();
                tempYear = file.nextInt();
                tempSerialNumber = file.next();
                
                // use case structure to create appropriate mower object
                switch (file.next()) {
                    case "L": // create LawnTractor object
                        file.nextLine();

                        tempEngine = new Engine(file.nextLine(),file.nextDouble(),file.nextInt());
                        mowers.add(new LawnTractor(tempManufacturer,tempYear,tempSerialNumber,tempEngine,file.next(),file.nextDouble()));
                        break;
                    case "C": // create CommercialMower object
                        file.nextLine();
                        tempEngine = new Engine(file.nextLine(),file.nextDouble(),file.nextInt());
                        
                        String tempModelName = file.next();
                        double tempDeckWidth = file.nextDouble();
                        double tempOperatingHours = file.nextDouble();
                        boolean tempTurnRadius = false;
                        // read proper boolean status
                        if (file.nextLine().equals("true")) {
                            tempTurnRadius = true; 
                        } // end if
                        else {
                            tempTurnRadius = false;
                        } // end else
                        mowers.add(new CommercialMower(tempManufacturer,tempYear,tempSerialNumber,tempEngine,tempModelName,tempDeckWidth,tempOperatingHours,tempTurnRadius));
                        break;
                    case "G": // creates GasPoweredMower object
                        Double tempCutWidth = file.nextDouble();
                        Double tempWheelDiameter = file.nextDouble();
                        file.nextLine();
                        tempEngine = new Engine(file.nextLine(),file.nextDouble(),file.nextInt());
                        boolean tempSelfPropelled = false;
                        if (file.nextLine().equals("true")) {
                            tempSelfPropelled = true; 
                        } // end if
                        else {
                            tempSelfPropelled = false;
                        } // end else
                        mowers.add(new GasPoweredMower(tempManufacturer,tempYear,tempSerialNumber,tempCutWidth,tempWheelDiameter,tempEngine,tempSelfPropelled));
                        break;
                    case "P": // creates PushReelMower obect
                        file.nextLine();
                        mowers.add(new PushReelMower(tempManufacturer,tempYear,tempSerialNumber,file.nextDouble(),file.nextDouble(),file.nextInt()));
                        break;                        
                } // end switch
                // check if line exists more needed.
                if (file.hasNext()){
                    file.nextLine();
                } // end if
            } // end while loop
            
            file.close();
        } // end try
        
        catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "Invalid file name.", "INVALID FILE NAME", JOptionPane.ERROR_MESSAGE);
        } // end catch

    } // end readMowerData
    
    public void saveMowerData(String outputFileName) {
        try {
            FileOutputStream fos = new FileOutputStream(outputFileName,false);
            PrintWriter pw = new PrintWriter(fos);
            
            pw.print(this.toString());
            pw.close();
        } // end try
        
        catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "Invalid file name.", "INVALID FILE NAME", JOptionPane.ERROR_MESSAGE);
        } // end catch
        
    } // end saveMowerData
    
    public String toString() {
        String tempString = storeName + System.getProperty("line.separator");
        for (Mower mower : mowers) {
            tempString += mower.toString();
        } // end forEach loop
        return tempString;
    } // end toString
} // end class MowerWareHouse
