/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stjohnwheaton.sociallydistantgroupedseating;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 *
 * @author Emilie Yonkers
 */
public class SociallyDistantGroupedSeatingArrangement
{

    private SeatingGroups groupsToSeat;
    private SeatingRows rowsAvailable;
    private SeatingGroups seatedGroups;
    private SeatingRows rowsOccupied;
    private SeatingRows rowsEmpty;
    private String groupSortKeyValue;
    private String rowSortKeyValue;

    public SociallyDistantGroupedSeatingArrangement()
    {
        groupsToSeat = new SeatingGroups();
        rowsAvailable = new SeatingRows();
        seatedGroups = new SeatingGroups();
        rowsOccupied = new SeatingRows();
        rowsEmpty = new SeatingRows();
    }

    public SociallyDistantGroupedSeatingArrangement(SeatingGroups seatingGroups, SeatingRows seatingRows)
    {
        groupsToSeat = seatingGroups;
        rowsAvailable = seatingRows;
        seatedGroups = new SeatingGroups();
        rowsOccupied = new SeatingRows();
        rowsEmpty = seatingRows;
    }

    public SociallyDistantGroupedSeatingArrangement setSeating(SeatingGroups alreadySeatedGroups, SeatingRows rowsAlreadyOccupied, SeatingRows rowsStillEmpty)
    {
        seatedGroups = alreadySeatedGroups;
        rowsOccupied = rowsAlreadyOccupied;
        rowsEmpty = rowsStillEmpty;

        return this;
    }

    public boolean addSeatingGroup(SeatingGroup group)
    {
        return groupsToSeat.add(group);
    }

    public ArrayList<SeatingGroup> getAllSeatingGroups()
    {
        ArrayList<SeatingGroup> returnValue = new ArrayList();
        groupsToSeat.forEach((group) -> returnValue.add((SeatingGroup) group));
        seatedGroups.forEach((group) -> returnValue.add((SeatingGroup) group));
        return returnValue;
    }

    public ArrayList<SeatingRow> getAllSeatingRows()
    {
        ArrayList<SeatingRow> returnValue = new ArrayList();
        rowsAvailable.forEach((row) -> returnValue.add((SeatingRow) row));
        return returnValue;
    }

    public ArrayList<SeatingGroup> getSeatedGroups()
    {
        ArrayList<SeatingGroup> returnValue = new ArrayList();
        seatedGroups.forEach((group) -> returnValue.add((SeatingGroup) group));
        return returnValue;
    }

    public ArrayList<SeatingGroup> getUnSeatedGroups()
    {
        ArrayList<SeatingGroup> returnValue = new ArrayList();
        groupsToSeat.forEach((group) -> returnValue.add((SeatingGroup) group));
        return returnValue;
    }

    public boolean addSeatingRow(SeatingRow row)
    {
        return rowsAvailable.add(row);
    }

    public void seatAllGroups()
    {
//    """
//    Returns the optimal seating group sizes for each row, as well as any
//    groups that aren't able to be seated (must go into overflow)
//    """
        // first, order the rows by DistanceFromFront
        rowsAvailable.sortByDistanceFromFront();
        boolean groupSeated = seatGroups();
        // check if any groups still need to be seated, 
        //if so, try swapping groups among rows with available seats
        ArrayList<SeatingRow> rowsWithSeats = rowsAvailable.getRowsWithLeftoverSeats();
        while (groupSeated && groupsToSeat.size() > 0 && rowsWithSeats.size() > 0)
        {
            groupSeated = false;
            rowsWithSeats = rowsAvailable.getRowsWithLeftoverSeats();
            //rowsWithSeats.addAll(rowsEmpty);
            if (rowsWithSeats.size() > 1)
            {
                if (swapGroups(rowsWithSeats))
                {
                    groupSeated = true;
                    seatGroups();                    
                }
            }
            
        }
        //return groupSeated;
    }

