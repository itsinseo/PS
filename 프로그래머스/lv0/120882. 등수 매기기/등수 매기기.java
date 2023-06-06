import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        ArrayList<Integer> reverse = new ArrayList<>();
        for (int[] i : score) {
            reverse.add(Arrays.stream(i).sum());
        }

        ArrayList<Integer> sum = new ArrayList<>(List.copyOf(reverse));
        reverse.sort(Comparator.reverseOrder());

        // System.out.println("reverse: " + reverse.toString());
        // System.out.println("sum: " + sum.toString());

        int[] answer = new int[score.length];
        for (int i = 0; i < sum.size(); i++) {
            answer[i] = reverse.indexOf(sum.get(i)) + 1;
        }
        
        return answer;
    }
}