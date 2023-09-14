import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] changes = new int[100001];
        Arrays.fill(changes, 100001);

        changes[2] = 1;
        changes[4] = 2;
        changes[5] = 1;

        for (int i = 6; i <= n; i++) {
            changes[i] = Math.min(changes[i - 2], changes[i - 5]) + 1;
        }

        if (changes[n] == 100001) changes[n] = -1;
        System.out.println(changes[n]);
    }
}
