import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] countACGT = new char[m][4];

        for (int i = 0; i < n; i++) {
            String inputDna = br.readLine();
            for (int j = 0; j < m; j++) {
                char DNA = inputDna.charAt(j);
                switch (DNA) {
                    case 'A':
                        countACGT[j][0]++;
                        break;
                    case 'C':
                        countACGT[j][1]++;
                        break;
                    case 'G':
                        countACGT[j][2]++;
                        break;
                    case 'T':
                        countACGT[j][3]++;
                        break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int hammingDistance = 0;
        for (int i = 0; i < m; i++) {
            int maxCount = 0;
            int maxIndex = 0;
            for (int j = 0; j < 4; j++) {
                if (countACGT[i][j] > maxCount) {
                    maxCount = countACGT[i][j];
                    maxIndex = j;
                }
            }
            hammingDistance += n - maxCount;
            switch (maxIndex) {
                case 0:
                    sb.append("A");
                    break;
                case 1:
                    sb.append("C");
                    break;
                case 2:
                    sb.append("G");
                    break;
                case 3:
                    sb.append("T");
                    break;
            }
        }

        System.out.println(sb);
        System.out.println(hammingDistance);
    }
}