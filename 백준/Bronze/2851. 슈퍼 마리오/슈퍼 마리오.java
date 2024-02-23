import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int point = 0;
        for (int i = 0; i < 10; i++) {
            int mushroom = Integer.parseInt(br.readLine());
            if (Math.abs(100 - (point + mushroom)) <= Math.abs(100 - point)) {
                point += mushroom;
            } else {
                break;
            }
        }

        System.out.println(point);
    }
}