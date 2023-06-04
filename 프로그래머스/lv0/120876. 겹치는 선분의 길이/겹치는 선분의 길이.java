class Solution {
    public int solution(int[][] lines) {
        int[] range = new int[201];
        for (int[] line : lines) {
            for (int i = line[0]; i < line[1]; i++) {
                range[i + 100]++;
            }
        }

        int answer = 0;
        for (int i : range) {
            if (i >= 2) {
                answer++;
            }
        }

        return answer;
    }
}