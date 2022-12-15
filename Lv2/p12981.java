import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> word = new ArrayList<>();
        int index = 0;
        word.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (word.contains(words[i])) {
                index = i + 1;
                break;
            }

            String before = word.get(word.size()-1);

            if (before.charAt(before.length()-1) == words[i].charAt(0)) {
                word.add(words[i]);
            } else {
                index = i + 1;
                break;
            }
        }

        if (index != 0) {
            if (index % n == 0) {
                answer[0] = n;
            } else {
                answer[0] = index % n;
            }
            answer[1] = (int) Math.ceil(index * 1.0 / n);
        }

        return answer;
    }
}
