class Solution {
    public int addBinary(int number, String binary) {
        for (int i = 0; i < binary.length(); i++) {
            number += (binary.charAt(binary.length() - 1 - i) - '0') * Math.pow(2, i);
        }
        return number;
    }

    public String solution(String bin1, String bin2) {
        StringBuilder sb = new StringBuilder();

        int answer = 0;
        answer = addBinary(answer, bin1);
        answer = addBinary(answer, bin2);

        while (answer > 0) {
            sb.append(answer % 2);
            answer /= 2;
        }
        sb.reverse();
        
        if(sb.toString().equals("")) sb.append("0");

        return sb.toString();
    }
}