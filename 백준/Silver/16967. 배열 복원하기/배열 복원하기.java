import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int h, w, x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        int[][] b = new int[h + x][w + y];
        for (int i = 0; i < h + x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w + y; j++) {
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] a = new int[h][w];
        // 윗줄 중 안 겹치는 부분
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < w; j++) {
                a[i][j] = b[i][j];
            }
        }

        // 아랫줄 중 안 겹치는 부분
        for (int i = h; i < h + x; i++) {
            for (int j = y; j < y + w; j++) {
                a[i - x][j - y] = b[i][j];
            }
        }

        // 왼쪽 줄 중 안 겹치는 부분
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < y; j++) {
                a[i][j] = b[i][j];
            }
        }

        // 오른쪽 줄 중 안 겹치는 부분
        for (int i = x; i < x + h; i++) {
            for (int j = w; j < y + w; j++) {
                a[i - x][j - y] = b[i][j];
            }
        }

        // 겹친 부분 원래 숫자 구하기
        for (int i = x; i < h; i++) {
            for (int j = y; j < w; j++) {
                a[i][j] = b[i][j] - a[i - x][j - y];
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                bw.write("" + a[i][j]);
                bw.write(" ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}