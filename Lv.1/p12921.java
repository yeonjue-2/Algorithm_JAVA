import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int n) {
        int answer = 0;

        ArrayList<Integer> prime = new ArrayList<>();     // n개의 수를 가지는 리스트

        for (int i = 0; i < n+1; i++) {
            prime.add(0);                                 // 모두 0으로 생성
        }

        int sqrt = (int) Math.sqrt(n);                  

        for (int i = 2; i < sqrt+1; i++) {                // n의 제곱근까지 검사하면 소수인지 
            if (prime.get(i) == 0) {                      // 0 이라면
                for (int j = i+i; j < n+1; j += i) {      // i=2일 때, 4, 6, 8, 10 번째 리스트 값을 0 -> 1로 변경
                    prime.set(j, 1);                      // i=3,  9
                }
            }
        }

        int cnt = Collections.frequency(prime, 1);        // 리스트에서 1로 변경된 것들의 개수 = 위의 수 5개

        answer = n - cnt - 1;                             // 1도 소수가 아니므로 빼줌

        return answer;
    }
