class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        for (int a = i; a <= j; a++) {
            int b = a;
            while (b > 0) {
                if (b % 10 == k) answer++;
                b /= 10;
            }
        }
        
        return answer;
    }
}