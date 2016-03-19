/****************************************************************
 *  addMowerForm.java                                           *
 *  Jeffery Johnson                                             *
 *  GEEN 165-002                                                *
 *  10/11/15                                                    *
 *                                                              *
 *  This class creates the add mower form for the GUI           *
 *                                                              *
 *                                                              *
 ***************************************************************/
package mowerstore;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.InputMismatchException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddMowerForm extends JFrame{
    
    private MowerWareHouse warehouse; // variable for warehouse object
    private String[] mowerTypes = new String[]{"Lawn Tractor","Commercial Mower","Gas Powered Mower","Push Reel Mower"}; // array for combobox list items
    private JComboBox cmbMowerList = new JComboBox();     // create and instantiate JComboBox object
    private Container contents; // container object for GUI
    private HashMap<JComboBox, Integer> map = new HashMap<>();  // hashmap for action listener
    private ComboBoxHandler cmbListHandler = new ComboBoxHandler(); // action handler for combo box
    private ButtonHandler bh = new ButtonHandler(); // action handler for buttons
    private JPanel pnlAddMower = new JPanel(new CardLayout());
    private JPanel pnlLawnTractor = new JPanel();
    private JPanel pnlCommercialMower = new JPanel();
    private JPanel pnlGasPoweredMower = new JPanel();
    private JPanel pnlPushReelMower = new JPanel();
    private JLabel displayMowerAdded = new JLabel();
    
    // variables to hold all the information from the forms
    JLabel lblEngineManufacturer = new JLabel("Engine Manufacturer",SwingConstants.RIGHT);
    JTextField txtEngineManufacturer = new JTextField();
    JLabel lblHorsepower = new JLabel("Horsepower",SwingConstants.RIGHT);
    JTextField txtHorsePower = new JTextField();
    JLabel lblCylinders = new JLabel("Cylinders",SwingConstants.RIGHT);
    JTextField txtCylinder = new JTextField();
    JLabel lblModelNumber = new JLabel("Model Number",SwingConstants.RIGHT);
    JTextField txtModelNumber = new JTextField();
    JLabel lblDeckWidth = new JLabel("Deck Width",SwingConstants.RIGHT);
    JTextField txtDeckWidth = new JTextField();
    JLabel lblOperatingHours = new JLabel("Operating Hours",SwingConstants.RIGHT);
    JTextField txtOperatingHours = new JTextField();
    JComboBox cmbZeroTurnRadius = new JComboBox();
    JLabel lblCutWidth = new JLabel("Cut Width",SwingConstants.RIGHT);
    JTextField txtCutWidth = new JTextField();
    JLabel lblWheelDiameter = new JLabel("Wheel Diameter",SwingConstants.RIGHT);
    JTextField txtWheelDiameter = new JTextField();
    JComboBox cmbSelfPropelled = new JComboBox();
    JLabel lblNumberOfWheels = new JLabel("Number of Wheels",SwingConstants.RIGHT);
    JTextField txtNumOfWheels = new JTextField();
    JLabel lblZeroTurnRadius = new JLabel("Zero Turn Radius",SwingConstants.RIGHT);
    JLabel lblSelfPropelled = new JLabel("Self Propelled",SwingConstants.RIGHT);
    JLabel lblMowerManufacturer = new JLabel("Mower Manufacturer",SwingConstants.RIGHT);
    JTextField txtMowerManufacturer = new JTextField();
    JLabel lblYear = new JLabel("Year",SwingConstants.RIGHT);
    JTextField txtYear = new JTextField();
    JLabel lblSerialNumber = new JLabel("Serial Number",SwingConstants.RIGHT);
    JTextField txtSerialNumber = new JTextField();
    
    public AddMowerForm (MowerWareHouse warehouse) {
        this.warehouse = warehouse;
        contents = getContentPane();
        contents.setLayout(new BorderLayout());
        
        // add items to list in combo box
        cmbMowerList.addActionListener(cmbListHandler);
        // add items and action listener to combo box
        for (int index = 0;index < mowerTypes.length;index++) {
            cmbMowerList.addItem(mowerTypes[index]);
            map.put(cmbMowerList, index);
        } // end for loop
        
        // add combo box to frame
        contents.add(cmbMowerList,BorderLayout.NORTH);
              
        // create add mower and close buttons and add to frame
        // create and add display to same panel
        JPanel pnlButton = new JPanel();
        JButton btnAddMower = new JButton("Add Mower");
        JButton btnExit = new JButton("Exit");
        btnAddMower.addActionListener(bh);
        btnExit.addActionListener(bh);
        pnlButton.add(btnAddMower);
        pnlButton.add(btnExit);
        pnlButton.add(displayMowerAdded);
        
        contents.add(pnlButton,BorderLayout.SOUTH);
        
        // add panel for displaying information entered
        pnlAddMower.add(pnlLawnTractor,"Lawn Tractor");
        pnlAddMower.add(pnlCommercialMower,"Commercial Mower");
        pnlAddMower.add(pnlGasPoweredMower,"Gas Powered Mower");
        pnlAddMower.add(pnlPushReelMower,"Push Reel Mower");
        
        contents.add(pnlAddMower,BorderLayout.CENTER);
    } // end constructor
    
    // handler for combobox
    private class ComboBoxHandler implements ActionListener {
        
        @Override
            public void actionPerformed(ActionEvent e) {
                int index = cmbMowerList.getSelectedIndex();
                switch (index) {
                    // display non commercial lawntractors panel
                    case 0:
                        pnlLawnTractor.add(createMowerPanel());
                        pnlLawnTractor.add(createEnginePanel());
                        pnlLawnTractor.add(createLawnTractorPanel());
                        break;
                    // display commercial lawn tractors panel
                    case 1:
                        pnlCommercialMower.add(createMowerPanel());
                        pnlCommercialMower.add(createEnginePanel());
                        pnlCommercialMower.add(createLawnTractorPanel());
                        pnlCommercialMower.add(createCommercialMowerPanel());
                        break;
                    // display gas powered walk behind mowers panel
                    case 2:
                        pnlGasPoweredMower.add(createMowerPanel());
                        pnlGasPoweredMower.add(createEnginePanel());
                        pnlGasPoweredMower.add(createWalkBehindMowerPanel());
                        pnlGasPoweredMower.add(createGasPoweredMowerPanel());
                        break;
                    // display push reel walk behind mowers panel
                    case 3:
                        pnlPushReelMower.add(createMowerPanel());
                        pnlPushReelMower.add(createWalkBehindMowerPanel());
                        pnlPushReelMower.add(createPushReelMowerPanel());
                        break;
                } // end switch
                CardLayout cl = (CardLayout) pnlAddMower.getLayout();
                cl.show(pnlAddMower, cmbMowerList.getSelectedItem().toString());
            } // end ActionPerformed
    } // end class ComboBoxHandler
    
    // handler for buttons
    private class ButtonHandler implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btnAddMowerForm = new JButton();
            btnAddMowerForm = (JButton)e.getSource();
            
            if (btnAddMowerForm.getText().equals("Exit")) {
                dispose();
            } // end if
            else {
                // temporary variables to hold boolean selections
                boolean tempZeroTurnRadius = false;
                boolean tempSelfPropelled = false;
                Engine tempEngine; // temporary engine object
                
                // get selected index to use in a switch case structure
                // to create the appropriate mower object in the warehouse
                int index = cmbMowerList.getSelectedIndex();
                switch (index) {
                    case 0:
                        try {
                            tempEngine = new Engine(txtEngineManufacturer.getText(),Double.parseDouble(txtHorsePower.getText()),Integer.parseInt(txtCylinder.getText()));
                            warehouse.addMower(new LawnTractor(txtMowerManufacturer.getText(),Integer.parseInt(txtYear.getText()),txtSerialNumber.getText(),tempEngine,txtModelNumber.getText(),Double.parseDouble(txtDeckWidth.getText())));
                            displayMowerAdded.setText("Mower Added");
                            emptyTextFields();
                        } // end try // end try
                        catch (InputMismatchException | NumberFormatException imme){
                            JOptionPane.showMessageDialog(null, "Field incorrectly entered","ERROR",JOptionPane.ERROR_MESSAGE);
                        } // end catch
                        break;
                    case 1:
                        try {
                            if (cmbZeroTurnRadius.getSelectedIndex() == 0)
                                tempZeroTurnRadius = true;
                            tempEngine = new Engine(txtEngineManufacturer.getText(),Double.parseDouble(txtHorsePower.getText()),Integer.parseInt(txtCylinder.getText()));
                            warehouse.addMower(new CommercialMower(txtMowerManufacturer.getText(),Integer.parseInt(txtYear.getText()),txtSerialNumber.getText(),tempEngine,txtModelNumber.getText(),Double.parseDouble(txtDeckWidth.getText()),Double.parseDouble(txtOperatingHours.getText()),tempZeroTurnRadius));
                            displayMowerAdded.setText("Mower Added");
                            emptyTextFields();                            
                        } // end try
                        catch (InputMismatchException | NumberFormatException imme){
                            JOptionPane.showMessageDialog(null, "Field incorrectly entered","ERROR",JOptionPane.ERROR_MESSAGE);
                        } // end catch
                        break;
                    case 2:
                        try {
                            if (cmbSelfPropelled.getSelectedIndex() == 0)
                                tempSelfPropelled = true;
                            tempEngine = new Engine(txtEngineManufacturer.getText(),Double.parseDouble(txtHorsePower.getText()),Integer.parseInt(txtCylinder.getText()));
                            warehouse.addMower(new GasPoweredMower(txtMowerManufacturer.getText(),Integer.parseInt(txtYear.getText()),txtSerialNumber.getText(),Double.parseDouble(txtCutWidth.getText()),Double.parseDouble(txtWheelDiameter.getText()),tempEngine,tempSelfPropelled));
                            displayMowerAdded.setText("Mower Added");
                            emptyTextFields();                            
                        } // end try
                        catch (InputMismatchException | NumberFormatException imme){
                            JOptionPane.showMessageDialog(null, "Field incorrectly entered","ERROR",JOptionPane.ERROR_MESSAGE);
                        } // end catch
                        break;
                    case 3:
                        try {
                            warehouse.addMower(new PushReelMower(txtMowerManufacturer.getText(),Integer.parseInt(txtYear.getText()),txtSerialNumber.getText(),Double.parseDouble(txtCutWidth.getText()),Double.parseDouble(txtWheelDiameter.getText()),Integer.parseInt(txtNumOfWheels.getText())));
                            displayMowerAdded.setText("Mower Added");
                            emptyTextFields();                            
                        } // end try
                        catch (InputMismatchException | NumberFormatException imme){
                            JOptionPane.showMessageDialog(null, "Field incorrectly entered","ERROR",JOptionPane.ERROR_MESSAGE);
                        } // end catch
                        break;
                } // end switch
            } // end else
        }  // end actionPerformed
    } // end Private class ButtonHandler
    
    // methods to add appropriate panels to form
    private JPanel createEnginePanel() {
        JPanel pnlEngine = new JPanel(new GridLayout(1,6));
        pnlEngine.add(lblEngineManufacturer);
        pnlEngine.add(txtEngineManufacturer);
        pnlEngine.add(lblHorsepower);
        pnlEngine.add(txtHorsePower);
        pnlEngine.add(lblCylinders);
        pnlEngine.add(txtCylinder);
        return pnlEngine;
    } // end createEnginePanel
    
    private JPanel createMowerPanel() {
        JPanel pnlMowerPanel = new JPanel(new GridLayout(1,6));
        pnlMowerPanel.add(lblMowerManufacturer);
        pnlMowerPanel.add(txtMowerManufacturer);
        pnlMowerPanel.add(lblYear);
        pnlMowerPanel.add(txtYear);
        pnlMowerPanel.add(lblSerialNumber);
        pnlMowerPanel.add(txtSerialNumber);
        return pnlMowerPanel;
    } // end createMowerPanel
    
    private JPanel createLawnTractorPanel() {
        JPanel pnlLawnTractor = new JPanel(new GridLayout(1,4));
        pnlLawnTractor.add(lblModelNumber);
        pnlLawnTractor.add(txtModelNumber);
        pnlLawnTractor.add(lblDeckWidth);
        pnlLawnTractor.add(txtDeckWidth);
        return pnlLawnTractor;
    
    } // end createLawnTractorPane
    
    private JPanel createCommercialMowerPanel() {
        JPanel pnlCommercialMower = new JPanel(new GridLayout(1,4));
        cmbZeroTurnRadius.addItem("True");
        cmbZeroTurnRadius.addItem("False");
        pnlCommercialMower.add(lblOperatingHours);
        pnlCommercialMower.add(txtOperatingHours);
        pnlCommercialMower.add(lblZeroTurnRadius);
        pnlCommercialMower.add(cmbZeroTurnRadius);
        return pnlCommercialMower;
    } // end createCommercialMowerPanel
    
    private JPanel createWalkBehindMowerPanel() {
        JPanel pnlWalkBehindMower = new JPanel(new GridLayout(1,4));
        pnlWalkBehindMower.add(lblCutWidth);
        pnlWalkBehindMower.add(txtCutWidth);
        pnlWalkBehindMower.add(lblWheelDiameter);
        pnlWalkBehindMower.add(txtWheelDiameter);
        return pnlWalkBehindMower;
    } // end createWalkBehindMowerPanel
    
    private JPanel createGasPoweredMowerPanel() {
        JPanel pnlGasPoweredMower = new JPanel(new GridLayout(1,2));
        cmbSelfPropelled.addItem("True");
        cmbSelfPropelled.addItem("False");
        pnlGasPoweredMower.add(lblSelfPropelled);
        pnlGasPoweredMower.add(cmbSelfPropelled);
        return pnlGasPoweredMower;
    } // end createGasPowerMowerPanel
    
    private JPanel createPushReelMowerPanel() {
        JPanel pnlPushReelMower = new JPanel(new GridLayout(1,2));
        pnlPushReelMower.add(lblNumberOfWheels);
        pnlPushReelMower.add(txtNumOfWheels);
        return pnlPushReelMower;
        
    } // end createPushReelMowerPanel
    
    // method to empty the text fields
    public void emptyTextFields() {

        txtEngineManufacturer.setText(""); 
        txtHorsePower.setText("");
        txtCylinder.setText("");
        txtModelNumber.setText("");
        txtDeckWidth.setText("");
        txtOperatingHours.setText("");
        txtCutWidth.setText("");
        txtWheelDiameter.setText("");
        txtNumOfWheels.setText("");
        txtMowerManufacturer.setText("");
        txtYear.setText("");
        txtSerialNumber.setText("");
    } // end emptyTextFields
    
} // end class AddMowerForm
