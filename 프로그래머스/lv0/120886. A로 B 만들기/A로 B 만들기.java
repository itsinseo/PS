import java.util.Arrays;

class Solution {
    public int solution(String before, String after) {
        int answer = 1;
        String[] beforeArray = before.split("");
        String[] afterArray = after.split("");
        Arrays.sort(beforeArray);
        Arrays.sort(afterArray);
        for (int i = 0; i < beforeArray.length; i++) {
            if (!beforeArray[i].equals(afterArray[i])) {
                answer = 0;
                break;
            }
        }
        
        return answer;
    }
}