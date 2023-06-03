class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0;
        int y = 0;

        int width = board[0] / 2;
        int height = board[1] / 2;

        for (String direction : keyinput) {
            switch (direction) {
                case "up":
                    if (y < height) y += 1;
                    break;
                case "down":
                    if (y > -height) y -= 1;
                    break;
                case "left":
                    if (x > -width) x -= 1;
                    break;
                case "right":
                    if (x < width) x += 1;
                    break;
            }
        }

        int[] answer = {x, y};
        
        return answer;
    }
}