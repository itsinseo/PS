import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // 조회를 위해 Set 생성
        Set<int[]> puddleSet = new HashSet<>(Arrays.asList(puddles));

        // 배열 초기화
        int[][] path = new int[n][m];
        for (int[] arr : path) {
            Arrays.fill(arr, 1);
        }

        // 웅덩이의 경우 구분을 위해 0으로 설정
        // 1 based -> 0 based 좌표
        for (int[] arr : puddleSet) {
            path[arr[1] - 1][arr[0] - 1] = 0;
        }

        // 출발점(집) 초기화
        path[0][0] = 1;

        // 맨 왼쪽 열 세팅
        for (int i = 1; i < n; i++) {
            if (path[i][0] != 0) {
                path[i][0] = path[i - 1][0];
            }
        }

        // 맨 위 행 세팅
        for (int j = 1; j < m; j++) {
            if (path[0][j] != 0) {
                path[0][j] = path[0][j - 1];
            }
        }

        // 맨 위, 맨 왼쪽을 제외한 칸 순회
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (path[i][j] != 0) {
                    path[i][j] = (path[i - 1][j] + path[i][j - 1]) % 1000000007;
                }
            }
        }

        return path[n - 1][m - 1];
    }
}