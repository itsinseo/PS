import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static double answer;
    static int[][] inputArray;
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            answer = Double.MAX_VALUE;
            getVectorInput();
        }

        bw.flush();
        bw.close();
    }

    static void getVectorInput() throws IOException {
        int n = Integer.parseInt(br.readLine());

        inputArray = new int[n][2];

        int totalX = 0;
        int totalY = 0;

        for (int j = 0; j < n; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            inputArray[j][0] = x;
            inputArray[j][1] = y;

            totalX += x;
            totalY += y;
        }

        dfs(0, n, 0, totalX, totalY);

        bw.write(answer + "\n");
    }

    static void dfs(int depth, int n, int index, int x, int y) {
        if (depth == n / 2) {
            double vectorSum = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            answer = Math.min(answer, vectorSum);
        }

        for (int i = index; i < n; i++) {
            dfs(depth + 1, n, i + 1, x - 2 * inputArray[i][0], y - 2 * inputArray[i][1]);
        }
    }
}