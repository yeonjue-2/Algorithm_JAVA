class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;

        int N = n;
        while (N >= a) {
            int newCoke = (N / a) * b;
            answer += newCoke;
            
            int reCoke = N % a;
            N = (newCoke + reCoke);
        }

        return answer;
    }
}
