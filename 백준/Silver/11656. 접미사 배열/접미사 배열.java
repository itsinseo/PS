import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        String[] array = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            array[i] = s.substring(i);
        }

        Arrays.sort(array);
        for (String s1 : array) {
            bw.write(s1);
            bw.write("\n");
        }

        bw.flush();
    }
}