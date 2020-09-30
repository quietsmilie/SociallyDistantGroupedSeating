/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stjohnwheaton.sociallydistantgroupedseating;

/**
 *
 * @author emili
 */
 public class SeatingRow {
     private int seats[];
     
     
     public SeatingRow()
     {
         
     }
     
     public SeatingRow(int size)
     {
         seats = new int[size];
     }
     
     public void setSize(int size)
     {
         seats = new int[size];
     }
     
     public int[] get(){
         return seats;
     }
     
     public boolean fillSeat(int seatIndex){
         if(seats[seatIndex]==0)
         {
             seats[seatIndex] = 1;
             return true;
         } else {
            // this should never happen!
            return false;
         }
     }

     public void unfillSeat(int seatIndex) {
         seats[seatIndex] = 0;
     }
     
     public void clearAllSeats()
     {
        setSize(seats.length);
     }
        
 };

