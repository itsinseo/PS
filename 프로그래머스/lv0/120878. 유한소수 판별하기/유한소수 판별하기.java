class Solution {
    public int solution(int a, int b) {
        int answer = 2;
        int gcd = gcd(a, b);
        a /= gcd;
        b /= gcd;

        while (b % 2 == 0) b /= 2;
        while (b % 5 == 0) b /= 5;
        if (b == 1) return 1;

        return answer;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}