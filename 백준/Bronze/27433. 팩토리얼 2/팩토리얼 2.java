import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long answer = 1;

        if (N == 0 || N == 1) {
            System.out.println(answer);
        } else {
            for (int i = 2; i <= N; i++) {
                answer *= i;
            }
            System.out.println(answer);
        }
    }
}
