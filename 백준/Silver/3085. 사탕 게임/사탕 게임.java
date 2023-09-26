import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사탕 판 초기화
        int N = Integer.parseInt(br.readLine());
        char[][] candies = new char[N][N];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                candies[i][j] = row.charAt(j);
            }
        }

        // 바꾸기 전에 최대 개수 구하기: 문제에 명시 되어 있지 않음..
        int answer = 0;
        answer = Math.max(answer, checkMax(candies));
        answer = Math.max(answer, checkMax(candies));

        // 가로 바꾸기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                char left = candies[i][j];
                char right = candies[i][j + 1];
                if (left != right) {
                    candies[i][j + 1] = left;
                    candies[i][j] = right;

                    answer = Math.max(answer, checkMax(candies));
                    answer = Math.max(answer, checkMax(candies));

                    candies[i][j + 1] = right;
                    candies[i][j] = left;
                }
            }
        }

        // 세로 바꾸기
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                char up = candies[i][j];
                char down = candies[i + 1][j];
                if (up != down) {
                    candies[i + 1][j] = up;
                    candies[i][j] = down;

                    answer = Math.max(answer, checkMax(candies));
                    answer = Math.max(answer, checkMax(candies));

                    candies[i + 1][j] = down;
                    candies[i][j] = up;
                }
            }
        }

        System.out.println(answer);
    }

    private static int checkMax(char[][] candies) {
        int max = 0;
        int N = candies.length;

        for (int i = 0; i < N; i++) {
            int count = 0;
            char ch = ' ';

            for (int j = 0; j < N; j++) {
                if (ch != candies[i][j]) {
                    max = Math.max(max, count);
                    count = 0;
                    ch = candies[i][j];
                }
                count++;
            }
            max = Math.max(max, count);
        }

        for (int j = 0; j < N; j++) {
            int count = 0;
            char ch = ' ';

            for (int i = 0; i < N; i++) {
                if (ch != candies[i][j]) {
                    max = Math.max(max, count);
                    count = 0;
                    ch = candies[i][j];
                }
                count++;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}