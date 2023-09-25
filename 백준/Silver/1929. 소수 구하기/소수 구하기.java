import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] eratos = new int[1000001];
        Arrays.fill(eratos, 1);
        eratos[0] = 0;
        eratos[1] = 0;

        for (int i = 2; i <= 1000; i++) {
            if (eratos[i] == 1) {
                for (int j = 2; i * j <= 1000000; j++) {
                    eratos[i * j] = 0;
                }
            }
        }

        for (int i = N; i <= M; i++) {
            if (eratos[i] == 1) System.out.println(i);
        }
    }
}