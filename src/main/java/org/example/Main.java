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

        System.out.println("-------------------------------------------------------");
        System.out.println("# Third case #");
        daysList = new ArrayList<>();
        day1Info = new HashMap<>();
        day1Info.put(1L, 1000);

        day2Info.put(2L, 6000);
        day2Info.put(1L, 2000);

        daysList.add(day1Info);
        daysList.add(day2Info);
        championsMap = report.getChampions(daysList);
        System.out.println("champions - userIds: = steps: " + championsMap);


        System.out.println("================================");
        System.out.println("# Task 2 #");
        System.out.println("================================");

        //  make set of goods
        Set<Integer> goods = new TreeSet<>(Set.of(8, 3, 5));
        List<Integer> goodsList = new ArrayList<>(goods);
        List<Integer> buyersDissatisfaction = new ArrayList<>();
        // make needs of buyers
        List<Integer> buyerNeeds = new ArrayList<>(List.of(5, 6));
        // logics
        int res = 0;
        int counter = 0;
        // -------------------------------------     O (n)
        for (int eachBuyerNeed : buyerNeeds) {
            int dissatisfaction = 0;
            if (!goods.contains(eachBuyerNeed)) {
                int minElement = goodsList.get(0);
                int maxElement = goodsList.get(goodsList.size() - 1);
                // case 1: minElement < eachBuyerNeed < maxElement
                if (eachBuyerNeed > minElement && eachBuyerNeed < maxElement) {
                    int middle = goodsList.size() / 2;
                    if (eachBuyerNeed - goodsList.get(middle) > 1) {
                        if ((middle - 1) >= 0 && (middle + 1) <= goodsList.size() - 1) {
                            // leftHalf
                            if (eachBuyerNeed - goodsList.get(middle - 1) < goodsList.get(middle + 1) - eachBuyerNeed) {
                                dissatisfaction = eachBuyerNeed - goodsList.get(middle - 1);
                            } else {
                                // rightHalf
                                dissatisfaction = goodsList.get(middle + 1) - eachBuyerNeed;
                            }
                        }
                    } else dissatisfaction = 1;
                }
                // case 2: eachBuyerNeed < minElement
                if (eachBuyerNeed < minElement) {
                    dissatisfaction = minElement - eachBuyerNeed;
                }
                // case 3: eachBuyerNeed > maxElement
                if (eachBuyerNeed > maxElement) {
                    dissatisfaction = eachBuyerNeed - maxElement;
                }
            }
            buyersDissatisfaction.add(counter, dissatisfaction);
            res += dissatisfaction;
            counter++;
        }
        System.out.println("Товары " + goods);
        System.out.println("Нужные покупателям товары " + buyerNeeds);
        System.out.println("суммарная неудовлетворенность res = " + res);
        for(int buyer = 0; buyer < buyersDissatisfaction.size(); buyer++){
            System.out.printf("%d-й покупатель покупает товар %d и его неудовлетворенность = %d", buyer+1,
                    buyerNeeds.get(buyer), buyersDissatisfaction.get(buyer));
            System.out.println();
        }

    }
}
