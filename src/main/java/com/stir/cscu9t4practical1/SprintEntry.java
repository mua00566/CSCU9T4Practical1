/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stir.cscu9t4practical1;

/**
 *
 * @author 3141983
 */
public class SprintEntry extends Entry{
    private String typeOfRun;
    public static final String ENTRY_TYPE = "Run";
    
    public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String typeOfRun) {
    super(n, d, m, y, h, min, s, dist);
    this.typeOfRun = typeOfRun;
  }
    
    public String getTypeOfRun() {
    return typeOfRun;
  } //get run type
    
   @Override
  public String getEntry() {
      String result = getName()+" ran a " +getTypeOfRun()+ ", covering " 
             +getDistance() + " km in total, in a time of "
             +getHour()+":"+getMin()+":"+ getSec() + ", on "
             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
   return result;
  }
}


