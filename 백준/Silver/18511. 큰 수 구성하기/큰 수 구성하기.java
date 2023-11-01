import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw;
    static int n;
    static int log;
    static int size;
    static int[] k;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        log = (int) Math.log10(n);
        size = Integer.parseInt(st.nextToken());
        k = new int[size];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            k[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(k);

        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int depth, int number) {
        if (number > n) return;
        if (number > answer) answer = number;
        if (depth > log) return;

        for (int i = 0; i < size; i++) {
            dfs(depth + 1, (int) (number + k[i] * Math.pow(10, depth)));
        }
    }
}