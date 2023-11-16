import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        String group1 = br.readLine();
        String group2 = br.readLine();
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int move = t;
        if (move >= n1 + n2 - 1) {
            move = n1 + n2 - 1;
        }

        int index2 = 0;
        while (index2 <= move - n1) {
            sb.append(group2.charAt(index2));
            index2++;
        }
        int index1 = 0;
        while (index1 < n1 - 1 - move) {
            sb.append(group1.charAt(n1 - index1 - 1));
            index1++;
        }
        for (int i = index1; i < n1; i++) {
            sb.append(group1.charAt(n1 - i - 1));
            if (index2 < n2) {
                sb.append(group2.charAt(index2));
                index2++;
            }
        }
        for (int i = index2; i < n2; i++) {
            sb.append(group2.charAt(i));
        }

        System.out.println(sb);
    }
}