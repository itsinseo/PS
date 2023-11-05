import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        // dp[n][0]: A의 개수, dp[n][1]: B의 개수
        int[][] dp = new int[46][2];
        dp[0][0] = 1;
        dp[0][1] = 0;

        for (int i = 1; i <= K; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][1] + dp[i - 1][0];
        }

        System.out.println(dp[K][0] + " " + dp[K][1]);
    }
}