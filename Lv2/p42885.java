// 나의 틀린 풀이
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < people.length; i++) {
            st.add(people[i]);
        }

        while (!st.isEmpty()) {
            int sum = limit;
            while (sum > 0 && !st.isEmpty()) {
                if ((sum -= st.peek()) >= 0) {
                    st.pop();
                }
            }
            answer++;
        }
        return answer;
    }
}

// 가장 작은 수, 가장 큰 수를 더하는 풀이 (정답)import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int start = 0;
        int last = people.length - 1;

        while (start < last) {
            if (people[start] + people[last] <= limit) {
                start++;
                last--;
            } else {
                last--;
            }
            answer++;
        }
        
        if (start == last) {
            answer++;
        }
        return answer;
    }
}


// 어나더

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0; 
        int j = people.length - 1;
        
        for (; i < j; --j) {
            if (people[i] + people[j] <= limit)
                ++i;
        }
        return people.length - i;
    }
}
