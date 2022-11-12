class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int total = 0;
        int cnt = 0;

        Arrays.sort(d);

        for (int i = 0; i <= d.length-1; i++) {
            total += d[i];
        }

        if (d[0] > budget) {
            answer = 0;
        }

        if (total <= budget) {
            answer = d.length;
        } else if (total > budget && d[0] <= budget) {
            while (total > budget) {                // total : 4, budget : 1   2 : 1
                total -= d[d.length-1-cnt];         // 4 - 2   cnt = 0         2-1
                cnt++;                              // 1                       2
            }
            answer = d.length - cnt;
        }

        return answer;
    }
  
  // {2, 1, 1}  1  -> 1
  // 배열의 값을 전부 더한 다음 예산과 비교해서 예산의 값이 더 커지도록
  // 배열의 가장 큰 값을 하나씩 빼주었다.
  
  
// 다른 풀이   {2, 2, 3, 3}  9 -> 3
// 빼간다는 방식은 비슷했지만 이 풀이는 예산에서 배열의 앞 순서, 즉 작은 숫자부터 빼어서
// 0보다 작아지면 답을 구하는 방식을 사용
  
class Solution {
  public int solution(int[] d, int budget) {
      int answer = 0;

      Arrays.sort(d);

      for (int i = 0; i < d.length; i++) {
          budget -= d[i];
        
          if (budget < 0) break;

          answer++;
        
          
      }

      return answer;
  }
}
