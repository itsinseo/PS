import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int m, n, h;
    static int[][][] tomato;
    static int[] dm = {-1, 1, 0, 0, 0, 0};
    static int[] dn = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        tomato = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        bfs();

        System.out.println(searchAllTomatoes());
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        // 큐 초기 설정
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomato[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k});
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int h0 = arr[0];
            int n0 = arr[1];
            int m0 = arr[2];
            for (int i = 0; i < 6; i++) {
                int h1 = h0 + dh[i];
                int n1 = n0 + dn[i];
                int m1 = m0 + dm[i];
                if (h1 >= 0 && h1 < h
                        && n1 >= 0 && n1 < n
                        && m1 >= 0 && m1 < m
                        && tomato[h1][n1][m1] == 0) {
                    tomato[h1][n1][m1] = tomato[h0][n0][m0] + 1;
                    queue.add(new int[]{h1, n1, m1});
                }
            }
        }
    }

    static int searchAllTomatoes() {
        int tomatoDays = 1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomato[i][j][k] == 0) {
                        return -1;
                    }
                    tomatoDays = Math.max(tomatoDays, tomato[i][j][k]);
                }
            }
        }
        return tomatoDays - 1;
    }
}