import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int[] number) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < number.length; i++) {
            for (int j = i+1; j < number.length; j++) {
                for (int k = j+1; k < number.length; k++) {
                    list.add(number[i] + number[j] + number[k]);
                }
            }
        }
        answer = Collections.frequency(list, 0);

        return answer;
    }
}
