// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JComboBox<String> entryType = new JComboBox<String>(new String[] {"", "Run", "Cycle", "Swim"});
    private JTextField name = new JTextField(25);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JComboBox<String> runType = new JComboBox<String>(new String[] {"", 
        "4x40m with 3 min recovery", "4x300m with 6 min recovery", "1x5km"});
    private JComboBox<String> swimLocation = new JComboBox<String>(new String[] {"", "Pool", "Outdoors"});
    private JTextField cycleTerrain = new JTextField(7);
    private JTextField cycleTempo = new JTextField(7);
    
    private JLabel labtype = new JLabel(" Session Type:");
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Total Distance (km):");
    private JLabel labruntype = new JLabel(" Type of run:");
    private JLabel labswimlocation = new JLabel(" Swim Location:");
    private JLabel labcycleterrain = new JLabel(" Cycle Terrain:");
    private JLabel labcycletempo = new JLabel(" Cycle Tempo:");
    
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up By Date");
    private JButton findAllByDate = new JButton("Find All By Date");
    private JButton removeByNameAndDate = new JButton("Remove By Name And Date");
    
    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(27, 60);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labtype);
        add(entryType);
        entryType.setEditable(true);
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(labruntype);
        add(runType);
        runType.setEditable(true);
        add(labswimlocation);
        add(swimLocation);
        swimLocation.setEditable(true);
        add(labcycleterrain);
        add(cycleTerrain);
        cycleTerrain.setEditable(true);
        add(labcycletempo);
        add(cycleTempo);
        cycleTempo.setEditable(true);
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(findAllByDate);
        findAllByDate.addActionListener(this);
        add(removeByNameAndDate);
        removeByNameAndDate.addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(745, 650);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry();
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == findAllByDate) {
            message = findAllEntriesByDate();
        }
        if (event.getSource() == removeByNameAndDate) {
            message = removeRecord();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed
    
    public String findAllEntriesByDate() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        return myAthletes.findAllEntriesByDate(d, m, y); // Call method in TrainingRecord
    }

    public String addEntry() {
        String message = "";
        System.out.println("Adding entry to the records...");
        String sessionType = entryType.getSelectedItem().toString();
        String n = name.getText();
        String dText = day.getText();
        String mText = month.getText();
        String yText = year.getText();
        String kmText = dist.getText();
        String hText = hours.getText();
        String mmText = mins.getText();
        String sText = secs.getText();
        String typeOfRun = runType.getSelectedItem().toString();
        String locationSwim = swimLocation.getSelectedItem().toString();
        String terrain = cycleTerrain.getText();
        String tempo = cycleTempo.getText();
        
        if (n.isEmpty() || dText.isEmpty() || mText.isEmpty() || yText.isEmpty() || kmText.isEmpty() 
                || hText.isEmpty() || mmText.isEmpty() || sText.isEmpty()) {
            return "Please do not leave name, date, time, or distance fields empty!";
        }
        if (sessionType.equals("Run") && typeOfRun.isEmpty()){
            return "For 'Run' session type, please fill out the 'Type of run' field";
        } else if (sessionType.equals("Swim") && locationSwim.isEmpty()){
            return "For 'Swim' session type, please fill out the 'Swim Location' field";
        } else if (sessionType.equals("Cycle") && (terrain.isEmpty() || tempo.isEmpty())){
            return "For 'Cycle' session type, please fill out the 'Cycle Terrain' and 'Cycle Tempo' fields";
        }
        
        int d = Integer.parseInt(dText);
        int m = Integer.parseInt(mText);
        int y = Integer.parseInt(yText);
        float km = java.lang.Float.parseFloat(kmText);
        int h = Integer.parseInt(hText);
        int mm = Integer.parseInt(mmText);
        int s = Integer.parseInt(sText);
        
        if (sessionType.equals("Run")){
            Entry e = new SprintEntry(n, d, m, y, h, mm, s, km, typeOfRun);
            message = myAthletes.addEntry(e);
        } else if(sessionType.equals("Swim")){
            Entry e = new SwimEntry(n, d, m, y, h, mm, s, km, locationSwim);
            message = myAthletes.addEntry(e);
        } else if(sessionType.equals("Cycle")){
            Entry e = new CycleEntry(n, d, m, y, h, mm, s, km, terrain, tempo);
            message = myAthletes.addEntry(e);
        } else if(sessionType.equals("")){
            Entry e = new Entry(n, d, m, y, h, mm, s, km);
            message = myAthletes.addEntry(e);
        }
        return message;
    }
    
    public String removeRecord(){
        String n = name.getText();
        int d = Integer.parseInt(day.getText());
        int m = Integer.parseInt(month.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("removing record...");
        String message = myAthletes.removeRecord(n, d, m, y);
        return message;
    }
    
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }

    public void blankDisplay() {
        entryType.setSelectedItem("");
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        runType.setSelectedItem("");
        swimLocation.setSelectedItem("");
        cycleTerrain.setText("");
        cycleTempo.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI

