import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String a, b;
        int n = Integer.parseInt(br.readLine());

        Set<String> stringSet = new HashSet<>();
        stringSet.add("ChongChong");
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = st.nextToken();
            b = st.nextToken();
            if (stringSet.contains(a) || stringSet.contains(b)) {
                stringSet.add(a);
                stringSet.add(b);
            }
        }

        System.out.println(stringSet.size());
    }
}