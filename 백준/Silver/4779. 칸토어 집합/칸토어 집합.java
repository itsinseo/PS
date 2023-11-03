import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            cantor(n);
        }
    }

    static void cantor(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("-");

        for (int i = 0; i < n; i++) {
            String shape = sb.toString();
            sb.append(" ".repeat(sb.length()));
            sb.append(shape);
        }

        System.out.println(sb);
    }
}