/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stir.cscu9t4practical1;

/**
 *
 * @author omair
 */
public class CycleEntry extends Entry{
    private String terrain;
    private String tempo;
    public static final String ENTRY_TYPE = "Cycle";
    
    public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String terrain, String tempo) {
    super(n, d, m, y, h, min, s, dist);
    this.terrain = terrain;
    this.tempo = tempo;
  }
    
    public String getTerrain() {
    return terrain;
  } //get terrain
    
    public String getTempo() {
    return tempo;
  } //get tempo
    
   @Override
  public String getEntry() {
      String result = getName()+" cycled " +getDistance() + " km in a time of "
             +getHour()+":"+getMin()+":"+ getSec() + ", on "
             +getDay()+"/"+getMonth()+"/"+getYear()+ ", on a "
             +getTerrain() + " terrain, with a " +getTempo() + " tempo\n";
   return result;
  }
}

