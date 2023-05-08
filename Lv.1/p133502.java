class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        String arr = Arrays.toString(ingredient);
        arr = arr.substring(1, arr.length()-1).replace(", ", "");

        while (arr.contains("1231")) {
            arr = arr.replaceFirst("1231", "");
            answer++;
        }
        
        return answer;
    }
}

// 시간초과 
// 여전히 성능개선의 개념이 없다.
// replaceAll을 썼을경우 값이 달라지기때문에 앞에서부터 순회해야하는데 1,000,000이 최대길이라 최대 25만번 while 문을 진행야한다.

public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i: ingredient) {
            stack.push(i);

            if (stack.size() >= 4) {
                if (stack.get(stack.size() - 4) == 1 && stack.get(stack.size() - 3) == 2
                    && stack.get(stack.size() - 2) == 3 && stack.get(stack.size() - 1) == 1) {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();

                    answer++;
                }
            }
        }

        return answer;
 }

// 통과 (42.91ms, 100MB)
// stack을 사용하면 끝에서 부터 4번째 수라는 것이 부담스러울 줄 알았는데 for문을 한번만 돌며 전체 순회를 할 수 있어 시간 단축이 됨!

public int solution(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        int sp = 0;
        int answer = 0;
        for (int i : ingredient) {
            stack[sp++] = i;
            if (sp >= 4 && stack[sp - 1] == 1
                && stack[sp - 2] == 3
                && stack[sp - 3] == 2
                && stack[sp - 4] == 1) {
                sp -= 4;
                answer++;
            }
        }
        return answer;
    }

// 통과 (10.10ms, 116MB)
// 다른 사람 풀이를 보니 stack의 정해진 index에 push를 하고 햄버거를 만들었을 경우 그냥 index 값을 줄여 덧씌우며 Push 하였다.
// 넣고 빼는 과정 -> 덧씌우기 로 바꿔서 속도가 더욱 줄어든 것 같다.

// https://school.programmers.co.kr/learn/courses/30/lessons/133502
