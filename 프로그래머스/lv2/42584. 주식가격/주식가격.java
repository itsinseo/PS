import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Arrays.fill(answer, 0);
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();

        stack.push(prices[0]);
        indexStack.push(0);

        for (int i = 1; i < prices.length; i++) {
            // 가격이 떨어지지 않은 시간 더하기
            for (Integer j : indexStack) {
                answer[j]++;
            }

            // 이번 가격 기준으로 가격 떨어짐 판단하기
            int todayPrice = prices[i];

            while (!stack.isEmpty()) {
                if (stack.peek() > prices[i]) {
                    stack.pop();
                    indexStack.pop();
                }
                else break;
            }
            stack.push(todayPrice);
            indexStack.push(i);
        }

        return answer;
    }
}