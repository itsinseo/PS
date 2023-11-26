import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        String changed = sb.reverse().toString();
        String[] array = changed.split("0");

        Set<Long> primes = eratos();
        for (String str : array) {
            if (!str.isBlank()) {
                Long number = Long.parseLong(str);
                if (number > 100000000) {
                    boolean isPrime = true;
                    for (int i = 2; i <= Math.sqrt(number); i++) {
                        if (number % i == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    if (isPrime) {
                        answer++;
                    }
                } else if (primes.contains(number)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public Set<Long> eratos() {
        Set<Long> set = new HashSet<>();
        int[] arr = new int[100000001];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= 10000; i++) {
            if (arr[i] == 0) {
                set.add((long) i);
                for (int j = 2; i * j < 100000001; j++) {
                    arr[i * j] = 1;
                }
            }
        }

        return set;
    }
}