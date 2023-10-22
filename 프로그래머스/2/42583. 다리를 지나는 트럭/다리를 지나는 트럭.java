import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int bridgeWeight = 0;
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        for (int truck_weight : truck_weights) {
            while (truck_weight - bridge.peek() + bridgeWeight > weight) {
                bridge.offer(0);
                bridgeWeight -= bridge.poll();
                time++;
            }
            bridge.offer(truck_weight);
            bridgeWeight += truck_weight;
            bridgeWeight -= bridge.poll();
            time++;
        }

        return time + bridge_length;
    }
}
