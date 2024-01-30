import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String explosion = br.readLine();
        int explosionSize = explosion.length();

        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            characterStack.push(input.charAt(i));
            if (characterStack.size() >= explosionSize) {
                boolean isExploding = true;
                for (int j = 0; j < explosionSize; j++) {
                    if (characterStack.get(characterStack.size() - explosionSize + j) != explosion.charAt(j)) {
                        isExploding = false;
                        break;
                    }
                }
                if (isExploding) {
                    for (int j = 0; j < explosionSize; j++) {
                        characterStack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : characterStack) {
            sb.append(c);
        }
        String answer = sb.toString();

        System.out.println(answer.isEmpty() ? "FRULA" : answer);
    }
}