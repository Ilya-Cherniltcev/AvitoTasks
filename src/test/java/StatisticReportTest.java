import org.example.StatisticReport;
import org.example.Task2;
import org.junit.jupiter.api.*;

import java.util.*;



public class StatisticReportTest {
    StatisticReport report = new StatisticReport();

    Task2 task2 = new Task2();
    List<HashMap<Long, Integer>> daysList = new ArrayList<>();
    HashMap<Long, Integer> day1Info = new HashMap<>();
    ;
    HashMap<Long, Integer> day2Info = new HashMap<>();

    HashMap<Long, Integer> resultMapFirstCase = new HashMap<>(Map.of(2L, 2500));
    HashMap<Long, Integer> resultMapSecondCase = new HashMap<>(Map.of(1L, 5500, 2L, 5500));
    HashMap<Long, Integer> resultMapThirdCase = new HashMap<>(Map.of(1L, 3000));

    @AfterEach
    void reset() {
        day1Info.clear();
        day2Info.clear();
        daysList.clear();
    }

    @Test
    void getChampionsTestFirstCase() {
        day1Info.put(1L, 1000);
        day1Info.put(2L, 1500);

        day2Info.put(2L, 1000);

        daysList.add(day1Info);
        daysList.add(day2Info);
        HashMap<Long, Integer> actual = report.getChampions(daysList);
        Assertions.assertEquals(resultMapFirstCase, actual);
    }

    @Test
    void getChampionsTestSecondCase() {
        day1Info.put(1L, 2000);
        day1Info.put(2L, 1500);

        day2Info.put(2L, 4000);
        day2Info.put(1L, 3500);

        daysList.add(day1Info);
        daysList.add(day2Info);

        HashMap<Long, Integer> actual = report.getChampions(daysList);
        Assertions.assertEquals(resultMapSecondCase, actual);
    }


    @Test
    void getChampionsTestIfUsersStepsMaxOnlyInOneDay() {
        day1Info.put(1L, 1000);

        day2Info.put(2L, 6000);
        day2Info.put(1L, 2000);

        daysList.add(day1Info);
        daysList.add(day2Info);

        HashMap<Long, Integer> actual = report.getChampions(daysList);
        Assertions.assertEquals(resultMapThirdCase, actual);
    }

    @Test
    void whatAboutDissatisfaction_Test_case1(){
        Set<Integer> goods = new TreeSet<>(Set.of(2,3,7,10,14,19,20));
        List<Integer> buyerNeeds = new ArrayList<>(List.of(5, 6, 13, 15, 17));
        int expected = 7;
        int actual = task2.whatAboutDissatisfaction(goods, buyerNeeds);
        Assertions.assertEquals(expected, actual);
    }
   @Test
    void whatAboutDissatisfaction_Test_case2(){
        Set<Integer> goods = new TreeSet<>(Set.of(0,5,10,22,50,51,53));
        List<Integer> buyerNeeds = new ArrayList<>(List.of(3, 10, 15, 35, 40, 45));
        int expected = 35;
        int actual = task2.whatAboutDissatisfaction(goods, buyerNeeds);
        Assertions.assertEquals(expected, actual);
    }

  @Test
    void whatAboutDissatisfaction_Test_case3_if_Out_Range(){
        Set<Integer> goods = new TreeSet<>(Set.of(13,15,50,77,100, 122, 150, 200));
        List<Integer> buyerNeeds = new ArrayList<>(List.of(1, 99, 118, 226, 166, 255));
        int expected = 114;
        int actual = task2.whatAboutDissatisfaction(goods, buyerNeeds);
        Assertions.assertEquals(expected, actual);
    }


}