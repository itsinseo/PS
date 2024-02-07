import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int m = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        int R = sc.nextInt();

        int exerciseTime = 0;
        int totalTime = 0;
        int pulse = m;

        if (m + T > M) {
            System.out.println(-1);
        } else {
            while (exerciseTime < N) {
                if (pulse + T <= M) {
                    pulse += T;
                    exerciseTime++;
                } else {
                    pulse -= R;
                    pulse = Math.max(pulse, m);
                }
                totalTime++;
            }

            System.out.println(totalTime);
        }
    }
}