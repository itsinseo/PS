import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int chonsoo = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] relations = new int[n][n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken()) - 1;
        int to = Integer.parseInt(st.nextToken()) - 1;

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            relations[x][y] = 1;
            relations[y][x] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < relations[from].length; i++) {
            if (relations[from][i] == 1) {
                queue.add(i);
            }
        }
        int[] visited = new int[n];

        dfs(from, to, 0, relations, visited);
        System.out.println(chonsoo);
    }

    public static void dfs(int from, int to, int depth, int[][] relations, int[] visited) {
        if (from == to) {
            chonsoo = depth;
            return;
        }

        visited[from] = 1;
        for (int i = 0; i < relations[from].length; i++) {
            if (relations[from][i] == 1 && visited[i] != 1) {
                dfs(i, to, depth + 1, relations, visited);
            }
        }
    }
}
