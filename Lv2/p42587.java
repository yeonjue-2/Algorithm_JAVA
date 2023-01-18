import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Pair> queue = new LinkedList<>();
        PriorityQueue<Integer> prior = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 1;

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Pair(i, priorities[i]));   // [(0, 2), (1, 1), (2, 3), (3, 2)]
            prior.add(priorities[i]);                // [3, 2, 2, 1]
        }

        while (!prior.isEmpty()) {
            if (queue.peek().priority == prior.peek()) {
                if (queue.peek().location == location) {
                    return answer;
                } else {
                    prior.poll();
                    queue.poll();
                    answer += 1;
                }
            } else {
                Pair p = queue.poll();
                queue.add(p);
            }
        }
        return answer;
    }
}

// https://school.programmers.co.kr/learn/courses/30/lessons/42587
// 처음에 문제를 잘못 이해해서 풀었다. 
