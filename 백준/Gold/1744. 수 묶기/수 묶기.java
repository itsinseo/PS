import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Long> positiveList = new ArrayList<>();
        ArrayList<Long> negativeList = new ArrayList<>();
        ArrayList<Long> oneList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Long input = Long.parseLong(br.readLine());
            if (input > 0) {
                if (input == 1) {
                    oneList.add(input);
                } else {
                    positiveList.add(input);
                }
            } else {
                negativeList.add(input);
            }
        }

        positiveList.sort(Comparator.naturalOrder());
        negativeList.sort(Comparator.naturalOrder());

        Long answer = 0L;
        for (int i = positiveList.size() - 1; i > 0; i -= 2) {
            answer += positiveList.get(i) * positiveList.get(i - 1);
        }
        if (positiveList.size() % 2 == 1) {
            answer += positiveList.get(0);
        }
        for (int i = 0; i < negativeList.size() - 1; i += 2) {
            answer += negativeList.get(i) * negativeList.get(i + 1);
        }
        if (negativeList.size() % 2 == 1) {
            answer += negativeList.get(negativeList.size() - 1);
        }
        answer += oneList.size();

        System.out.println(answer);
    }
}