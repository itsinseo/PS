import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[][] friends = new boolean[n][n];
        char[][] graph = new char[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = input.charAt(j);
            }
        }

        int globalMax = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                if (graph[i][j] == 'Y') {
                    friends[i][j] = true;
                    for (int k = 0; k < n; k++) {
                        if (graph[j][k] == 'Y' && k != i) {
                            friends[i][k] = true;
                        }
                    }
                }
            }

            int count = 0;
            for (int j = 0; j < n; j++) {
                if (friends[i][j]) {
                    count++;
                }
            }
            globalMax = Math.max(globalMax, count);
        }

        System.out.println(globalMax);
    }
}