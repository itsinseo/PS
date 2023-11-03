import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k + 1];
        Set<Integer> coinSet = new HashSet<>();
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            if (coin <= k) {
                dp[coin] = 1;
                coinSet.add(coin);
            }
        }

        for (Integer coin : coinSet) {
            for (int i = coin + 1; i <= k; i++) {
                dp[i] = Math.min(dp[i - coin], dp[i] - 1) + 1;
            }
        }

        if (dp[k] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}