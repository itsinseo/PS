import java.util.regex.Pattern;

class Solution {
    public String solution(String polynomial) {
        int x = 0;
        int constant = 0;
        String[] arr = polynomial.split(" \\+ ");
        String pattern = "[0-9]+x";

        for (String s : arr) {
            if (Pattern.matches(pattern, s)) {
                x += Integer.parseInt(s.substring(0, s.length() - 1));
            } else if (s.equals("x")) x++;
            else constant += Integer.parseInt(s);
        }

        StringBuilder sb = new StringBuilder();
        if (x != 0) {
            if (x == 1) sb.append("x + ");
            else sb.append(x).append("x + ");
        }

        if (constant != 0) {
            sb.append(constant);
        } else {
            sb.replace(sb.length() - 3, sb.length(), "");
        }

        return sb.toString();
    }
}