    private boolean seatGroups()
    {
        boolean groupSeated = false;
        SeatingRow currentRow;
        SeatingGroups possibleGroups;

        // Creating predicate
        for (Iterator<SeatingRow> it = rowsAvailable.iterator(); it.hasNext();)
        {
            currentRow = it.next();
            if (groupsToSeat.size() > 0)
            {
                do
                {
                    possibleGroups = groupsToSeat.getCopyForSubsets();
                    int availableSeats = currentRow.availableSeats();
                    Predicate<SeatingGroup> greaterThan = i -> (i.getGroupSize() > availableSeats);

                        possibleGroups.removeIf(greaterThan);

                    if (possibleGroups.size() > 0)
                    {
                        SeatingGroup currentGroup;
                        currentGroup = possibleGroups.getGroups().get(0);
                        //Iterator<SeatingGroup> it2 = possibleGroups.iterator();
                        //while (it2.hasNext() && currentRow.availableSeats()>0) {
                        //currentGroup = it2.next();
                        if (currentRow.availableSeats() >= currentGroup.getGroupSize())
                        {
                            currentRow.seatGroup(currentGroup);
                            if (!seatedGroups.contains(currentGroup))
                            {
                                seatedGroups.add(currentGroup);
                            }
                            groupsToSeat.remove(currentGroup);
                            groupSeated = true;
                        }

                    }
                    //}
                } while (possibleGroups.size() > 0 && currentRow.availableSeats() > 0);
                if (!rowsOccupied.contains(currentRow))
                {
                    rowsOccupied.add(currentRow);
                }

            }

        }
        return groupSeated;
    }

    private boolean swapGroups(ArrayList<SeatingRow> rowsToSwap)
    {
        //Performs best swap possible between all rows
        //until no more best swaps can be performed. 
        //Swaps are done in-place.
        boolean swap = false;
        boolean anySwap = false;
        SeatingRow currentRow;
        SeatingRow swapRow;
        do
        {
            for (int i = 0; i < rowsToSwap.size(); i++)
            {
                currentRow = rowsToSwap.get(i);

                for (int j = i + 1; j < rowsToSwap.size(); j++)
                {
                    swapRow = rowsToSwap.get(j);
                    swap = bestSwap(currentRow, swapRow);
                    if (swap == true)
                    {
                        anySwap = true;
                    }
                }
            }
        } while (swap);
        return anySwap;
    }

    private boolean bestSwap(SeatingRow rowA, SeatingRow rowB)
    {
        // Finds the best swap between rows a and b 
        // which will increase the gradient between their leftover values.
        // Performs the swap and returns Truw, if found
        // If no such swap exists, returns false

        int leftoverSeatsA = rowA.leftoverSeats();
        int leftoverSeatsB = rowB.leftoverSeats();

        int currentDifference = Math.abs(leftoverSeatsB - leftoverSeatsA);
        int maxDifference = currentDifference;
        int swapDifference = 0;

        SeatingGroup[] bestPair = new SeatingGroup[2];
        //max_pair = (None, None)

//    # No swap if one of the leftovers is 0
//    if leftover_a == 0 or leftover_b == 0:
//        return max_pair
        if (leftoverSeatsA > 0 && leftoverSeatsB > 0)
        {
            ArrayList<SeatingGroup> groupsA = rowA.getGroups();
            SeatingGroup currentGroupA;
            ArrayList<SeatingGroup> groupsB = rowB.getGroups();
            SeatingGroup currentGroupB;
            for (Iterator<SeatingGroup> itA = groupsA.iterator(); itA.hasNext();)
            {
                currentGroupA = itA.next();
//            for fa in families_a
//                    for fb in families_b
                for (Iterator<SeatingGroup> itB = groupsB.iterator(); itB.hasNext();)
                {
                    currentGroupB = itB.next();
                    swapDifference = currentGroupA.getGroupSize() - currentGroupB.getGroupSize();
//                            How much the leftover will change
//                              for pew a if we swap fa and fb
//                            Skip invalid swaps where the
//                              leftover would be negative
//                                impossible on either row.
                    if (leftoverSeatsA + swapDifference > 0 && leftoverSeatsB - swapDifference > 0)
                    {
//            The difference between the two leftovers IF the swap were to take place:
                        currentDifference = Math.abs((leftoverSeatsA + swapDifference) - (leftoverSeatsB - swapDifference));
//            Compare with best swap, replace if better.
                        if (currentDifference > maxDifference)
                        {
                            maxDifference = currentDifference;
                            bestPair[0] = currentGroupA;
                            bestPair[1] = currentGroupB;
                        }
                    }
                }
            }
        }
        if (bestPair[0] != null)
        {
            rowA.unSeatGroup(bestPair[0]);
            rowB.unSeatGroup(bestPair[1]);
            
            rowA.seatGroup(bestPair[1]);
            rowB.seatGroup(bestPair[0]);

            return true;
        }
        return false;
    }

    public void setGroupSortKey(String sortKey)
    {
        groupSortKeyValue = sortKey;
    }

    public void setRowSortKey(String sortKey)
    {
        groupSortKeyValue = sortKey;
    }

