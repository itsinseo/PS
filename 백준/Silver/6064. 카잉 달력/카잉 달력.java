import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int gcd;
            if (M > N) gcd = gcd(M, N);
            else gcd = gcd(N, M);

            boolean valid = false;
            for (int j = 0; j <= N / gcd; j++) {
                int year = M * j + x - 1;
                if ((year - y + 1) % N == 0) {
                    valid = true;
                    bw.write(year + 1 + "\n");
                    break;
                }
            }

            if (!valid) bw.write(-1 + "\n");
        }

        bw.flush();
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}