import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        List<Integer> sum = new ArrayList<>();
        int[] finaldays = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            finaldays[i] = (int) Math.ceil((100 - progresses[i]) / (speeds[i] * 1.0));
        }

        int cnt = 0;
        int max = finaldays[0];
        for (int finalday : finaldays) {
            if (max >= finalday) {
                cnt++;
            } else {
                sum.add(cnt);
                cnt = 1;
                max = finalday;
            }
        }
        sum.add(cnt);

        answer = new int[sum.size()];

        for (int i = 0; i < sum.size(); i++) {
            answer[i] = sum.get(i);
        }
        return answer;
    }
}

// 새로운 배열을 만들고 그 배열에서 개수를 세어 리스트에 저장한다음 배열로 변경하려 했다
// 믾이 돌아간 것 같다. 


// 다른 풀이
// que로 구현
// 마지막에 리스트를 배열로 바꾸는 부분을 stream 처리
// 성능은 더 좋지 않다. (stream 때문)
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> que = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int date = (int) Math.ceil((100 - progresses[i]) / (speeds[i] * 1.0));

            if (!que.isEmpty() && que.peek() < date) {
                answer.add(que.size());
                que.clear();
            }

            que.offer(date);
        }

        answer.add(que.size());

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
