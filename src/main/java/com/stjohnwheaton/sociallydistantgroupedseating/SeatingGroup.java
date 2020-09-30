/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stjohnwheaton.sociallydistantgroupedseating;

import java.util.Hashtable;

/**
 *
 * @author emili
 */
 public class SeatingGroup {
     private Hashtable groupInfo;
     private int groupSize;
     
     public SeatingGroup(int size, Hashtable info)
     {
         set (size,info);
     }
     
     public void set(int size, Hashtable info){
         groupSize = size;
         groupInfo = info;
     }
     
    public Hashtable getGroupInfo() {
        return groupInfo;
    }

    public int getGroupSize() {
        return groupSize;
    }
 };
