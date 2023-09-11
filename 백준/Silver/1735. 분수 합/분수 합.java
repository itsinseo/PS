import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int top = a1 * b2 + a2 * b1;
        int bottom = b1 * b2;

        int gcd;
        if (top >= bottom) {
            gcd = gcd(top, bottom);
        } else {
            gcd = gcd(bottom, top);
        }
        
        bw.write(top / gcd + " " + bottom / gcd + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
