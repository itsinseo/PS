class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] ableArray = {"aya", "ye", "woo", "ma"};

        for (String word : babbling) {
            for (String able : ableArray) {
                word = word.replace(able, " ");
            }
            if (word.strip().equals("")) answer++;
        }
        
        return answer;
    }
}