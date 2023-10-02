import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cardPack = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        cardPack[0] = 0;
        for (int i = 1; i <= N; i++) {
            cardPack[i] = Integer.parseInt(st.nextToken());
        }

        int[] prices = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            prices[i] = cardPack[i];
            for (int j = 1; j < i; j++) {
                prices[i] = Math.min(prices[i], prices[i - j] + cardPack[j]);
            }
        }

        System.out.println(prices[N]);
    }
}