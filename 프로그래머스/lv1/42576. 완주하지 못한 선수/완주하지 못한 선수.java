import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String person : participant) {
            map.putIfAbsent(person, 0);
            map.put(person, map.get(person) + 1);
        }

        for (String completed : completion) {
            int count = map.get(completed) - 1;
            if (count == 0) {
                map.remove(completed);
            } else {
                map.put(completed, count);
            }
        }

        return map.keySet().iterator().next();
    }
}