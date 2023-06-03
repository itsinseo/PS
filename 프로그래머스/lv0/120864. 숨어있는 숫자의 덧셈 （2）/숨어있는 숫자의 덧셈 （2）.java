class Solution {
    public int solution(String my_string) {
        String[] arr = my_string.replaceAll("[A-Za-z]", " ").strip().split(" +");

        int answer = 0;
        if (!arr[0].equals("")) {
            for (String s : arr) {
                answer += Integer.parseInt(s);
            }
        }
        
        return answer;
    }
}