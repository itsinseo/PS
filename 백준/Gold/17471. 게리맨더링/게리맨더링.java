import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n, totalPopulation, answer;
    static int[] population;
    static int[][] graph;
    static ArrayList<Integer> combination;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        population = new int[n + 1];

        answer = Integer.MAX_VALUE;

        totalPopulation = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            int input = Integer.parseInt(st.nextToken());
            population[i] = input;
            totalPopulation += input;
        }

        graph = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int connections = Integer.parseInt(st.nextToken());
            for (int j = 0; j < connections; j++) {
                int connected = Integer.parseInt(st.nextToken());
                graph[i][connected] = 1;
            }
        }

        combination = new ArrayList<>();

        for (int i = 1; i <= n / 2; i++) {
            getCombination(i, 1);
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void getCombination(int depth, int number) {
        if (combination.size() == depth) {
            if (checkConnection(combination)) {
                int partialSum = 0;
                for (Integer integer : combination) {
                    partialSum += population[integer];
                }
                int difference = Math.abs((totalPopulation - partialSum) - partialSum);
                answer = Math.min(answer, difference);
            }
            return;
        }
        if (number > n) {
            return;
        }

        combination.add(number);
        getCombination(depth, number + 1);
        combination.remove(combination.size() - 1);
        getCombination(depth, number + 1);
    }

    static boolean checkConnection(ArrayList<Integer> combination) {
        visited = new int[n + 1];
        int start = combination.get(0);
        visited[start] = 1;
        dfs(start, combination);

        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            count += visited[i];
        }
        if (count != combination.size()) {
            return false;
        }

        ArrayList<Integer> notSelected = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (!combination.contains(i)) {
                notSelected.add(i);
            }
        }
        visited = new int[n + 1];
        start = notSelected.get(0);
        visited[start] = 1;
        dfs(start, notSelected);

        count = 0;
        for (int i = 1; i < n + 1; i++) {
            count += visited[i];
        }
        if (count != n - combination.size()) {
            return false;
        }

        return true;
    }

    static void dfs(int start, ArrayList<Integer> list) {
        for (int i = 1; i < n + 1; i++) {
            if (visited[i] == 0 && graph[start][i] == 1 && list.contains(i)) {
                visited[i] = 1;
                dfs(i, list);
            }
        }
    }
}