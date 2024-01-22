import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int r, c, globalMax;
    static Set<Character> set;
    static char[][] array;
    static int[] x0 = {1, -1, 0, 0};
    static int[] y0 = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        set = new HashSet<>();
        array = new char[r][c];

        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                char c1 = row.charAt(j);
                array[i][j] = c1;
            }
        }

        globalMax = 1;
        set.add(array[0][0]);
        dfs(1, 0, 0);

        System.out.println(globalMax);
    }

    static void dfs(int depth, int x, int y) {
        globalMax = Math.max(globalMax, depth);
        for (int i = 0; i < 4; i++) {
            int x1 = x + x0[i];
            int y1 = y + y0[i];
            if (x1 >= 0 && x1 < r && y1 >= 0 && y1 < c) {
                char nextChar = array[x1][y1];
                if (!set.contains(nextChar)) {
                    set.add(nextChar);
                    dfs(depth + 1, x1, y1);
                    set.remove(nextChar);
                }
            }
        }
    }
}