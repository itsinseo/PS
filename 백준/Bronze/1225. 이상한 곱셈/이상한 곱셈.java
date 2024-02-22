import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        long hyeongTaek = 0;
        for (int i = 0; i <A.length(); i++) {
            int a = A.charAt(i) - '0';
            for (int j = 0; j < B.length(); j++) {
                int b = B.charAt(j) - '0';
                hyeongTaek += (long) a * b;
            }
        }
        System.out.println(hyeongTaek);
    }
}