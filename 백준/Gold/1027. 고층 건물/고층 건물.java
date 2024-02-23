import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, answer;
    static int[] buildings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        buildings = new int[n];
        answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            countVisibleBuildings(i);
        }

        System.out.println(answer);
    }

    private static void countVisibleBuildings(int start) {
        int count = 0;
        double minusGradient = Double.MAX_VALUE;
        double plusGradient = -Double.MAX_VALUE;
        int index = start - 1;
        while (index >= 0) {
            double currentGradient = (double) (buildings[start] - buildings[index]) / (start - index);
            if (currentGradient < minusGradient) {
                minusGradient = currentGradient;
                count++;
            }
            index--;
        }

        index = start + 1;
        while (index < n) {
            double currentGradient = (double) (buildings[index] - buildings[start]) / (index - start);
            if (currentGradient > plusGradient) {
                plusGradient = currentGradient;
                count++;
            }
            index++;
        }
        answer = Math.max(answer, count);
    }
}