class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;

        List<Integer> que = new ArrayList<>();

        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            que.add(queue1[i]);
        }

        for (int i = 0; i < queue1.length; i++) {
            que.add(queue2[i]);
        }

        int idx1 = 0;
        int idx2 = que.size()/2 ;

        while (sum1 != sum2) {
            if (idx1 >= que.size() || idx2 >= que.size()) {
                answer = -1;
                break;
            } else {
                if (sum1 < sum2) {
                    sum2 -= que.get(idx2);
                    sum1 += que.get(idx2);
                    idx2++;
                } else {
                    sum1 -= que.get(idx1);
                    sum2 += que.get(idx1);
                    idx1++;
                }
            }
            answer++;
        }


        return answer;
    }
}

// 큰 쪽의 값을 빼서 작은 쪽에 넣어주기
// 모두 다 넣어서 index를 초과할 정도로 더해도 안구해지면 -1 
