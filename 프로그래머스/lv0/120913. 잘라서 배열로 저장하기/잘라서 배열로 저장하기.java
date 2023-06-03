class Solution {
    public String[] solution(String my_str, int n) {
        int length = (my_str.length() - 1) / n + 1;
        String[] answer = new String[length];
        for (int i = 0; i < length - 1; i++) {
            answer[i] = my_str.substring(i * n, i * n + n);
        }
        answer[length-1] = my_str.substring((length-1)*n);
        
        return answer;
    }
}