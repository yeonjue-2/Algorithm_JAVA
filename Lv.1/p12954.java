class Solution {
   public long[] solution(int x, int n) {
        long[] answer = new long[n];

        for (int i = 0; i < n ; i++) {
            long result = ((long) x) * (i+1);
            answer[i] = result;
        }

        return answer;
    }
}

// long result = x * (i+1);      
// 위처럼 처리하면 int 값으로 계산한 값을 long 형태로 변환해주기 때문에
// 먼저 변환 후 계산해야 함
