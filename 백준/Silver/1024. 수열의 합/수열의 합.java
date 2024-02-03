import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] fibonacci = fibonacci();

        // start from zero
        if (n == fibonacci[l - 1]) {
            for (int i = 0; i < l; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        int answer = -1;
        int count = l;
        while (count < 101) {
            int localSum = fibonacci[count];
            if (localSum > n) {
                break;
            } else if ((n - localSum) % count == 0) {
                answer = (n - localSum) / count;
                break;
            } else {
                count++;
            }
        }

        if (answer == -1) {
            System.out.println(answer);
        } else {
            for (int i = 1; i < count + 1; i++) {
                System.out.print(i + answer + " ");
            }
            System.out.println();
        }
    }

    static int[] fibonacci() {
        int[] array = new int[101];
        array[1] = 1;
        for (int i = 2; i < 101; i++) {
            array[i] = array[i - 1] + i;
        }
        return array;
    }
}