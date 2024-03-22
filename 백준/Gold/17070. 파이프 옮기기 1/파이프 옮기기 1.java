import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//17070
public class Main {

    static int n;
    static int[][] house;
    static int[][][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        house = new int[n][n];
        dp = new int[n][n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());
                house[i][j] = input;
            }
        }

        dp[0][1][0] = 1;
        // 최상단 행
        for (int i = 2; i < n; i++) {
            if (house[0][i] != 1) {
                dp[0][i][0] = dp[0][i - 1][0];
            }
        }

        // dp[열][행][파이프방향], { 0: 가로, 1: 세로, 2: 대각선 }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (house[i][j] != 1) {
                    dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][2];
                    dp[i][j][1] += dp[i - 1][j][1] + dp[i - 1][j][2];
                    if (house[i - 1][j] == 0 && house[i][j - 1] == 0) {
                        dp[i][j][2] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                    }
                }
            }
        }

        System.out.println(dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2]);
    }
}
