class Solution {
    public int solution(int chicken) {
        int answer;
        
        if (chicken < 10) answer = 0;
        answer = (chicken - 1) / 9;
        
        return answer;
    }
}