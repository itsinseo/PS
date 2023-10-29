import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int minimumI;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        minimumI = Integer.MAX_VALUE;

        for (int i = 0; i <= b.length() - a.length(); i++) {
            int localI = 0;
            for (int j = 0; j < a.length(); j++) {
                if (b.charAt(i + j) != a.charAt(j)) localI++;
            }
            minimumI = Math.min(minimumI, localI);
        }

        System.out.println(minimumI);
    }
}