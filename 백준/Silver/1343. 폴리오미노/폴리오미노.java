import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String board = sc.next();

        while (board.contains("XXXX")) {
            board = board.replace("XXXX", "AAAA");
        }
        while (board.contains("XX")) {
            board = board.replace("XX", "BB");
        }
        if (board.contains("X")) {
            System.out.println(-1);
        } else {
            System.out.println(board);
        }
    }
}