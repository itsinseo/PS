import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Set<Integer> integerSet = new HashSet<>();

        int answer = 0;

        for (int number : numbers) {
            integerSet.add(number);
        }
        for (int i = 0; i <= 9; i++) {
            if (!integerSet.contains(i)) answer += i;
        }

        return answer;
    }
}