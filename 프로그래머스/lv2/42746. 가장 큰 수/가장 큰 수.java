import java.util.*;

class Solution {
    public String[] intArrToStrArr(int[] numbers) {
        return Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
    }

    public String solution(int[] numbers) {
        String[] stringNumbers = intArrToStrArr(numbers);

        Arrays.sort(stringNumbers, (s1, s2)-> (s1+s2).compareTo(s2+s1));

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = stringNumbers.length - 1; i >= 0; i--) {
            stringBuilder.append(stringNumbers[i]);
        }
        
        String answer = stringBuilder.toString();
        
        if(answer.charAt(0)=='0'){
            return "0";
        }

        return answer;
    }
}