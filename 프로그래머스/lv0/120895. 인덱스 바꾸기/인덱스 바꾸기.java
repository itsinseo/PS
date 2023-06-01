class Solution {
    public String solution(String my_string, int num1, int num2) {
        String[] strArr = my_string.split("");
        String temp = strArr[num1];
        strArr[num1] = strArr[num2];
        strArr[num2] = temp;

        String answer = String.join("",strArr);
        return answer;
    }
}