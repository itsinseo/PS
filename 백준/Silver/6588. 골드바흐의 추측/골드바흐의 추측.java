import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] eratos = new int[1000001];
        Arrays.fill(eratos, 1);
        eratos[0] = 0;
        eratos[1] = 0;

        List<Integer> primeList = new ArrayList<>();

        for (int i = 2; i <= 1000; i++) {
            if (eratos[i] == 1) {
                primeList.add(i);
                for (int j = 2; i * j <= 1000000; j++) {
                    eratos[i * j] = 0;
                }
            }
        }

        while (true) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) break;

            boolean goldbach = false;

            for (int prime : primeList) {
                if (eratos[input - prime] == 1) {
                    System.out.println(input + " = " + prime + " + " + (input - prime));
                    goldbach = true;
                    break;
                }
            }

            if (!goldbach) {
                System.out.println("Goldbach's conjecture is wrong.");
                break;
            }
        }
    }
}