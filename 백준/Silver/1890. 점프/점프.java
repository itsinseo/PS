import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, answer;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = 0;

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[n][n];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int dist = graph[i][j];
                if (dist==0) continue;

                if (i + dist < n) {
                    dp[i + dist][j] += dp[i][j];
                }
                if (j + dist < n) {
                    dp[i][j + dist] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }
}