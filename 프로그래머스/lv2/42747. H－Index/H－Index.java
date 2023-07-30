import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int total = citations.length;

        Arrays.sort(citations);
        for (int i = 0; i < total; i++) {
            int number = total - i;
            int used = citations[i];
            answer = Math.min(number, used);
            if (used >= number) break;
        }

        return answer;
    }
}