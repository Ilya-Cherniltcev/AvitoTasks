package org.example;

import java.util.*;

import org.json.JSONObject;


public class StatisticReport {
    public Optional<Map.Entry<Long, Integer>> getChampionVar1(List<HashMap<Long, Integer>> users) {
        HashMap<Long, Integer> summaryInfo = new HashMap<>();
        for (HashMap<Long, Integer> day : users) {
            for (Long userId : day.keySet()) {
                Integer tempStep = summaryInfo.getOrDefault(userId, 0);
                summaryInfo.put(userId, day.getOrDefault(userId, 0) + tempStep);
            }
        }
        return summaryInfo.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
    }

    public Optional<User> getChampionVar2(List<Set<User>> daysInfo) {
        // user : {userId, steps}
        Set<User> summaryInfo = new HashSet<>();
        int tempStep;
        User tempUser;
        for (Set<User> eachDay : daysInfo) {
            for (User user : eachDay) {
                if (!summaryInfo.isEmpty() && summaryInfo.contains(user)) {
                    tempUser = summaryInfo.stream().filter(u -> u.equals(user)).findFirst().get();
                    tempStep = tempUser.getSteps() + user.getSteps();
                    summaryInfo.remove(user);
                    summaryInfo.add(new User(tempUser.getId(), tempStep));
                } else {
                    tempStep = user.getSteps();
                    summaryInfo.add(user);
                }
            }
        }
        return summaryInfo.stream().max(Comparator.comparingInt(User::getSteps));
    }

    public JSONObject getJson(User user) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("userIds", user.getId());
            jsonObject.put("steps", user.getSteps());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
