import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<String> arrayList = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'A');
            map.put(c, 0);
        }

        for (int i = 0; i < n; i++) {
            arrayList.add(br.readLine());
        }

        for (String word : arrayList) {
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(word.length() - 1 - j);
                map.put(c, (int) (map.get(c) + Math.pow(10, j)));
            }
        }

        int answer = 0;

        PriorityQueue<Character> priorityQueue = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        priorityQueue.addAll(map.keySet());

        for (int i = 0; i < 10; i++) {
            Character c = priorityQueue.poll();
            int multiplier = map.get(c);
            if (multiplier == 0) {
                break;
            }
            answer += multiplier * (9 - i);
        }

        System.out.println(answer);
    }
}