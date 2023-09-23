import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Stack<int[]> tempList = new Stack<>();
    static List<List<int[]>> chickenCombinationList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<int[]> chickenList = new ArrayList<>();
        List<int[]> houseList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int building = Integer.parseInt(st.nextToken());
                if (building == 2) chickenList.add(new int[]{i, j});
                else if (building == 1) houseList.add(new int[]{i, j});
            }
        }

        combination(chickenList, 0, 0, M);

        List<Integer> chickenDistanceList = new ArrayList<>();
        for (int i = 0; i < chickenCombinationList.size(); i++) {
            int totalDistance = 0;
            List<int[]> chickenCombination = chickenCombinationList.get(i);
            for (int[] house : houseList) {
                int distance = 100;
                for (int[] chicken : chickenCombination) {
                    distance = Math.min(distance, Math.abs(chicken[0] - house[0]) + Math.abs(chicken[1] - house[1]));
                }
                totalDistance += distance;
            }
            chickenDistanceList.add(totalDistance);
        }

        System.out.println(chickenDistanceList.stream().min(Comparator.naturalOrder()).get());
    }

    public static void combination(List<int[]> chicken, int start, int depth, int targetDepth) {
        if (depth == targetDepth) {
            chickenCombinationList.add(List.copyOf(tempList));
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            tempList.add(chicken.get(i));
            depth++;
            combination(chicken, i + 1, depth, targetDepth);
            tempList.pop();
            depth--;
        }
    }
}
