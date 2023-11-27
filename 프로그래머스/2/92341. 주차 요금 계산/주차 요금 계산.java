import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {

        Map<String, Integer> carNumberParked = new HashMap<>();
        Map<String, Integer> carNumberTime = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] command = records[i].split(" ");
            String[] hourMinute = command[0].split(":");
            int time = Integer.parseInt(hourMinute[0]) * 60 + Integer.parseInt(hourMinute[1]);
            String carNumber = command[1];
            String inOrOut = command[2];

            if (inOrOut.equals("IN")) {
                carNumberParked.put(carNumber, time);
            } else {
                int parkedIn = carNumberParked.get(carNumber);
                int elapsed = time - parkedIn;
                if (carNumberTime.containsKey(carNumber)) {
                    carNumberTime.put(carNumber, carNumberTime.get(carNumber) + elapsed);
                } else {
                    carNumberTime.put(carNumber, elapsed);
                }
                carNumberParked.remove(carNumber);
            }
        }

        for (String carNumber : carNumberParked.keySet()) {
            int parkedIn = carNumberParked.get(carNumber);
            int elapsed = (23 * 60 + 59) - parkedIn;
            if (carNumberTime.containsKey(carNumber)) {
                carNumberTime.put(carNumber, carNumberTime.get(carNumber) + elapsed);
            } else {
                carNumberTime.put(carNumber, elapsed);
            }
        }

        List<String> carNumberList = new ArrayList<>(carNumberTime.keySet());
        Collections.sort(carNumberList);

        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        List<Integer> answerList = new ArrayList<>();
        for (String carNumber : carNumberList) {
            int totalTime = carNumberTime.get(carNumber);
            if (totalTime <= baseTime) {
                answerList.add(baseFee);
            } else {
                int totalFee = (int) (baseFee + Math.ceil((double) (totalTime - baseTime) / unitTime) * unitFee);
                answerList.add(totalFee);
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}