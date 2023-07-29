import java.util.*;

class Solution {
    static StringBuilder stringBuilder = new StringBuilder();

    static List<String> vowelDictionary = new ArrayList<>();

    public void recursive(int depth) {
        if (depth == 5) {
            return;
        }

        String[] vowelList = {"A", "E", "I", "O", "U"};

        for (String vowel : vowelList) {
            stringBuilder.append(vowel);
            vowelDictionary.add(stringBuilder.toString());
            recursive(depth + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
    
    public int solution(String word) {
        recursive(0);
        
        int answer = vowelDictionary.indexOf(word) + 1;
        return answer;
    }
}