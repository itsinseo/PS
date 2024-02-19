import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int kx, ky, rx, ry;
    static Map<String, Integer> commandMap;
    static int[] commandXArr = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] commandYArr = {1, -1, 0, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        initialSetting();

        String king = st.nextToken();
        kx = Math.abs(king.charAt(1) - '0' - 8);
        ky = king.charAt(0) - 'A';

        String rock = st.nextToken();
        rx = Math.abs(rock.charAt(1) - '0' - 8);
        ry = rock.charAt(0) - 'A';

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            checkAndMoveKing(command);
        }

        StringBuilder sb = new StringBuilder();
        sb.append((char) (ky + 'A'));
        sb.append(Math.abs(kx - 8));
        System.out.println(sb);

        sb = new StringBuilder();
        sb.append((char) (ry + 'A'));
        sb.append(Math.abs(rx - 8));
        System.out.println(sb);
    }

    static void initialSetting() {
        commandMap = new HashMap<>();
        commandMap.put("R", 0);
        commandMap.put("L", 1);
        commandMap.put("B", 2);
        commandMap.put("T", 3);
        commandMap.put("RT", 4);
        commandMap.put("LT", 5);
        commandMap.put("RB", 6);
        commandMap.put("LB", 7);
    }

    static void checkAndMoveKing(String command) {
        int direction = commandMap.get(command);

        int x0 = commandXArr[direction];
        int y0 = commandYArr[direction];

        if (kx + x0 >= 0 && kx + x0 < 8 && ky + y0 >= 0 && ky + y0 < 8) {
            if (kx + x0 == rx && ky + y0 == ry) {
                if (rx + x0 >= 0 && rx + x0 < 8 && ry + y0 >= 0 && ry + y0 < 8) {
                    rx += x0;
                    ry += y0;
                    kx += x0;
                    ky += y0;
                }
            } else {
                kx += x0;
                ky += y0;
            }
        }
    }
}