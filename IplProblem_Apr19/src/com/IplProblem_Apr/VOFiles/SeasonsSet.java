package com.IplProblem_Apr.VOFiles;

import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;

import com.IplProblem_Apr.service.MatchCSVReadService;

public class SeasonsSet {

    public Set<Integer> seasonsSet = new HashSet<Integer>();

    public Set<Integer> getSeasons() {

        ListIterator<MatchVO> listIterator = MatchCSVReadService.matchesData.listIterator();

        while (listIterator.hasNext()) {

        	seasonsSet.add(listIterator.next().getSeason());

        }
        return seasonsSet;

    }
}
