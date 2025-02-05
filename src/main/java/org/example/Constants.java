package org.example;

import java.util.*;

public class Constants {
    public static HashMap<Long, Integer> USER_MAP1 = new HashMap<>(Map.of(1L, 1000, 2L, 1500));
    public static HashMap<Long, Integer> USER_MAP2 = new HashMap<>(Map.of(2L, 1000));
    public static HashMap<Long, Integer> USER_MAP3 = new HashMap<>(Map.of(1L, 2000, 2L, 1500));
    public static HashMap<Long, Integer> USER_MAP4 = new HashMap<>(Map.of(2L, 4000, 1L, 3500));

    public static User USER_1_1_CASE_2 = new User(1L, 2000);
    public static User USER_2_1_CASE_2 = new User(2L, 1500);
    public static User USER_2_2_CASE_2 = new User(2L, 4000);
    public static User USER_1_2_CASE_2 = new User(1L, 3500);

    public static User USER_1_1_CASE_1 = new User(1L, 1000);
    public static User USER_2_1_CASE_1 = new User(2L, 1500);
    public static User USER_2_2_CASE_1 = new User(2L, 1000);


    public static Set<User> USERS_SET_DAY1_CASE_1 = new HashSet<>(Set.of(USER_1_1_CASE_1, USER_2_1_CASE_1));
    public static Set<User> USERS_SET_DAY2_CASE_1 = new HashSet<>(Set.of(USER_2_2_CASE_1));
    public static Set<User> USERS_SET_DAY1_CASE_2 = new HashSet<>(Set.of(USER_1_1_CASE_2, USER_2_1_CASE_2));
    public static Set<User> USERS_SET_DAY2_CASE_2 = new HashSet<>(Set.of(USER_1_2_CASE_2, USER_2_2_CASE_2));

    public static Optional<Map.Entry<Long, Integer>> CHAMPION_ENTRY_FIRST_CASE = Optional.of(new AbstractMap.SimpleEntry<>(2L, 2500));
    public static Optional<Map.Entry<Long, Integer>> CHAMPION_ENTRY_SECOND_CASE = Optional.of(new AbstractMap.SimpleEntry<>(1L, 5500));

    public static Optional<User> CHAMPION_USER_FIRST_CASE = Optional.of(new User(2L, 2500));
    public static Optional<User> CHAMPION_USER_SECOND_CASE = Optional.of(new User(1L, 5500));
}
