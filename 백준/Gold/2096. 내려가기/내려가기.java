import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] array, maxDp, minDp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        array = new int[n][3];
        maxDp = new int[n][3];
        minDp = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        maxDp[0][0] = array[0][0];
        maxDp[0][1] = array[0][1];
        maxDp[0][2] = array[0][2];

        for (int i = 1; i < n; i++) {
            maxDp[i][0] = Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + array[i][0];
            maxDp[i][1] = Math.max(Math.max(maxDp[i - 1][0], maxDp[i - 1][1]), maxDp[i - 1][2]) + array[i][1];
            maxDp[i][2] = Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + array[i][2];
        }

        minDp[0][0] = array[0][0];
        minDp[0][1] = array[0][1];
        minDp[0][2] = array[0][2];

        for (int i = 1; i < n; i++) {
            minDp[i][0] = Math.min(minDp[i - 1][0], minDp[i - 1][1]) + array[i][0];
            minDp[i][1] = Math.min(Math.min(minDp[i - 1][0], minDp[i - 1][1]), minDp[i - 1][2]) + array[i][1];
            minDp[i][2] = Math.min(minDp[i - 1][1], minDp[i - 1][2]) + array[i][2];
        }

        int maxNumber = Math.max(Math.max(maxDp[n - 1][0], maxDp[n - 1][1]), maxDp[n - 1][2]);
        int minNumber = Math.min(Math.min(minDp[n - 1][0], minDp[n - 1][1]), minDp[n - 1][2]);
        System.out.printf("%d %d", maxNumber, minNumber);
    }
}
