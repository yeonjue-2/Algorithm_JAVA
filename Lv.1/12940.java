// 나의 풀이
class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2] ;
        ArrayList<Integer> n_list = new ArrayList<>();   // n의 약수들
        ArrayList<Integer> m_list = new ArrayList<>();   // m의 약수들

        for (int i = 1; i < n+1; i++) {
            if (n % i == 0) {
                n_list.add(i);
            }
        }

        for (int i = 1; i < m+1; i++) {
            if (m % i == 0) {
                m_list.add(i);
            }
        }

        loop :
        for (int i = n_list.size()-1; i > 0; i--) {           // 약수 리스트에서 뒷순서부터 비교
            for (int j = m_list.size()-1; j > 0; j--) {
                if (n_list.get(i).equals(m_list.get(j))) {    // 같아지면 탈출
                    answer[0] = n_list.get(i);                
                    break loop;
                } else {                                      // 같아지는 게 없으면 1이 최대공약수
                    answer[0] = n_list.get(0);
                }
            }
        }
      
        answer[1] = (n * m) / answer[0];
       
        return answer;
    }
}


// 다른 풀이
public int[] gcdlcm(int a, int b) {
      int[] answer = new int[2];
      int r = 1;
      int gcd = a * b;
      
      while (r != 0) {
         r = b % a;
         b = a;
         a = r;
      }
  
      answer[0] = b;
      answer[1] = gcd / b;
        
      return answer;
    }
