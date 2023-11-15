import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Jewel {
        public int weight;
        public int price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Jewel> jewelList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewelList.add(new Jewel(m, v));
        }

        List<Integer> bagList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            bagList.add(Integer.parseInt(br.readLine()));
        }

        jewelList.sort((j1, j2) -> {
            int compare = j1.weight - j2.weight;
            if (compare == 0) {
                compare = j2.price - j1.price;
            }
            return compare;
        });
        bagList.sort(null);

        int jewelIndex = 0;
        long totalPrice = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((int1, int2) -> int2 - int1);

        for (int i = 0; i < k; i++) {
            while (jewelIndex < n) {
                Jewel jewel = jewelList.get(jewelIndex);
                if (jewel.weight <= bagList.get(i)) {
                    pq.offer(jewel.price);
                    jewelIndex++;
                } else {
                    break;
                }
            }
            if (!pq.isEmpty()) {
                totalPrice += pq.poll();
            }
        }

        System.out.println(totalPrice);
    }
}