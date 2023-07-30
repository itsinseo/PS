import java.util.*;

class Solution {
    public String solution(String s) {
        char[] characters = s.toCharArray();
        Arrays.sort(characters);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i=characters.length-1; i>=0; i--) {
            stringBuilder.append(characters[i]);
        }
        
        return stringBuilder.toString();
    }
}