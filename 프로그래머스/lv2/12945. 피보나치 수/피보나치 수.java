class Solution {
    public static int[] fibonacci() {
        int[] array = new int[100001];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            array[i] = (array[i - 1] + array[i - 2]) % 1234567;
        }
        return array;
    }

    static int[] fibonacci = fibonacci();

    public int solution(int n) {
        return fibonacci[n];
    }
}