import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] colorCount;
    static int[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        colorCount = new int[2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checkPaperColor(0, 0, n);

        System.out.println(colorCount[0]);
        System.out.println(colorCount[1]);
    }

    static void checkPaperColor(int x, int y, int size) {
        int color = array[x][y];

        if (size == 1) {
            colorCount[color]++;
            return;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (array[x + i][y + j] != color) {
                    checkPaperColor(x, y, size / 2);
                    checkPaperColor(x, y + size / 2, size / 2);
                    checkPaperColor(x + size / 2, y, size / 2);
                    checkPaperColor(x + size / 2, y + size / 2, size / 2);
                    return;
                }
            }
        }

        colorCount[color]++;
    }
}
