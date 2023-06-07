class Solution {
    public int solution(String A, String B) {
        int answer = -1;

        for (int i = 0; i < A.length(); i++) {
            boolean able = true;
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt((j + i) % A.length())) {
                    able = false;
                    break;
                }
            }
            if (able) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}