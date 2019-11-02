package com.IplProblem_Apr.VOFiles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import com.IplProblem_Apr.service.MatchCSVReadService;

public class MatchIdMapping {
    
    public List<Integer> matchIdList;
    public Integer season;



    public Map<Integer, List<Integer>> getMatchIdAndSeasonMap() {

        Set<Integer> seasonSet = new HashSet<Integer>();
        Map<Integer, List<Integer>> matchIdMap = new HashMap<Integer, List<Integer>>();

        SeasonsSet seasonsSet = new SeasonsSet();
        seasonSet = seasonsSet.getSeasons();

        Iterator<Integer> seasonItr = seasonSet.iterator();

        while (seasonItr.hasNext()) {
            season = seasonItr.next();
            int i = 0;
            matchIdList = new ArrayList<Integer>();
            ListIterator<MatchVO> it = MatchCSVReadService.matchesData.listIterator();
            while (it.hasNext()) {

                if (it.next().getSeason() == season) {
                    matchIdList.add(MatchCSVReadService.matchesData.get(i).getMatchId());
                }
                i++;
            }
            matchIdMap.put(season, matchIdList);

        }

        return matchIdMap;
    }
}
