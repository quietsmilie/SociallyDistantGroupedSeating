/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stjohnwheaton.sociallydistantgroupedseating;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author emili
 */
public class SeatingRow
{

    private final int totalSeats;
    private ArrayList<SeatingGroup> seatedGroups;
    private int socialDistanceSize = 3;
    private int availableSeats;
    private Hashtable rowInfo;
    private int distanceFromFront;

    public SeatingRow()
    {
        seatedGroups = new ArrayList();
        rowInfo = new Hashtable();
    }

    public SeatingRow(int socialDistanceSeats)
    {
        socialDistanceSize = socialDistanceSeats;
        seatedGroups = new ArrayList();
        rowInfo = new Hashtable();
    }

    public SeatingRow setSize(int size)
    {
        totalSeats = size;
        seatedGroups = new ArrayList();
        availableSeats = size;

        return this;
    }

    public SeatingRow setInfo(Hashtable info)
    {
        rowInfo = info;
        return this;
    }

    public Hashtable getInfo()
    {
        return rowInfo;
    }

    public SeatingRow setDistanceFromFront(int rowsFromFront)
    {
        distanceFromFront = rowsFromFront;
        return this;
    }

    public int getDistanceFromFront()
    {
        return distanceFromFront;
    }

    public int getTotalSeats()
    {
        return totalSeats;
    }

    public boolean seatGroup(SeatingGroup seatingGroup)
    {
        boolean result = false;
        int groupSize = seatingGroup.getGroupSize();
        if (availableSeats >= groupSize)
        {
            seatedGroups.add(seatingGroup);
            seatingGroup.getGroupInfo().put("Row", rowInfo);
            StringBuilder seats = new StringBuilder();
            for (int i = 1; i <= groupSize; i++)
            {
                seats.append(String.valueOf(totalSeats - availableSeats + i));
                seats.append(",");
            }
            seats.deleteCharAt(seats.length() - 1);
            seatingGroup.getGroupInfo().put("Seats", seats.toString());
            availableSeats -= groupSize;
            if (availableSeats >= socialDistanceSize)
            {
                availableSeats -= socialDistanceSize;
            } else
            {
                availableSeats = 0;
            }
            result = true;
        }
        return result;
    }

    public boolean unSeatGroup(SeatingGroup seatingGroup)
    {
        boolean result = false;
        boolean isLastGroup = false;
        if (seatedGroups.contains(seatingGroup))
        {
            availableSeats += seatingGroup.getGroupSize();
            // if it is the last group, 
            // then cannot assume all socialDistanceSize seats can be made available
            // so reseat remaining groups to update availableSeats
            if (seatedGroups.indexOf(seatingGroup) == seatedGroups.size() - 1)

            {
                isLastGroup = true;
            }
            seatedGroups.remove(seatingGroup);
            seatingGroup.getGroupInfo().remove("Row");
            seatingGroup.getGroupInfo().remove("Seats");

            if (!isLastGroup)
            {
                availableSeats += socialDistanceSize;
            } else
            {
                calculateAvailableSeats();
            }

            result = true;
        }
        return result;
    }

    public ArrayList<SeatingGroup> getGroups()
    {
        return seatedGroups;
    }

    public ArrayList<Integer> getGroupSizes()
    {
        ArrayList<Integer> groupSizes = new ArrayList();
        seatedGroups.forEach(p -> groupSizes.add(p.getGroupSize()));
        return groupSizes;
    }

    private void calculateAvailableSeats()
    {
        ArrayList<SeatingGroup> currentGroups = (ArrayList<SeatingGroup>) seatedGroups.clone();
        clearAllSeats();
        for (int i = 0; i < currentGroups.size(); i++)
        {
            seatGroup(currentGroups.get(i));
        }
    }

    public void clearAllSeats()
    {
        seatedGroups.clear();
        availableSeats = totalSeats;
    }

    public int availableSeats()
    {
        return availableSeats;
    }

    public SeatingRow copy()
    {
        SeatingRow returnValue = new SeatingRow(socialDistanceSize).setSize(totalSeats).setInfo(rowInfo).setDistanceFromFront(distanceFromFront);
        returnValue.seatedGroups = seatedGroups;
        returnValue.calculateAvailableSeats();
        return returnValue;
    }

    public int leftoverSeats()
    {
        int seatsTaken = 0;
        for (int i = 0; i < seatedGroups.size(); i++)
        {
            seatsTaken += seatedGroups.get(i).getGroupSize();
            seatsTaken += 3;
        }
        seatsTaken -= 3;
        return totalSeats - seatsTaken;
    }

};