    public Comparator<SeatingGroup> groupStringComparator = new Comparator<SeatingGroup>()
    {
        @Override
        public int compare(SeatingGroup sg1, SeatingGroup sg2)
        {
            return (int) (sg1.getGroupInfo().get(groupSortKeyValue).toString().compareToIgnoreCase(sg2.getGroupInfo().get(groupSortKeyValue).toString()));
        }
    };

    public Comparator<SeatingRow> rowStringComparator = new Comparator<SeatingRow>()
    {
        @Override
        public int compare(SeatingRow sr1, SeatingRow sr2)
        {
            return (int) (sr1.getInfo().get(groupSortKeyValue).toString().compareToIgnoreCase(sr2.getInfo().get(groupSortKeyValue).toString()));
        }
    };

};
/*
    # Isolate all imperfect pews: pews that hypothetically could fit more people while still distancing
    imperfect_pews = list(filter(lambda p: pew_leftover(pews[p[0]], p[1], margin) != 0, matched_pews))

    # Try swapping between imperfect pews to find if there are people who might fit
    if len(imperfect_pews) > 1 and sum(family_counts.values()) > 0:
        print('imperfect before swap:', imperfect_pews)
        swap_families(pews, imperfect_pews, margin)
        print('imperfect after swap:', imperfect_pews)

        # This essentially becomes another subset problem, but now we're looking for the subset
        # of the remaining families that can sum to the leftover space we might have
        # aggregated by swapping.
        for pew_idx, matched_families in imperfect_pews:
            leftover = pew_leftover(pews[pew_idx], matched_families, margin)

            expanded = expand_counts(family_counts) + margin

            if len(expanded) == 0:
                break

            subset = subset_sum(expanded, leftover, mode='<=')

            if subset:
                subset = np.array(subset) - margin
                for fam in subset:
                    family_counts[fam] -= 1
                    matched_families.append(fam)
                
    return (matched_pews, unmatched_pews, family_counts)

def pew_leftover(pew_size, family_sizes, margin):
    """
    Returns the amount of leftover space within a pew that is not being
    used by the families currently sitting in it.
    A family "uses" the spaces to seat family members, plus the margin
    to one side needed to maintain distance.
    """
    return pew_size + margin - sum(f + margin for f in family_sizes)

def swap_families(pew_sizes, matched_pews, margin):
    """
    Performs best swap possible between all pews in matched_pews, until no more
    best swaps can be performed. Swaps are done in-place.
    """
    swap = True
    while swap:
        swap = False
        for a in range(len(matched_pews)):
            for b in range(a + 1, len(matched_pews)):
                (pew_idx_a, families_a) = matched_pews[a]
                pew_size_a = pew_sizes[pew_idx_a]
                (pew_idx_b, families_b) = matched_pews[b]
                pew_size_b = pew_sizes[pew_idx_b]

                (fa, fb) = best_swap(pew_size_a, families_a, pew_size_b, families_b, margin)

                if fa is None or fb is None:
                    continue

                families_a.remove(fa)
                families_a.append(fb)
                families_b.remove(fb)
                families_b.append(fa)
                
                swap = True

def best_swap(pew_size_a, families_a, pew_size_b, families_b, margin):
    """
    Finds the best swap between pews a and b which will increase the
    gradient between their leftover values.
    Returns the swap as a tuple (family_a, family_b) where family_a
    and family_b are the family sizes that should be swapped from
    pews a and b, respectively.
    If no such swap exists, returns (None, None).
    """
    leftover_a = pew_leftover(pew_size_a, families_a, margin)
    leftover_b = pew_leftover(pew_size_b, families_b, margin)
    curr_diff = abs(leftover_a - leftover_b)

    max_diff = curr_diff # Limit swaps to ones that will land us in a better situation than the current one
    max_pair = (None, None)

    # No swap if one of the leftovers is 0
    if leftover_a == 0 or leftover_b == 0:
        return max_pair

    for fa in families_a:
        for fb in families_b:
            swap = fa - fb # How much the leftover will change for pew a if we swap fa and fb

            # Skip invalid swaps, where the leftover would be negative (impossible) on either pew.
            if leftover_a + swap < 0 or leftover_b - swap < 0:
                continue

            # The difference between the two leftovers IF the swap were to take place:
            diff = abs((leftover_a + swap) - (leftover_b - swap))

            # Compare with best swap, replace if better.
            if diff > max_diff:
                max_diff = diff
                max_pair = (fa, fb)

    return max_pair
     
 }
 
   

 */
