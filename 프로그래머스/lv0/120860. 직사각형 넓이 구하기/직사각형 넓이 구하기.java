class Solution {
    public int solution(int[][] dots) {
        int xMax = -256;
        int xMin = 256;
        int yMax = -256;
        int yMin = 256;

        for (int[] arr : dots) {
            xMax = Math.max(xMax, arr[0]);
            xMin = Math.min(xMin, arr[0]);
            yMax = Math.max(yMax, arr[1]);
            yMin = Math.min(yMin, arr[1]);
        }
        
        return (xMax - xMin) * (yMax - yMin);
    }
}