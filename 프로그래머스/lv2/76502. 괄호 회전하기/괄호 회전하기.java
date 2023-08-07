import java.util.*;

class Solution {
    public boolean isCorrectArray(Queue<Character> queue) {
        Stack<Character> stack = new Stack<>();
        for (Character c : queue) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                try {
                    Character popped = stack.pop();
                    if ((popped == '(' && c != ')') || (popped == '{' && c != '}') || (popped == '[' && c != ']')) {
                        return false;
                    }
                } catch (EmptyStackException e) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public int solution(String s) {
        int answer = 0;
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            if (isCorrectArray(queue)) answer++;
            queue.add(queue.poll());
        }

        return answer;
    }
}
