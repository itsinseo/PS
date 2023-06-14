import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> listP = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            listP.add(scanner.nextInt());
        }

        List<Integer> listA = new ArrayList<>(List.copyOf(listP));
        listP.sort(null);

        List<Integer> listB = new ArrayList<>();
        for (Integer integer : listA) {
            listB.add(listP.indexOf(integer));
            listP.set(listP.indexOf(integer), 0);
        }

        listB.forEach(integer -> System.out.print(integer + " "));
    }
}