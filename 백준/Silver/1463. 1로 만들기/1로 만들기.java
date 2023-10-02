import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[1000001];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= 1000000; i++) {
            int case1 = i % 3 == 0 ? dp[i / 3] : 1000000;
            int case2 = i % 2 == 0 ? dp[i / 2] : 1000000;
            int case3 = dp[i - 1];

            dp[i] = Math.min(Math.min(case1, case2) + 1, case3 + 1);
        }

        int N = Integer.parseInt(br.readLine());
        System.out.println(dp[N]);
    }
}