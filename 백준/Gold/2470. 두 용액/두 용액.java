import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            list.add(input);
        }

        Collections.sort(list);
        int start = 0;
        int end = list.size() - 1;

        int answer1 = list.get(start);
        int answer2 = list.get(end);
        int sum = Math.abs(answer1 + answer2);

        while (start < end) {
            int num1 = list.get(start);
            int num2 = list.get(end);
            int tempSum = num1 + num2;
            if (Math.abs(tempSum) < sum) {
                answer1 = num1;
                answer2 = num2;
                sum = Math.abs(tempSum);
            }
            if (tempSum > 0) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(answer1 + " " + answer2);
    }
}