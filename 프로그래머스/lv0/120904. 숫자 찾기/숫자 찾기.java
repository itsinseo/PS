class Solution {
    public int solution(int num, int k) {
        String stringNum = String.valueOf(num);
        String stringK = String.valueOf(k);
        int answer = stringNum.indexOf(stringK);
        if(answer>=0){
            answer++;
        }
        return answer;
    }
}