/****************************************************************
 *  MowerViewForm.java                                          *
 *  Jeffery Johnson                                             *
 *  GEEN 165-002                                                *
 *  10/11/15                                                    *
 *                                                              *
 *  This class creates the mower view for the GUI               *
 *                                                              *
 *                                                              *
 ***************************************************************/
package mowerstore;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MowerViewForm extends JFrame{
    
    private MowerWareHouse warehouse; // warehouse object variable
    private Container contents;       // container for the GUI
    private String[] mowerTypes = new String[]{"Lawn Tractor","Commercial Mower","Gas Powered Mower","Push Reel Mower"}; // array for combobox list items
    private HashMap<JComboBox, Integer> map = new HashMap<>();  // hashmap for action listener
    private ComboBoxHandler cmbListHandler = new ComboBoxHandler();
    private JComboBox cmbMowerList = new JComboBox();     // create and instantiate JComboBox object
    private JTextArea displayMowers = new JTextArea();  // creste and instantiate JTextArea object
    
    public MowerViewForm(MowerWareHouse warehouse) {
        this.warehouse = warehouse;
        displayMowers.setEditable(false);
        
        contents = getContentPane();        
        contents.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(displayMowers);
        contents.add(scrollPane,BorderLayout.CENTER);
        
        cmbMowerList.addActionListener(cmbListHandler);
        // add items and action listener to combo box
        for (int index = 0;index < mowerTypes.length;index++) {
            cmbMowerList.addItem(mowerTypes[index]);
            map.put(cmbMowerList, index);
        } // end for loop
 
        contents.add(cmbMowerList,BorderLayout.SOUTH);
    } // end constructor

        private class ComboBoxHandler implements ActionListener {
           
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = cmbMowerList.getSelectedIndex();
                switch (index) {
                    // display non commercial lawntractors
                    case 0:
                        displayMowers.setText("");
                        for (int loopIndex = 0;loopIndex < warehouse.getNumMowers();loopIndex++) {
                            if (warehouse.getMowers(loopIndex) instanceof LawnTractor && !(warehouse.getMowers(loopIndex) instanceof CommercialMower)) {
                               displayMowers.append(warehouse.getMowers(loopIndex).toString());
                               displayMowers.append(System.getProperty("line.separator"));
                            } // end if
                        } // end for loop
                        break;
                    // display commercial lawn tractors
                    case 1:
                        displayMowers.setText("");
                        for (int loopIndex = 0;loopIndex < warehouse.getNumMowers();loopIndex++) {
                            if (warehouse.getMowers(loopIndex) instanceof CommercialMower) {
                               displayMowers.append(warehouse.getMowers(loopIndex).toString());
                               displayMowers.append(System.getProperty("line.separator"));
                            } // end if
                        } // end for loop
                        break;
                    // display gas powered walk behind mowers
                    case 2:
                        displayMowers.setText("");
                        for (int loopIndex = 0;loopIndex < warehouse.getNumMowers();loopIndex++) {
                            if (warehouse.getMowers(loopIndex) instanceof GasPoweredMower) {
                               displayMowers.append(warehouse.getMowers(loopIndex).toString());
                               displayMowers.append(System.getProperty("line.separator"));
                            } // end if
                        } // end for loop
                        break;
                    // display push reel walk behind mowers
                    case 3:
                        displayMowers.setText("");
                        for (int loopIndex = 0;loopIndex < warehouse.getNumMowers();loopIndex++) {
                            if (warehouse.getMowers(loopIndex) instanceof PushReelMower) {
                               displayMowers.append(warehouse.getMowers(loopIndex).toString());
                               displayMowers.append(System.getProperty("line.separator"));
                            } // end if
                        } // end for loop
                        break;
                } // end switch
            } // end ActionPerformed
        } // end private class ComboBoxHandler
    
} // end class MowerViewForm
