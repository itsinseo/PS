import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            priorityQueue.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while (priorityQueue.size() >= 2) {
            int card1 = priorityQueue.poll();
            int card2 = priorityQueue.poll();
            int newCard = card1 + card2;
            answer += newCard;
            priorityQueue.add(newCard);
        }

        System.out.println(answer);
    }
}