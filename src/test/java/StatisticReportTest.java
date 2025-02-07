import org.example.StatisticReport;
import org.junit.jupiter.api.*;

import java.util.*;



public class StatisticReportTest {
    StatisticReport report = new StatisticReport();
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
}