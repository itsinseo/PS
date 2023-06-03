class Solution {
    public int solution(int[][] board) {
        int[][] largeBoard = new int[board.length + 2][board.length + 2];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    for (int a = 0; a < 3; a++) {
                        for (int b = 0; b < 3; b++) {
                            largeBoard[i + a][j + b] = 1;
                        }
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i < largeBoard.length - 1; i++) {
            for (int j = 1; j < largeBoard.length - 1; j++) {
                if (largeBoard[i][j] == 0) answer++;
            }
        }
        
        return answer;
    }
}