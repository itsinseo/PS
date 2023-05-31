import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long ab = a * b;
        long temp;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }
        while (true) {
            if (a % b == 0) {
                break;
            } else {
                temp = b;
                b = a % b;
                a = temp;
            }
        }
        System.out.println(ab/b);
    }
}
