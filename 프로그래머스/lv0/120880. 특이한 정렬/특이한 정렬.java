import java.util.Arrays;

class Solution {
    public int[] solution(int[] numlist, int n) {
        double[] doubleList = new double[numlist.length];

        for (int i = 0; i < numlist.length; i++) {
            double d = numlist[i] - n;
            if (d < 0) d -= 0.1;
            doubleList[i] = Math.abs(d);
        }

        Arrays.sort(doubleList);
        // System.out.println(Arrays.toString(doubleList));

        int[] answer = new int[numlist.length];
        for (int i = 0; i < doubleList.length; i++) {
            if (doubleList[i] % 1 == 0) answer[i] = n + (int) doubleList[i];
            else answer[i] = n - (int) doubleList[i];
        }
        
        return answer;
    }
}