package com.IplProblem_Apr.VOFiles;

import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;

import com.IplProblem_Apr.service.MatchCSVReadService;

public class TeamsSet {
    
    public Set<String> teamsSet = new HashSet<String>();

    public Set<String> getTeams() {

        ListIterator<MatchVO> listIterator = MatchCSVReadService.matchesData.listIterator();

        while (listIterator.hasNext()) {

        	teamsSet.add(listIterator.next().getTeam1());

        }
        return teamsSet;

    }

}
