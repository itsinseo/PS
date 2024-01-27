import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static class NextNode {
        int nextNode;
        int cost;

        public NextNode(int nextNode, int cost) {
            this.nextNode = nextNode;
            this.cost = cost;
        }
    }

    static int v, e, k;
    static ArrayList<ArrayList<NextNode>> graph;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        distance = new int[v + 1];
        visited = new boolean[v + 1];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new NextNode(v, w));
        }

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        for (int i = 1; i < v + 1; i++) {
            int currentMinDistance = Integer.MAX_VALUE;
            int currentMinNode = 0;

            for (int j = 1; j < v + 1; j++) {
                if (!visited[j] && distance[j] < currentMinDistance) {
                    currentMinDistance = distance[j];
                    currentMinNode = j;
                }
            }
            visited[currentMinNode] = true;

            ArrayList<NextNode> connectedNodes = graph.get(currentMinNode);
            for (int j = 0; j < connectedNodes.size(); j++) {
                NextNode nextNode = connectedNodes.get(j);
                distance[nextNode.nextNode] = Math.min(distance[nextNode.nextNode], currentMinDistance + nextNode.cost);
            }
        }

        for (int i = 1; i < v + 1; i++) {
            System.out.println(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]);
        }
    }
}