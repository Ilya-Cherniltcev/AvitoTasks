package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Task2 {
    public int whatAboutDissatisfaction(Set<Integer> goods, List<Integer> buyerNeeds) {
        int res = 0;
        // make list of set
        List<Integer> goodsList = new ArrayList<>(goods);
        List<Integer> buyersDissatisfaction = new ArrayList<>();
        // solve by Binary search
        for (int counter = 0; counter < buyerNeeds.size(); counter++) {
            int startCounter = 0;
            int endCounter = goodsList.size() - 1;
            int thisElement = buyerNeeds.get(counter);
            boolean bingo = false;
            while (startCounter <= endCounter) {
                int diss;
                // case 0
                if (thisElement < goodsList.get(0)) {
                    diss = goodsList.get(startCounter) - thisElement;
                    buyersDissatisfaction.add(counter, diss);
                    res += diss;
                    bingo = true;
                    break;
                }
                // case 0.1
                if (thisElement > goodsList.get(goodsList.size() - 1)) {
                    diss = thisElement - goodsList.get(endCounter);
                    buyersDissatisfaction.add(counter, diss);
                    res += diss;
                    bingo = true;
                    break;
                }
                int middleCounter = (startCounter + endCounter) / 2;
                // case 1
                if (thisElement == goodsList.get(middleCounter)) {
                    buyersDissatisfaction.add(counter, 0);
                    bingo = true;
                    break;
                }
                // case 2
                if (thisElement > goodsList.get(middleCounter)) {
                    startCounter = middleCounter + 1;
                } else {
                    endCounter = middleCounter - 1;
                }
            }
            // case 3
            if (!bingo) {
                int diss1 = Math.abs(thisElement - goodsList.get(startCounter));
                int diss2 = Math.abs(goodsList.get(endCounter) - thisElement);
                if (diss1 >= diss2) {
                    buyersDissatisfaction.add(counter, diss2);
                    res += diss2;
                } else {
                    buyersDissatisfaction.add(counter, diss1);
                    res += diss1;
                }
            }
        }
        System.out.println("Товары " + goods);
        System.out.println("Нужные покупателям товары " + buyerNeeds);
        System.out.println("суммарная неудовлетворенность res = " + res);
        for (int buyer = 0; buyer < buyersDissatisfaction.size(); buyer++) {
            System.out.printf("%d-й покупатель покупает товар %d и его неудовлетворенность = %d", buyer + 1,
                    buyerNeeds.get(buyer), buyersDissatisfaction.get(buyer));
            System.out.println();
        }
        return res;
    }
}
