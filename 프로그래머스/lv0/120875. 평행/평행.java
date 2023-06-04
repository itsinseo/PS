class Solution {
    public int solution(int[][] dots) {
        for (int i = 1; i < dots.length; i++) {
            double d1 = (double) (dots[0][1] - dots[i][1]) / (dots[0][0] - dots[i][0]);
            double d2 = (double) (dots[i % 3 + 1][1] - dots[(i + 1) % 3 + 1][1]) / (dots[i % 3 + 1][0] - dots[(i + 1) % 3 + 1][0]);

            if (d1 == d2) return 1;
        }
        
        return 0;
    }
}