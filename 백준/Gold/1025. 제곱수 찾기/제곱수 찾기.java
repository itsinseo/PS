import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = input.charAt(j);
                array[i][j] = c - '0';
            }
        }

        Set<Integer> integerSet = new HashSet<>();
        StringBuilder sb;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = -n + 1; k < n; k++) {
                    for (int l = -m + 1; l < m; l++) {
                        int a = i;
                        int b = j;
                        if (k == 0 && l == 0) {
                            integerSet.add(array[a][b]);
                            continue;
                        }
                        sb = new StringBuilder();
                        while (a >= 0 && a < n && b >= 0 && b < m) {
                            sb.append(array[a][b]);
                            a += k;
                            b += l;
                            integerSet.add(Integer.parseInt(sb.toString()));
                        }
                    }
                }
            }
        }

        int answer = -1;
        for (Integer integer : integerSet) {
            int sqrt = (int) Math.sqrt(integer);
            if (sqrt * sqrt == integer) {
                answer = Math.max(answer, integer);
            }
        }

        System.out.println(answer);
    }
}