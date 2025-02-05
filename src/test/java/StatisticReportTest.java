import org.example.StatisticReport;
import org.example.User;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.example.Constants.*;


public class StatisticReportTest {
    StatisticReport report = new StatisticReport();
    List<HashMap<Long, Integer>> list = new ArrayList<>();
    List<Set<User>> usersInDays = new ArrayList<>();

    @AfterEach
     void reset(){
        list.clear();
        usersInDays.clear();
    }

    @Test
     void getChampionVar1TestFirstCase(){
        list.add(USER_MAP1);
        list.add(USER_MAP2);
        Optional<Map.Entry<Long, Integer>> actual = report.getChampionVar1(list);
        Assertions.assertEquals(CHAMPION_ENTRY_FIRST_CASE, actual);
    }
    @Test
     void getChampionVar1TestSecondCase(){
        list.add(USER_MAP3);
        list.add(USER_MAP4);
        Optional<Map.Entry<Long, Integer>> actual = report.getChampionVar1(list);
        Assertions.assertEquals(CHAMPION_ENTRY_SECOND_CASE, actual);
    }

    @Test
    void getChampionVar2TestFirstCase(){
        usersInDays.add(USERS_SET_DAY1_CASE_1);
        usersInDays.add(USERS_SET_DAY2_CASE_1);
        Optional<User> actual = report.getChampionVar2(usersInDays);
        Assertions.assertEquals(CHAMPION_USER_FIRST_CASE, actual);
    }
@Test
    void getChampionVar2TestSecondCase(){
        usersInDays.add(USERS_SET_DAY1_CASE_2);
        usersInDays.add(USERS_SET_DAY2_CASE_2);
        Optional<User> actual = report.getChampionVar2(usersInDays);
        Assertions.assertEquals(CHAMPION_USER_SECOND_CASE, actual);
    }

}
