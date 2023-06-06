class Solution {
    public String solution(String[] id_pw, String[][] db) {
        int id = 0;
        int pw = 0;

        for (String[] data : db) {
            if (data[0].equals(id_pw[0])) {
                id = 1;
                if (data[1].equals(id_pw[1])) {
                    pw = 1;
                }
                break;
            }
        }

        String answer = "fail";
        if (id == 1) {
            if (pw == 0) answer = "wrong pw";
            else if (pw == 1) answer = "login";
        }
        
        return answer;
    }
}