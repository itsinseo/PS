import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            bw.write(languageAC());
            bw.write("\n");
        }
        bw.flush();
    }

    static String languageAC() throws IOException {
        String functions = br.readLine();
        int arraySize = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(br.readLine());
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);

        String[] arr = sb.toString().split(",");
        Deque<Integer> deque = new ArrayDeque<>();
        if (arraySize != 0) {
            for (String number : arr) {
                deque.addLast(Integer.parseInt(number));
            }
        }

        boolean reversed = false;
        for (int i = 0; i < functions.length(); i++) {
            switch (functions.charAt(i)) {
                case 'R':
                    reversed = !reversed;
                    break;
                case 'D':
                    if (deque.isEmpty()) {
                        return "error";
                    } else {
                        if (!reversed) {
                            deque.removeFirst();
                        } else {
                            deque.removeLast();
                        }
                    }
                    break;
            }
        }

        sb = new StringBuilder();
        sb.append("[");
        int size = deque.size();
        if (!reversed) {
            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst());
                sb.append(",");
            }
        } else {
            while (!deque.isEmpty()) {
                sb.append(deque.pollLast());
                sb.append(",");
            }
        }
        if (sb.length() > 1) sb.deleteCharAt(sb.length() - 1);
        sb.append("]");

        return sb.toString();
    }
}