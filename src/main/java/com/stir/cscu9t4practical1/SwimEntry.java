/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stir.cscu9t4practical1;

/**
 *
 * @author omair
 */
public class SwimEntry extends Entry{
    private String location;
    public static final String ENTRY_TYPE = "Swim";
    
    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String location) {
    super(n, d, m, y, h, min, s, dist);
    this.location = location;
  }
    
    public String getLocation () {
    return location;
  } //get location 
    
   @Override
  public String getEntry() {
      String result = getName()+" swam " +getDistance() + " km, in a time of "
             +getHour()+":"+getMin()+":"+ getSec() + ", on "
             +getDay()+"/"+getMonth()+"/"+getYear()+ ", with the location being the "
             +getLocation() + "\n";
   return result;
  }
}

