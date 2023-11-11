import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        list = new ArrayList[10];

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            build();
        }
        bw.flush();
    }

    static void build() throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n + 1][n + 1];
        int[] child = new int[n + 1];
        int[] delay = new int[n + 1];
        int[] totalCost = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            delay[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            child[y]++;
        }

        int w = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (child[i] == 0) {
                totalCost[i] = delay[i];
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int start = queue.poll();
            for (int end = 1; end <= n; end++) {
                if (graph[start][end] == 1) {
                    totalCost[end] = Math.max(totalCost[end], totalCost[start] + delay[end]);
                    child[end]--;
                    if (child[end] == 0) {
                        queue.offer(end);
                    }
                }
            }
        }
        bw.write(totalCost[w] + "\n");
    }
}