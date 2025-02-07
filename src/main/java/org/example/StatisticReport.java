package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class StatisticReport {
    public HashMap<Long, Integer> getChampions(List<HashMap<Long, Integer>> daysInfo) {
        HashMap<Long, Integer> summaryInfo = new HashMap<>();
        for (HashMap<Long, Integer> day : daysInfo) {
            for (Long userId : day.keySet()) {
                int tempStep = summaryInfo.getOrDefault(userId, 0);
                summaryInfo.put(userId, day.getOrDefault(userId, 0) + tempStep);
            }
        }
        // ----- find maximum element
             int maxSteps = summaryInfo.entrySet()
                    .stream()
                    .max(Comparator.comparing(Map.Entry::getValue))
                     .orElseThrow().getValue();

        // ----- filtering map by maximum value and make new Map
        return (HashMap<Long, Integer>) summaryInfo.entrySet().stream()
                .filter(entry -> entry.getValue() == maxSteps)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
