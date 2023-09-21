import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 64;

        String[] array = new String[N];

        for (int i = 0; i < N; i++) {
            array[i] = br.readLine();
        }

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                int count = 0;
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        char target = array[i + k].charAt(j + l);

                        if ((k + l) % 2 == 0 && target == 'W') count++;
                        else if ((k + l) % 2 == 1 && target == 'B') count++;
                    }
                }
                count = Math.min(count, 64-count);

                answer = Math.min(count, answer);
            }
        }

        System.out.println(answer);
    }
}
