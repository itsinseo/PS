class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for (int i : array) {
            while (i > 0) {
                if (i % 10 == 7) answer++;
                i /= 10;
            }
        }
        return answer;
    }
}