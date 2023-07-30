import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        List<String> stringList = new ArrayList<>(List.of(strings));

        Comparator<String> customComparator = (s1, s2) -> {
            char char1 = s1.charAt(n);
            char char2 = s2.charAt(n);

            int charComparison = Character.compare(char1, char2);

            return charComparison == 0 ? s1.compareTo(s2) : charComparison;
        };

        stringList.sort(customComparator);

        return stringList.toArray(new String[0]);
    }
}