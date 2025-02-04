package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StatisticReport report = new StatisticReport();
        ArrayList<HashMap<Long, Integer>> users = new ArrayList<>();
//        HashMap<Long, Integer> user1 = new HashMap<>(Map.of(1L, 1000, 2L, 1500));
//        HashMap<Long, Integer> user2 = new HashMap<>(Map.of( 2L, 1000));
         HashMap<Long, Integer> user1 = new HashMap<>(Map.of(1L, 2000, 2L, 1500));
        HashMap<Long, Integer> user2 = new HashMap<>(Map.of( 2L, 4000, 1L, 3500));
        users.add(user1);
        users.add(user2);
        report.getChampion(users);
    }
}