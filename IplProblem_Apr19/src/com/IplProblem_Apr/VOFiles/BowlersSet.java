package com.IplProblem_Apr.VOFiles;

import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;

import com.IplProblem_Apr.service.DeliveriesCSVReadService;


public class BowlersSet {
    
    


public Set<String> bowlersSet = new HashSet<String>();

public Set<String> getBowlers() {

    ListIterator<DeliveriesVO> it = DeliveriesCSVReadService.deliveriesData.listIterator();

    while (it.hasNext()) {

    	bowlersSet.add(it.next().getBowlerName());

    }
    return bowlersSet;

}
}