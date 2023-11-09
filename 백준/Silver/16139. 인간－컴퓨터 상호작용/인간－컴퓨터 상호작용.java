import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());

        int n = s.length();

        int[][] partialSum = new int[26][n];
        partialSum[s.charAt(0) - 'a'][0] = 1;

        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);
            for (int j = 0; j < 26; j++) {
                partialSum[j][i] = partialSum[j][i - 1];
            }
            partialSum[ch - 'a'][i]++;
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (l == 0) {
                bw.write(partialSum[ch - 'a'][r] + "\n");
            } else {
                bw.write(partialSum[ch - 'a'][r] - partialSum[ch - 'a'][l - 1] + "\n");
            }
        }

        bw.flush();
    }
}