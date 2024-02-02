import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[][] office;
    static ArrayList<Cctv> cctvList;
    static int n, m, targetDepth, answer;

    static class Cctv {
        public int type;
        public int x;
        public int y;

        public Cctv(int type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        office = new int[n][m];
        cctvList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                office[i][j] = input;
                if (input >= 1 && input <= 5) {
                    cctvList.add(new Cctv(input, i, j));
                }
            }
        }

        answer = n * m;
        targetDepth = cctvList.size();
        turnCctv(0);

        System.out.println(answer);
    }

    static void turnCctv(int currentDepth) {
        if (currentDepth == targetDepth) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int box = office[i][j];
                    if (box == 0) {
                        count++;
                    }
                }
            }
            answer = Math.min(answer, count);
            return;
        }

        Cctv cctv = cctvList.get(currentDepth);

        switch (cctv.type) {
            case 1:
                cctv1(cctv.x, cctv.y, currentDepth);
                break;
            case 2:
                cctv2(cctv.x, cctv.y, currentDepth);
                break;
            case 3:
                cctv3(cctv.x, cctv.y, currentDepth);
                break;
            case 4:
                cctv4(cctv.x, cctv.y, currentDepth);
                break;
            case 5:
                cctv5(cctv.x, cctv.y, currentDepth);
                break;
        }
    }

    static void cctv1(int x, int y, int currentDepth) {

        upOn(x, y);
        turnCctv(currentDepth + 1);

        upOff(x, y);
        rightOn(x, y);
        turnCctv(currentDepth + 1);

        rightOff(x, y);
        downOn(x, y);
        turnCctv(currentDepth + 1);

        downOff(x, y);
        leftOn(x, y);
        turnCctv(currentDepth + 1);

        leftOff(x, y);
    }

    static void cctv2(int x, int y, int currentDepth) {

        rightOn(x, y);
        leftOn(x, y);
        turnCctv(currentDepth + 1);

        rightOff(x, y);
        leftOff(x, y);
        upOn(x, y);
        downOn(x, y);
        turnCctv(currentDepth + 1);

        upOff(x, y);
        downOff(x, y);
    }

    static void cctv3(int x, int y, int currentDepth) {

        upOn(x, y);
        rightOn(x, y);
        turnCctv(currentDepth + 1);

        upOff(x, y);
        downOn(x, y);
        turnCctv(currentDepth + 1);

        rightOff(x, y);
        leftOn(x, y);
        turnCctv(currentDepth + 1);

        downOff(x, y);
        upOn(x, y);
        turnCctv(currentDepth + 1);

        leftOff(x, y);
        upOff(x, y);
    }

    static void cctv4(int x, int y, int currentDepth) {

        leftOn(x, y);
        upOn(x, y);
        rightOn(x, y);
        turnCctv(currentDepth + 1);

        leftOff(x, y);
        downOn(x, y);
        turnCctv(currentDepth + 1);

        upOff(x, y);
        leftOn(x, y);
        turnCctv(currentDepth + 1);

        rightOff(x, y);
        upOn(x, y);
        turnCctv(currentDepth + 1);

        downOff(x, y);
        leftOff(x, y);
        upOff(x, y);
    }

    static void cctv5(int x, int y, int currentDepth) {
        leftOn(x, y);
        upOn(x, y);
        rightOn(x, y);
        downOn(x, y);
        turnCctv(currentDepth + 1);

        leftOff(x, y);
        upOff(x, y);
        rightOff(x, y);
        downOff(x, y);
    }

    private static void leftOff(int x, int y) {
        // left, off
        int y2 = y - 1;
        while (y2 >= 0 && office[x][y2] != 6) {
            if (office[x][y2] <= -1) {
                office[x][y2]++;
            }
            y2--;
        }
    }

    private static void leftOn(int x, int y) {
        // left, on
        int y2 = y - 1;
        while (y2 >= 0 && office[x][y2] != 6) {
            if (office[x][y2] <= 0) {
                office[x][y2]--;
            }
            y2--;
        }
    }

    private static void downOff(int x, int y) {
        // down, off
        int x2 = x + 1;
        while (x2 < n && office[x2][y] != 6) {
            if (office[x2][y] <= -1) {
                office[x2][y]++;
            }
            x2++;
        }
    }

    private static void downOn(int x, int y) {
        // down, on
        int x2 = x + 1;
        while (x2 < n && office[x2][y] != 6) {
            if (office[x2][y] <= 0) {
                office[x2][y]--;
            }
            x2++;
        }
    }

    private static void rightOff(int x, int y) {
        // right, off
        int y1 = y + 1;
        while (y1 < m && office[x][y1] != 6) {
            if (office[x][y1] <= -1) {
                office[x][y1]++;
            }
            y1++;
        }
    }

    private static void rightOn(int x, int y) {
        // right, on
        int y1 = y + 1;
        while (y1 < m && office[x][y1] != 6) {
            if (office[x][y1] <= 0) {
                office[x][y1]--;
            }
            y1++;
        }
    }

    private static void upOff(int x, int y) {
        // up, off
        int x1 = x - 1;
        while (x1 >= 0 && office[x1][y] != 6) {
            if (office[x1][y] <= -1) {
                office[x1][y]++;
            }
            x1--;
        }
    }

    private static void upOn(int x, int y) {
        // up, on
        int x1 = x - 1;
        while (x1 >= 0 && office[x1][y] != 6) {
            if (office[x1][y] <= 0) {
                office[x1][y]--;
            }
            x1--;
        }
    }
}