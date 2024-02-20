import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] array;
    static int r1, c1, maxNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int row = r2 - r1 + 1;
        int col = c2 - c1 + 1;
        array = new int[row][col];

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                fillArray(i, j);
            }
        }

        int maxLength = (int) Math.floor(Math.log10(maxNum) + 1);
        String numberFormat = "%" + maxLength + "d ";
        for (int[] arr : array) {
            for (int integer : arr) {
                System.out.printf(numberFormat, integer);
            }
            System.out.println();
        }
    }

    static void fillArray(int a, int b) {
        int m = Math.max(Math.abs(a), Math.abs(b));
        int mCalc = (1 + 2 * m) * (1 + 2 * m);

        int result = 0;
        if (a == m) {
            result = mCalc - m + b;
        } else if (b == -m) {
            result = mCalc - 3 * m + a;
        } else if (a == -m) {
            result = mCalc - 5 * m - b;
        } else if (b == m) {
            result = mCalc - 7 * m - a;
        }

        maxNum = Math.max(maxNum, result);
        array[a - r1][b - c1] = result;
    }
}