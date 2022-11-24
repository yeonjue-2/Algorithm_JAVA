class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long sum = 0;
        
        for (int i = 0; i < count; i++) {
            sum += price * (i+1);    
        }
        
        if (sum > money) {
            return answer = sum - money;
        } 

        return answer;
    }
}


// 등차수열 활용 풀이 

class Solution {
    public long solution(long price, long money, long count) {
        return Math.max(price * (count * (count + 1) / 2) - money, 0);
    }
}

// 첫쩨항 a = 1, 공차 d = 1인 등차수열의 열번째 항까지의 합
// a1 = a
// a2 = a + d
// a3 = a + 2d
// ..
// an = a + (n-1)d
// s = a1 + a2 + a3 + .. + an = 1 + 2 + 3 +  .. + 10 = 11 + 11 + 11 + 11 + 11 = 55
//   = (10 + 1) * (10 / 2)
