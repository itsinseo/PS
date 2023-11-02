import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                array[i][j] = s.charAt(j);
            }
        }

        System.out.println(getAnswer(n, m, array));
    }

    private static int getAnswer(int n, int m, int[][] array) {
        int answer = 1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                int k = 1;
                while (i + k < n && j + k < m) {
                    if (array[i][j] == array[i + k][j]
                            && array[i][j] == array[i][j + k]
                            && array[i][j] == array[i + k][j + k]) {
                        answer = Math.max(answer, (k + 1) * (k + 1));
                    }
                    k++;
                }
            }
        }
        return answer;
    }
}