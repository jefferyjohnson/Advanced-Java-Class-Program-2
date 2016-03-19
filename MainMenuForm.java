/****************************************************************
 *  MainMenuForm.java                                           *
 *  Jeffery Johnson                                             *
 *  GEEN 165-002                                                *
 *  10/11/15                                                    *
 *                                                              *
 *  This class creates the main menu for the GUI                *
 *                                                              *
 *                                                              *
 ***************************************************************/
package mowerstore;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainMenuForm extends JFrame{
    
    private MowerWareHouse warehouse; // warehouse object variable
    private Container contents;       // container for the GUI
    private String[] buttonNames = new String[]{"View Mowers","Add Mower","Load Warehouse","Save Warehouse","Exit"}; // array to hold list of button names
    private JButton button; // used in for loop to create buttons for form
    private ButtonHandler bh = new ButtonHandler(); // create handler for buttons
    private HashMap<JButton, Integer> map = new HashMap<>();  // hashmap for action listener
    public boolean mowerAdded = false; // keep track if user added a mower add mower class will need to change it.
    
    public MainMenuForm(MowerWareHouse warehouse) {
        
        this.warehouse = warehouse;
        contents = getContentPane();
        contents.setLayout(new GridLayout(1,5));
        
        // create and assign listener to the buttons
        for (int index = 0;index < buttonNames.length;index++) {
            button = new JButton(buttonNames[index]);
            button.addActionListener(bh);
            map.put(button, index);
            contents.add(button);
        } // end for loop
        
    } // end Constructor
    
    private class ButtonHandler implements ActionListener {
    
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser();
            File file = null;
            Integer index = map.get(e.getSource());

            // action for when view mowers button is pushed.
            switch (index) {
                
                // create mower view form
                case 0:
                    MowerViewForm mvf = new MowerViewForm(warehouse);
                    mvf.setTitle("Mower View Screen");
                    mvf.setSize(400,400);
                    mvf.setLocationRelativeTo(null);
                    mvf.setDefaultCloseOperation(MowerViewForm.DISPOSE_ON_CLOSE);
                    mvf.setVisible(true);
                    break;
                // create add mower form
                case 1:
                    AddMowerForm amf = new AddMowerForm(warehouse);
                    amf.setTitle("Add Mower Screen");
                    amf.setSize(800, 400);
                    amf.setLocationRelativeTo(null);
                    amf.setDefaultCloseOperation(MowerViewForm.DISPOSE_ON_CLOSE);
                    amf.setVisible(true);
                    mowerAdded = true;
                    break;
                //load new file
                case 2:
                    warehouse = new MowerWareHouse();
                    int loadFile = fc.showOpenDialog(null);
                    if (loadFile == JFileChooser.APPROVE_OPTION) 
                    file = fc.getSelectedFile();
                    warehouse.readMowerData(file.getName());
                    break;
                // save current file
                case 3:
                    int saveFile = fc.showOpenDialog(null);
                    if (saveFile == JFileChooser.APPROVE_OPTION) 
                    file = fc.getSelectedFile();
                    warehouse.saveMowerData(file.getName());
                    mowerAdded = false;
                    break;
                // exit program
                case 4:
                    // action for when exit button is pushed.
                    // check if file has been updated before exiting
                    if (mowerAdded == false)
                        System.exit(0);
                    else {
                        int reply = JOptionPane.showConfirmDialog(null, "Would you like to save file first", "File Changed and not Saved", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            saveFile = fc.showOpenDialog(null);
                            if (saveFile == JFileChooser.APPROVE_OPTION) 
                            file = fc.getSelectedFile();
                            warehouse.saveMowerData(file.getName());
                            System.exit(0);
                        } // end if statement
                        else
                            System.exit(0);
                    } // end else statement
                    break;
            } // end switch structure
        } // end actionPerformed
        
    } // end class Button Handler
} // end class MainMenuForm

