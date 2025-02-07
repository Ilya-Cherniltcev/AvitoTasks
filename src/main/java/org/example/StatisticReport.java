package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class StatisticReport {
    public HashMap<Long, Integer> getChampions(List<HashMap<Long, Integer>> daysInfo) {
        // ---- filtering list by each user per each day
        HashMap<Long, Integer> firstDay = daysInfo.get(0);
        List<Long> usersIdFirstDay = firstDay.keySet().stream().toList();
        List<HashMap<Long, Integer>> daysInfoCopy = new ArrayList<>();
        for (int dayNumber = 0; dayNumber < daysInfo.size(); dayNumber++) {
            // check each day by users list
            for (Long userId : usersIdFirstDay) {
                // if user exist then add this user to copy list
                if (daysInfo.get(dayNumber).containsKey(userId)) {
                    HashMap<Long, Integer> tempMap = new HashMap<>();
                    tempMap.put(userId, daysInfo.get(dayNumber).get(userId));
                    daysInfoCopy.add(dayNumber, tempMap);
                }
            }
        }

        HashMap<Long, Integer> summaryInfo = new HashMap<>();
        for (var day : daysInfoCopy) {
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
