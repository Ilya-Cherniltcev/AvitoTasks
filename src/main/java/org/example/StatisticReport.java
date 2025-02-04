package org.example;

import java.util.*;

public class StatisticReport {
    // user : {userId, steps}
    public void getChampion(ArrayList<HashMap<Long, Integer>> users){
       HashMap<Long, Integer> summaryInfo = new HashMap<>();
       for(HashMap<Long, Integer> day : users){
           for(Long userId : day.keySet()){
               Integer tempStep = summaryInfo.getOrDefault(userId, 0);
                summaryInfo.put(userId, day.getOrDefault(userId, 0) + tempStep);
           }
       }
        Optional<Map.Entry<Long, Integer>> championId = summaryInfo.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue));
        System.out.printf("champions = { userIds: %d, steps: %d }", championId.get().getKey(), championId.get().getValue());
    }

}
