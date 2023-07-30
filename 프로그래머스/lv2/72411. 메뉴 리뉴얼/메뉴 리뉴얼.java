import java.util.*;

class Solution {
    public static StringBuilder stringBuilder = new StringBuilder();

    public void combination(String order, int startIndex, int targetLength, HashMap<String, Integer> map) {
        if (stringBuilder.length() == targetLength) {
            char[] courseAsCharArray = stringBuilder.toString().toCharArray();
            Arrays.sort(courseAsCharArray);
            String course = new String(courseAsCharArray);

            map.putIfAbsent(course, 0);
            map.put(course, map.get(course) + 1);
        }

        for (int i = startIndex; i < order.length(); i++) {
            stringBuilder.append(order.charAt(i));
            combination(order, i + 1, targetLength, map);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public String[] solution(String[] orders, int[] course) {
        List<String> courseList = new ArrayList<>();

        for (int length : course) {
            HashMap<String, Integer> map = new HashMap<>();
            for (String order : orders) {
                if (order.length() >= length) {
                    combination(order, 0, length, map);
                }
            }
            if(!map.isEmpty()){
                Integer maxValue = Collections.max(map.values());
                if(maxValue>=2) {
                    for (String key : map.keySet()) {
                        if (Objects.equals(map.get(key), maxValue)) {
                            courseList.add(key);
                        }
                    }
                }
            }

        }
        courseList.sort(null);

        return courseList.toArray(new String[0]);
    }
}