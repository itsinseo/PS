import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cut = (int) Math.round(n * 0.15);

        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            integerList.add(Integer.parseInt(br.readLine()));
        }

        integerList.sort(null);

        int sum = 0;
        for (int i = cut; i < n - cut; i++) {
            sum += integerList.get(i);
        }
        System.out.println(Math.round((float) sum / (n - cut * 2)));

        br.close();
    }
}
