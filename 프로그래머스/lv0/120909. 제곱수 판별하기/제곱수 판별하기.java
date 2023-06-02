class Solution {
    public int solution(int n) {
        int answer = 2;
        double root = Math.sqrt(n);
        // double root = Math.pow(n, 0.5);
        if (root % 1 == 0) answer = 1;
        return answer;
    }
}