import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 10000);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int move = arr[i];
            for (int j = 1; j <= move; j++) {
                if (i + j >= n) break;
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }

        System.out.println(dp[n - 1] == 10000 ? -1 : dp[n - 1]);
    }
}