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
public class SeatingGroups implements Collection<SeatingGroup> {
        
    private ArrayList<SeatingGroup> seatingGroups;
    
    public SeatingGroups()
    {
        seatingGroups = new ArrayList();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    
}
