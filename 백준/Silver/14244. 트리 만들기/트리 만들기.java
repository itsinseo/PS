import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.println("0 1");

        for (int i = 2; i < m + 1; i++) {
            System.out.println("1 " + i);
        }

        for (int i = m; i < n - 1; i++) {
            System.out.println(i + " " + (i + 1));
        }
    }
}
