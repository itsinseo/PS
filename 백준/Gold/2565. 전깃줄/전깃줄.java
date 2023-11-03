import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int n;
    static int[] dp;
    static int[][] lines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n];
        lines = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lines[i][0] = a;
            lines[i][1] = b;
        }

        Arrays.sort(lines, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int survived = 1;

        for (int i = 0; i < n; i++) {
            survived = Math.max(survived, recursive(i));
        }

        System.out.println(n - survived);
    }

    static int recursive(int index) {
        if (dp[index] == 0) {
            dp[index] = 1;

            for (int i = index + 1; i < n; i++) {
                if (lines[i][1] > lines[index][1]) {
                    dp[index] = Math.max(dp[index], recursive(i) + 1);
                }
            }
        }

        return dp[index];
    }
}