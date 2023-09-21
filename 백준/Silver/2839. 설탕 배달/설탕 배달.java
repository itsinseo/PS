import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[5001];
        Arrays.fill(array, 10000);

        array[3] = 1;
        array[5] = 1;

        for (int i = 6; i <= N; i++) {
            array[i] = Math.min(array[i - 3], array[i - 5]) + 1;
        }

        if(array[N]>=10000) System.out.println(-1);
        else System.out.println(array[N]);
    }
}
