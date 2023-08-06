import java.util.*;

class Solution {
boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        try {
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    stack.pop();
                }
            }
        } catch (EmptyStackException e) {
            return false;
        }

        return stack.isEmpty();
    }
}