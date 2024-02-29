import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int count = 0;
        int length = (int) Math.pow(2, n);

        while (length > 1) {
            if (r < length / 2) {
                if (c < length / 2) {
                    count += 0;
                } else if (c >= length / 2) {
                    count += length * length / 4;
                    c -= length / 2;
                }
            } else if (r >= length / 2) {
                if (c < length / 2) {
                    count += length * length / 4 * 2;
                } else if (c >= length / 2) {
                    count += length * length / 4 * 3;
                    c -= length / 2;
                }
                r -= length / 2;
            }
            length /= 2;
        }

        System.out.println(count);
    }
}
