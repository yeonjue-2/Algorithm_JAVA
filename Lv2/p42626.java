// https://school.programmers.co.kr/learn/courses/30/lessons/42626

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for (int i : scoville) {        // 큐에 하나씩 넣어줌
            que.offer(i);
        }

        while (que.peek() < K) {        // 처음 값(제일 작은 값)이 K보다 작지않을 때까지
            if (que.size() == 1) {
                return -1;
            }

            int a = que.poll();         // 첫번째, 두번째 값을 뽑아서 연산
            int b = que.poll();

            int result = a + (b * 2);

            que.offer(result);
            answer += 1;                // 연산할 때마다 +1
        }

        return answer;
    }
}
