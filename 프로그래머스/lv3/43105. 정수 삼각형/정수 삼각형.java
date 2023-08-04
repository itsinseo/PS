import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        int[][] result = Arrays.copyOf(triangle, triangle.length);
        result[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            result[i][0] = result[i - 1][0] + triangle[i][0];

            int endpoint = triangle[i].length - 1;
            for (int j = 1; j < endpoint; j++) {
                result[i][j] = Math.max(result[i - 1][j - 1], result[i - 1][j]) + triangle[i][j];
            }
            result[i][endpoint] = result[i - 1][endpoint - 1] + triangle[i][endpoint];
        }

        int maxValue = Arrays.stream(result[result.length - 1]).max().getAsInt();

        return maxValue;
    }
}