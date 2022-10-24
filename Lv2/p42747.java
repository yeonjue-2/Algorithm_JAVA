import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {

        Arrays.sort(citations);
        int sum = 0;

        for (int i = 0; i < citations.length; i++) {
            sum += citations[i];
        }

        int avg = sum / citations.length + 1;

        while (avg-- > 0) {
            int cnt = 0;

            for (int i = 0; i < citations.length; i++) {
                if (citations[i] >= avg) {
                    cnt++;
                }
            }

            if (cnt >= avg) {
                break;
            }
        }

        return avg;
    }
}


// 다른 풀이
// 해당 index번째의 값과 나머지 남은 값의 개수 중 작은 것을 고르고 가장 커질 때까지 값을 불린다

public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);         // [0, 1, 3, 5, 6]
        
        for(int i=0; i<citations.length; i++){                          // 0          1      2      3
            int smaller = Math.min(citations[i], citations.length-i);   // min(0, 5)  (1, 4) (3, 3) (5, 2)
            answer = Math.max(answer, smaller);
        }
        
        return answer;
    }


