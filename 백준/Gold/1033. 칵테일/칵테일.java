import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1033
public class Main {

    static int n;
    static int[] materials;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        materials = new int[n];
        Arrays.fill(materials, 1);
        graph = new int[n][n];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            cocktail(a, b, p, q);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(materials[i] + " ");
        }
    }

    static void cocktail(int a, int b, int p, int q) {
        int gcd = gcd(p, q);
        p /= gcd;
        q /= gcd;

        int factorA = materials[b] * p;
        int factorB = materials[a] * q;
        int factorGcd = gcd(factorA, factorB);

        factorA /= factorGcd;
        factorB /= factorGcd;

        bfs(factorA, a, b);
        bfs(factorB, b, a);

        graph[a][b] = 1;
        graph[b][a] = 1;
    }

    private static void bfs(int factor, int a, int b) {
        int[] checked = new int[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        checked[a] = 1;

        while (!queue.isEmpty()) {
            int index = queue.poll();
            materials[index] *= factor;
            for (int i = 0; i < n; i++) {
                if (checked[i] == 0 && graph[index][i] == 1) {
                    queue.add(i);
                    checked[index] = 1;
                }
            }
        }
    }

    static int gcd(int p, int q) {
        int temp = q;
        q = Math.min(p, q);
        p = Math.max(temp, p);

        int r = 0;
        while (q > 0) {
            r = p % q;
            p = q;
            q = r;
        }

        return p;
    }
}
