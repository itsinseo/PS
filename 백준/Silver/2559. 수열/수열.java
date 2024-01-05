import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MIN_VALUE;
        int[] consecutive = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            for (int j = 0; j < k; j++) {
                consecutive[i] += arr[i + j];
            }
            answer = Math.max(answer, consecutive[i]);
        }

        System.out.println(answer);
    }
}