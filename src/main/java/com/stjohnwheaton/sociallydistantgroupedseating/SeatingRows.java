/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stjohnwheaton.sociallydistantgroupedseating;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 *
 * @author emili
 */
public class SeatingRows implements Collection<SeatingRow> {
    private ArrayList<SeatingRow> seatingRows;
    private int socialDistanceSize = 3;
    
    public SeatingRows( )
     {
         seatingRows = new ArrayList();
     }
     
     public SeatingRows(int socialDistanceSeats)
     {
         socialDistanceSize=socialDistanceSeats;
         seatingRows = new ArrayList();
     }
    
    public void addSeatingRow(int rowsFromFront, int numberOfSeats, Hashtable info)
    {
        seatingRows.add(new SeatingRow(socialDistanceSize).setSize(numberOfSeats).setDistanceFromFront(rowsFromFront).setInfo(info));
    }
    
    public int[] getSeatingRowSizes()
    {
        int[] seatingRowSizes;
        
        seatingRowSizes = new int[seatingRows.size()];
        if (seatingRows.size()>0)
        {
            
            for (int i=0; i<seatingRowSizes.length;i++)
            {   
                seatingRowSizes[i]=seatingRows.get(i).getTotalSeats();
            }
        }
        return seatingRowSizes;
    }
    
    public SeatingRow getFrontmostRowBySize(int size)
    {
        ArrayList<SeatingRow> rowsBySize;
        // get all rows with size
        
        // needs more work
        //rowsBySize = seatingRows.clone()//removeIf(test(t.availableSeats()!=size));
        
        return null;
    }
    
    public ArrayList<SeatingRow> getRowsWithAvailableSeats()
    {
        Predicate<SeatingRow> hasSeats = i -> (i.availableSeats() > 0);
        ArrayList<SeatingRow> rowsWithAvailableSeats = new ArrayList();
        rowsWithAvailableSeats.addAll(seatingRows);
        rowsWithAvailableSeats.removeIf(hasSeats.negate());
        return rowsWithAvailableSeats;
    }

        public ArrayList<SeatingRow> getRowsWithLeftoverSeats()
    {
        Predicate<SeatingRow> hasSeats = i -> (i.leftoverSeats() > 0);
        ArrayList<SeatingRow> rowsWithAvailableSeats = new ArrayList();
        rowsWithAvailableSeats.addAll(seatingRows);
        rowsWithAvailableSeats.removeIf(hasSeats.negate());
        return rowsWithAvailableSeats;
    }
        
    @Override
    public int size() {
        return seatingRows.size();
    }

    @Override
    public boolean isEmpty() {
        return seatingRows.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return seatingRows.contains(o);
    }

    @Override
    public Iterator<SeatingRow> iterator() {
        return seatingRows.iterator();
    }

    @Override
    public Object[] toArray() {
        return seatingRows.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return seatingRows.toArray(a);
    }

    @Override
    public boolean add(SeatingRow e) {
        return seatingRows.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return seatingRows.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return seatingRows.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends SeatingRow> c) {
        return seatingRows.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return seatingRows.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return seatingRows.retainAll(c);
    }

    @Override
    public void clear() {
       seatingRows.clear();
    }
    
    public SeatingRows getCopyForSubsets()
    {
        return getValuesOnlyCopy(seatingRows);
    }
    
    public SeatingRows getValuesOnlyCopy(final ArrayList<SeatingRow> startingList)
    {
        SeatingRows returnValue = new SeatingRows(socialDistanceSize);
        ArrayList<SeatingRow> newList = new ArrayList();
        startingList.forEach((i) -> newList.add(i));
        newList.forEach((i) -> returnValue.add(i));
        return returnValue;
    }
    
    public void sortByDistanceFromFront()
    {
        Collections.sort(seatingRows,rowDistanceFronFrontComparator);
    }
    
    public Comparator<SeatingRow> rowDistanceFronFrontComparator = new Comparator<SeatingRow>()
    {
        @Override
        public int compare(SeatingRow sr1, SeatingRow sr2)
        {
            return Integer.compare(sr1.getDistanceFromFront(), sr2.getDistanceFromFront());
        }
    };
};
