package org.example;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("# Task 1 #");
        System.out.println("# First case #");
        StatisticReport report = new StatisticReport();
        List<HashMap<Long, Integer>> daysList = new ArrayList<>();
        HashMap<Long, Integer> day1Info = new HashMap<>();
        day1Info.put(1L, 1000);
        day1Info.put(2L, 1500);
        HashMap<Long, Integer> day2Info = new HashMap<>();
        day2Info.put(2L, 1000);

        daysList.add(day1Info);
        daysList.add(day2Info);
        HashMap<Long, Integer> championsMap = report.getChampions(daysList);
        System.out.println("champions - userIds: = steps: " + championsMap);

        System.out.println("-------------------------------------------------------");
        System.out.println("# Second case #");
        daysList = new ArrayList<>();
        day1Info = new HashMap<>();
        day1Info.put(1L, 2000);
        day1Info.put(2L, 1500);

        day2Info = new HashMap<>();
        day2Info.put(2L, 4000);
        day2Info.put(1L, 3500);

        daysList.add(day1Info);
        daysList.add(day2Info);
        championsMap = report.getChampions(daysList);
        System.out.println("champions - userIds: = steps: " + championsMap);
    }
}