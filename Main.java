/****************************************************************
 *  Main.java                                                   *
 *  Jeffery Johnson                                             *
 *  GEEN 165-002                                                *
 *  10/10/15                                                    *
 *                                                              *
 *  This main class will implement take the file name passed to *
 *  it, and create the GUI object.                              *
 *                                                              *
 *  file name passed as command line argument.                  *
 ***************************************************************/
package mowerstore;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        
        JFileChooser fc = new JFileChooser();
        MowerWareHouse mowerWareHouse = new MowerWareHouse();
        
        // load file and create from if file name passed as argument
        if (args.length == 1) {
            mowerWareHouse.readMowerData(args[0]);
            createForm(mowerWareHouse);
        } // end if
        
        // load file and create form if no argument passed
        else if (args.length == 0) {        
            int loadFile = fc.showOpenDialog(null);
            if (loadFile == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                
                mowerWareHouse.readMowerData(file.getName());
                createForm(mowerWareHouse);
                
            } // end if
        } // end else
        
        // error message if more than one argument passed to program 
        else
        {
            JOptionPane.showMessageDialog(null, "More than one command line argumnet was passed.\nUse only one argument","ERROR",JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    } // end main method 
    
    private static void createForm(MowerWareHouse warehouse) {
        MainMenuForm mmf = new MainMenuForm(warehouse);
        mmf.setTitle(warehouse.getStoreName());
        mmf.setSize(800, 100);
        mmf.setLocationRelativeTo(null);
        mmf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mmf.setVisible(true);
    } // end createForm
} // end Main class
