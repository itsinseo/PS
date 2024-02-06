import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());

        int[] array = new int[l];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < l; i++) {
            int input = Integer.parseInt(st.nextToken());
            array[i] = input;
        }

        int n = Integer.parseInt(br.readLine());

        int start = 0;
        int end = 1001;

        for (Integer integer : array) {
            if (integer <= n) {
                start = Math.max(start, integer);
            }
            if (integer >= n) {
                end = Math.min(end, integer);
            }
        }

        int answer = (n - start) * (end - n) - 1;
        System.out.println(answer == -1 ? 0 : answer);
    }
}