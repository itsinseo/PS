import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, i, x, y, tx, ty;
    static int[] x1 = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
    static int[] y1 = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for (int j = 0; j < n; j++) {
            i = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            tx = Integer.parseInt(st.nextToken());
            ty = Integer.parseInt(st.nextToken());

            visited = new int[i][i];

            bw.write(knight(x, y, tx, ty) + "\n");
        }

        bw.flush();
    }

    static int knight(int x, int y, int tx, int ty) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        visited[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x0 = arr[0];
            int y0 = arr[1];
            int move = arr[2];
            if (x0 == tx && y0 == ty) {
                return move;
            }

            for (int j = 0; j < x1.length; j++) {
                int nx = x0 + x1[j];
                int ny = y0 + y1[j];

                if (nx >= 0 && nx < i && ny >= 0 && ny < i && visited[nx][ny] != 1) {
                    visited[nx][ny] = 1;
                    queue.add(new int[]{nx, ny, move + 1});
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}