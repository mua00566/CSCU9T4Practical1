// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public String addEntry(Entry e){
       if (doesItExist(e.getName(), e.getDay(), e.getMonth(), e.getYear()) == false){
           tr.add(e);
           return "Record added successfully";
       } else {
           return "Entry failed: "+e.getName()+" has already made an entry on "
                   +e.getDay()+"/"+e.getMonth()+"/"+e.getYear()+"\n";
       }
   } // addClass
   
   // remove a record from the list
   public String removeRecord(String n, int d, int m, int y){
      String result = "No record with the specified name and date was found to remove";
      ListIterator<Entry> iter = tr.listIterator();
      while (iter.hasNext()) {
        Entry current = iter.next();
        if (current.getName().equalsIgnoreCase(n) && current.getDay() == d && 
                current.getMonth() == m && current.getYear() == y) {
            tr.remove(current);
            result = "Record with the specified name and date has been removed successfully"; 
            return result;
        }
    }
    return result;
   }
    
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
       String result = "No entries found";
       ListIterator<Entry> iter = tr.listIterator();
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = current.getEntry();
            }
       return result;
   } // lookupEntry
   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
   public String findAllEntriesByDate(int d, int m, int y) {
    String allEntries = "";
    ListIterator<Entry> iter = tr.listIterator();

    while (iter.hasNext()) {
      Entry current = iter.next();
      if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
        allEntries += current.getEntry(); // Add current entry 
      }
    }

    if (allEntries.isEmpty()) {
      allEntries = "No entries found for this date."; // Handle no entries
    }

    return allEntries;
  }
   
   public boolean doesItExist(String n, int d, int m, int y){
      boolean exists = false;
      ListIterator<Entry> iter = tr.listIterator();
      while (iter.hasNext()) {
      Entry current = iter.next();
      if (current.getName().equalsIgnoreCase(n) && current.getDay() == d && 
              current.getMonth() == m && current.getYear() == y) {
        exists = true; // Add current entry 
      }
    }
    return exists;
   }
   
} // TrainingRecord