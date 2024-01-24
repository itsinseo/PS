import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, k, l, headRow, headCol, direction, directionChangedTime, totalTime;
    static boolean[][] appleArray, snakeArray;
    static int[] rowMovement = {0, 1, 0, -1};
    static int[] colMovement = {1, 0, -1, 0};
    static Queue<int[]> snake;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        snake = new LinkedList<>();

        headRow = 0;
        headCol = 0;
        direction = 0;
        directionChangedTime = 0;
        totalTime = 0;

        snake.offer(new int[]{0, 0});

        n = Integer.parseInt(br.readLine());
        appleArray = new boolean[n][n];
        snakeArray = new boolean[n][n];

        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int appleRow = Integer.parseInt(st.nextToken()) - 1;
            int appleCol = Integer.parseInt(st.nextToken()) - 1;
            appleArray[appleRow][appleCol] = true;
        }

        l = Integer.parseInt(br.readLine());

        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            if (!moveAndChangeDirectionSnake(x - directionChangedTime, c)) {
                System.out.println(totalTime);
                return;
            }
            directionChangedTime = x;
        }

        moveAndIsStuckSnake(n);
        System.out.println(totalTime);
    }

    static boolean moveAndChangeDirectionSnake(int x, String c) {
        if (moveAndIsStuckSnake(x)) return false;
        if (c.equals("D")) {
            direction = (direction + 1) % 4;
        } else if (c.equals("L")) {
            direction = (direction + 4 - 1) % 4;
        }

        return true;
    }

    private static boolean moveAndIsStuckSnake(int x) {
        for (int i = 0; i < x; i++) {
            totalTime++;
            int nextRow = headRow + rowMovement[direction];
            int nextCol = headCol + colMovement[direction];

            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
                return true;
            } else if (snakeArray[nextRow][nextCol]) {
                return true;
            } else {
                snake.offer(new int[]{nextRow, nextCol});
                snakeArray[nextRow][nextCol] = true;
                if (appleArray[nextRow][nextCol]) {
                    appleArray[nextRow][nextCol] = false;
                } else {
                    int[] tailLocation = snake.poll();
                    assert tailLocation != null;
                    int tailRow = tailLocation[0];
                    int tailCol = tailLocation[1];
                    snakeArray[tailRow][tailCol] = false;
                }
                headRow = nextRow;
                headCol = nextCol;
            }
        }
        return false;
    }
}