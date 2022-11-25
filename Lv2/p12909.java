class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                sum -= 1;
            } else {
                sum += 1;
                if (sum > 0) {
                    break;
                }
            }
        }

        if (sum != 0){
            answer = false;
        }

        return answer;
    }
}

// 스택을 활용한 풀이
import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> bracket = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                bracket.add(s.charAt(i));
            } else {
                if (bracket.isEmpty()) {
                    answer = false;
                    break;
                }
                bracket.pop();
            }
        }

        if (!bracket.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}
