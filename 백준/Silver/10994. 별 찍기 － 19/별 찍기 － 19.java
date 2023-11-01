import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    static int n;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = sc.nextInt();

        star(n);

        bw.flush();
    }

    static void star(int number) throws IOException {
        if (number == 1) {
            bw.write("* ".repeat((n - 1) * 2));
            bw.write("*\n");
            return;
        }

        bw.write("* ".repeat(n - number));
        bw.write("*".repeat(4 * number - 3));
        bw.write(" *".repeat(n - number));
        bw.write("\n");

        bw.write("* ".repeat(n - number + 1));
        bw.write(" ".repeat(4 * number - 7));
        bw.write(" *".repeat(n - number + 1));
        bw.write("\n");

        star(number - 1);

        bw.write("* ".repeat(n - number + 1));
        bw.write(" ".repeat(4 * number - 7));
        bw.write(" *".repeat(n - number + 1));
        bw.write("\n");

        bw.write("* ".repeat(n - number));
        bw.write("*".repeat(4 * number - 3));
        bw.write(" *".repeat(n - number));
        bw.write("\n");
    }
}