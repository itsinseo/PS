import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] points = new int[n];

        for (int i = 0; i < n; i++) {
            points[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for (int i = n - 1; i > 0; i--) {
            if (points[i - 1] >= points[i]) {
                answer += points[i - 1] - points[i] + 1;
                points[i - 1] = points[i] - 1;
            }
        }

        System.out.println(answer);
    }
}