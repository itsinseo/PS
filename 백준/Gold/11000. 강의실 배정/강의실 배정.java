import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        List<int[]> lectureList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            lectureList.add(new int[]{s, t});
        }

        Comparator<int[]> comparator = (arr1, arr2) -> {
            int start = Integer.compare(arr1[0], arr2[0]);
            if (start != 0) {
                return start;
            }
            return Integer.compare(arr2[1] - arr2[0], arr1[1] - arr1[0]);
        };

        Collections.sort(lectureList, comparator);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(lectureList.get(0)[1]);

        for (int i = 1; i < n; i++) {
            if (lectureList.get(i)[0] >= priorityQueue.peek()) {
                priorityQueue.poll();
            }
            priorityQueue.add(lectureList.get(i)[1]);
        }

        System.out.println(priorityQueue.size());
    }
}