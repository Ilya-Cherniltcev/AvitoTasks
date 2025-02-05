package org.example;

import java.util.*;
import org.example.Constants.*;

import static org.example.Constants.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("# Task 1 #");
        StatisticReport report = new StatisticReport();
        List<HashMap<Long, Integer>> list = new ArrayList<>();
        list.add(USER_MAP3);
        list.add(USER_MAP4);
        Optional<Map.Entry<Long, Integer>> championId = report.getChampionVar1(list);
        System.out.printf("champions = { userIds: %d, steps: %d }", championId.orElseThrow().getKey(),
                championId.orElseThrow().getValue());
        System.out.println();
        System.out.println();
        System.out.println("------------ User variant 2 ---------");

//        List<Set<User>> days = new ArrayList<>(List.of(USERS_SET_DAY1_CASE_2, USERS_SET_DAY2_CASE_2));
        List<Set<User>> days = new ArrayList<>(List.of(USERS_SET_DAY1_CASE_1, USERS_SET_DAY2_CASE_1));
        Optional<User> championUserId = report.getChampionVar2(days);
        System.out.println("champions = " + report.getJson(championUserId.orElseThrow()));
    }
}