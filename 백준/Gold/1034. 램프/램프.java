import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1034
public class Main {

    static int n, m, k;
    static String[] stool;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        stool = new String[n];
        for (int i = 0; i < n; i++) {
            String lampRow = br.readLine();
            stool[i] = lampRow;
        }
        k = Integer.parseInt(br.readLine());

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int off = 0;
            for (int j = 0; j < m; j++) {
                char lamp = stool[i].charAt(j);
                if (lamp == '0') {
                    off++;
                }
            }
            if (off <= k && (k - off) % 2 == 0) {
                int turnOnRow = 0;
                for (int j = 0; j < n; j++) {
                    if (stool[j].equals(stool[i])) {
                        turnOnRow++;
                    }
                }
                answer = Math.max(answer, turnOnRow);
            }
        }

        System.out.println(answer);
    }
}
