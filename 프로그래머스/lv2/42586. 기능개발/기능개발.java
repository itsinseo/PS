import java.util.*;

class Solution {
       public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> distribution = new ArrayList<>();

        // 큐 초기화
        Queue<Integer> progressQueue = new LinkedList<>();
        for (int i : progresses) {
            progressQueue.offer(i);
        }
        Queue<Integer> speedQueue = new LinkedList<>();
        for (int i : speeds) {
            speedQueue.offer(i);
        }
        int totalDays = 0;

        while (!progressQueue.isEmpty()) {
            totalDays++;
            int todayWork = 0;
            while (progressQueue.peek() + speedQueue.peek() * totalDays >= 100) {
                todayWork++;
                progressQueue.poll();
                speedQueue.poll();
                if (progressQueue.isEmpty()) break;
            }
            if (todayWork > 0) distribution.add(todayWork);
        }
        int[] answer = new int[distribution.size()];
        for (int i = 0; i < distribution.size(); i++) {
            answer[i] = distribution.get(i);
        }

        return answer;
    }
}