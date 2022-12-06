import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> clothesCount = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            clothesCount.put(clothes[i][1], clothesCount.getOrDefault(clothes[i][1], 0) + 1);
        }

        for (String key: clothesCount.keySet()) {
            answer *= (clothesCount.get(key) + 1);
        }

        answer -= 1;

        return answer;
    }
}
