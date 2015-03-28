package com.jessespalding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;

public class HVACGUI extends JFrame {
    private JPanel rootPanel;
    private JCheckBox furnaceCheckBox;
    private JCheckBox centralACCheckBox;
    private JTextArea descTextField;
    private JButton addButton;
    private JList<ServiceCall> serviceCallJList;
    private JTextField addressTextField;
    private JComboBox furnaceTypeComboBox;
    private JTextField centralACModelTextField;
    private JButton resolveButton;
    private JTextField resolveDescTextField;

    DefaultListModel<ServiceCall> todayServiceCallModel;
    DefaultListModel<ServiceCall> resolvedServiceCallModel;

    public HVACGUI() throws IOException {
        super("Service Call List");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(new Dimension(650,500)); //todo set custom size

        final String FORCED_AIR = "Forced Air";
        final String BOILER = "Boiler";
        final String OCTOPUS = "Octopus";
        furnaceTypeComboBox.addItem(FORCED_AIR);
        furnaceTypeComboBox.addItem(BOILER);
        furnaceTypeComboBox.addItem(OCTOPUS);

        todayServiceCallModel = new DefaultListModel<ServiceCall>();
        serviceCallJList.setModel(todayServiceCallModel);
        serviceCallJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        resolvedServiceCallModel = new DefaultListModel<ServiceCall>();

        // todo resolvedCall.setFee(fee);
        // todo resolvedCall.setResolvedDate(new Date());  //default resolved date is now
        // todo resolvedServiceCalls.add(resolvedCall);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String address = addressTextField.getText();
                String serviceCallDesc = descTextField.getText();
                Date dateReported = new Date();
                String furnaceType = furnaceTypeComboBox.getSelectedItem().toString();
                String centralACModel = centralACModelTextField.getText();
//                ServiceCall newServiceCall = new ServiceCall(serviceCallDesc, address, dateReported);

                if (furnaceCheckBox.isSelected()) {
                    Furnace newFurnace = new Furnace(address, serviceCallDesc, dateReported, furnaceType);
                    addServiceCall(todayServiceCallModel, newFurnace);
                }
                if (centralACCheckBox.isSelected()) {
                    CentralAC newCentralAC = new CentralAC(address, serviceCallDesc, dateReported, centralACModel);
                    addServiceCall(todayServiceCallModel, newCentralAC);
                }
            }
        });
        resolveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // will provide a description to resolved service call list
//                String resolveDesc = resolveDescTextField.getText();
                ServiceCall toDelete = HVACGUI.this.serviceCallJList.getSelectedValue();
                HVACGUI.this.todayServiceCallModel.removeElement(toDelete);
            }
        });
    }


    private static void addServiceCall(DefaultListModel<ServiceCall> serviceCalls, ServiceCall newServiceCall) {
                //todo indicate furnace and/or central ac
                //todo String address = getStringInput();
                //todo String problem = getStringInput();
                //todo new date
                //todo add service call to list
                //todo optional: add by priority
        serviceCalls.addElement(newServiceCall);
    }

    // Used to create a new resolved service call object -- not currently implemented
//    protected static void addResolved(DefaultListModel<ServiceCall> resolvedServiceCall, String resolvedDesc) {
//        Date dateResolved = new Date();
//
//    }
}