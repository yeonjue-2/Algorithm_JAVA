import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        int number = brown + yellow;
        int sqrt = (int) Math.sqrt(number);

        for (int i=3; i<sqrt+1; i++) {
            if (number%i == 0) {
                map.put(i, number/i);
            }
        }

        for (int key : map.keySet()) {
            if ((key - 2) * (map.get(key) - 2) == yellow) {
                answer[0] = map.get(key);
                answer[1] = key;
            }
        }

        return answer;
    }
}
