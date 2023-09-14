import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int front = 1;
        boolean nice = true;

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        while (!queue.isEmpty()) {
            if (queue.peek() == front) {
                queue.poll();
                front++;
            } else if (!stack.isEmpty() && stack.peek() == front) {
                stack.pop();
                front++;
            }else {
                stack.push(queue.poll());
            }
        }
        while (!stack.isEmpty()){
            if(stack.pop()==front){
                front++;
            }else {
                nice = false;
                break;
            }
        }
        if(nice) System.out.println("Nice");
        else System.out.println("Sad");

        br.close();
    }
}
