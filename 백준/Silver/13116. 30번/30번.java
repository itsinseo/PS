import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }

            List<Integer> aParentTree = new ArrayList<>();
            List<Integer> bParentTree = new ArrayList<>();

            fillParentTree(a, aParentTree);
            fillParentTree(b, bParentTree);

            sb.append(getBiggestCommonParent(aParentTree, bParentTree) * 10).append("\n");
        }

        System.out.println(sb);
    }

    public static void fillParentTree(int number, List<Integer> parentTree) {
        while (number >= 1) {
            parentTree.add(number);
            number /= 2;
        }
    }

    public static int getBiggestCommonParent(List<Integer> list1, List<Integer> list2) {
        int size1 = list1.size();
        int size2 = list2.size();

        int common = 1;

        for (int i = 1; i <= size1; i++) {
            if (!Objects.equals(list1.get(size1 - i), list2.get(size2 - i))) {
                break;
            }
            common = list1.get(size1 - i);
        }

        return common;
    }
}
