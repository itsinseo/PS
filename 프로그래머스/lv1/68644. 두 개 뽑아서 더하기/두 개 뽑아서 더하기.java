import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> integerSet = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                integerSet.add(numbers[i] + numbers[j]);
            }
        }

        List<Integer> integerList = new ArrayList<>(List.copyOf(integerSet));
        integerList.sort(null);

        int[] answer = new int[integerList.size()];
        for (int i = 0; i < integerList.size(); i++) {
            answer[i] = integerList.get(i);
        }

        return answer;
    }
}