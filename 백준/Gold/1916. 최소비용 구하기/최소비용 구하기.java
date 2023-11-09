import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }

        int[] time = new int[n + 1];
        Arrays.fill(time, Integer.MAX_VALUE);

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start][end] = Math.min(graph[start][end], cost);
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        time[start] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int point = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (graph[point][i] != Integer.MAX_VALUE) {
                    if (time[point] + graph[point][i] < time[i]) {
                        time[i] = time[point] + graph[point][i];
                        queue.add(i);
                    }
                }
            }
        }

        System.out.println(time[end]);
    }
}