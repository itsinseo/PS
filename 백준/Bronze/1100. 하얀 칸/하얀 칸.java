import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        for (int i = 0; i < 8; i++) {
            String row = br.readLine();
            for (int j = 0; j < 8; j++) {
                if (row.charAt(j) == 'F' && (i + j) % 2 == 0) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}