import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int max = 1;
        Map<String, Integer> books = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            if (!books.containsKey(book)) {
                books.put(book, 1);
            } else {
                int count = books.get(book);
                max = Math.max(max, count + 1);
                books.replace(book, count + 1);
            }
        }

        List<String> bookList = new ArrayList<>(books.keySet());
        Collections.sort(bookList);

        for (String book : bookList) {
            if (books.get(book) == max) {
                System.out.println(book);
                break;
            }
        }
    }
}