/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stjohnwheaton.sociallydistantgroupedseating;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/**
 *
 * @author emili
 */
public class SeatingGroups implements Collection<SeatingGroup>, Cloneable {
        
    private ArrayList<SeatingGroup> seatingGroups;
    
    public SeatingGroups()
    {
        seatingGroups = new ArrayList();
    }

    SeatingGroups(ArrayList<SeatingGroup> groupsToSeat) {
        seatingGroups = groupsToSeat;
    }
    
    @Override
    public void clear() {
        seatingGroups.clear();
    }

    @Override
    public int size() {
        return seatingGroups.size();
    }

    @Override
    public boolean isEmpty() {
        return (seatingGroups.isEmpty());
    }

    @Override
    public boolean contains(Object o) {
        return seatingGroups.contains(o);
    }

    @Override
    public Iterator iterator() {
        return seatingGroups.iterator();
    }

    @Override
    public Object[] toArray() {
        return seatingGroups.toArray();
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray(IntFunction generator) {
        return Collection.super.toArray(generator); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(SeatingGroup sg) {
        seatingGroups.add((SeatingGroup) sg);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return seatingGroups.remove(o);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection c) {
        return seatingGroups.addAll(c);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection c) {        
        return seatingGroups.removeAll(c);
    }

    @Override
    public boolean removeIf(Predicate filter) {
        return Collection.super.removeIf(filter); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void forEach(Consumer action) {
        Collection.super.forEach(action); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Integer> getGroupSizes(){
        ArrayList<Integer> groupSizes = new ArrayList();
        seatingGroups.forEach(p -> groupSizes.add(p.getGroupSize()));
        return groupSizes;
    }

    public ArrayList<SeatingGroup> getGroups(){
        return seatingGroups;
    }    
    
    public SeatingGroups getCopyForSubsets()
    {
        SeatingGroups returnValue = getValuesOnlyCopy(seatingGroups);
        
        return returnValue;
    }

    public SeatingGroups getValuesOnlyCopy(final ArrayList<SeatingGroup> startingList)
    {
        SeatingGroups returnValue = new SeatingGroups();
        ArrayList<SeatingGroup> newList = new ArrayList();
        startingList.forEach((i) -> newList.add(i));
        newList.forEach((i) -> returnValue.add(i));
        return returnValue;
    }


//}
  };  
