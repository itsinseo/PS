class Solution {
    static int[] answer = {0, 0};

    public void countOnesAndZeros(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                answer[arr[i][j]]++;
            }
        }
    }

    public void recursive(int[][] arr, int x, int y, int length) {
        // 현재 사각형의 왼쪽 모서리를 기준으로 비교 시작
        int numberToCompareWith = arr[x][y];

        boolean isAbleToCombine = true;

        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (arr[i][j] != numberToCompareWith) {
                    isAbleToCombine = false;
                    break;
                }
            }
            if (!isAbleToCombine) {
                break;
            }
        }

        if (!isAbleToCombine) {
            // 4등분으로 쪼개서 다시 함수 호출
            recursive(arr, x, y, length / 2);
            recursive(arr, x + length / 2, y, length / 2);
            recursive(arr, x, y + length / 2, length / 2);
            recursive(arr, x + length / 2, y + length / 2, length / 2);
        } else {
            answer[numberToCompareWith] -= length * length - 1;
        }
    }
    
    public int[] solution(int[][] arr) {
        countOnesAndZeros(arr);
        recursive(arr, 0, 0, arr.length);
        
        return answer;
    }
}