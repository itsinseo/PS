import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, v;
    static StringBuilder sb;
    static int[][] graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start][end] = 1;
            graph[end][start] = 1;
        }

        visited = new int[n + 1];
        sb = new StringBuilder();
        dfs(v);
        System.out.println(sb);

        bfs();
    }

    static void dfs(int point) {
        visited[point] = 1;
        sb.append(point);
        sb.append(" ");

        for (int i = 1; i <= n; i++) {
            if (graph[point][i] == 1 && visited[i] != 1) {
                dfs(i);
            }
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visited = new int[n + 1];
        sb = new StringBuilder();

        // 출발점
        queue.add(v);
        visited[v] = 1;

        while (!queue.isEmpty()) {
            int point = queue.poll();
            sb.append(point);
            sb.append(" ");

            for (int i = 1; i <= n; i++) {
                if (graph[point][i] == 1 && visited[i] != 1) {
                    visited[i] = 1;
                    queue.add(i);
                }
            }
        }

        System.out.println(sb);
    }
}