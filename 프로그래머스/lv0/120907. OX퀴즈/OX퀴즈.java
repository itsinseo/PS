class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        int idx = 0;
        for (String q : quiz) {
            String[] equation = q.split(" ");
            int n1 = Integer.parseInt(equation[0]);
            int n2 = Integer.parseInt(equation[2]);
            int n3 = Integer.parseInt(equation[4]);
            String result = "X";
            switch (equation[1]) {
                case "+":
                    if (n1 + n2 == n3) result = "O";
                    break;
                case "-":
                    if (n1 - n2 == n3) result = "O";
                    break;
            }
            answer[idx++] = result;
        }
        return answer;
    }
}