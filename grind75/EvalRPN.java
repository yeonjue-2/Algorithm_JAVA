class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (!"+".equals(token) && !"-".equals(token) && !"*".equals(token) && !"/".equals(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                Integer second = stack.pop();
                Integer first = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(first + second);
                        break;
                    case "-":
                        stack.push(first - second);
                        break;
                    case "*":
                        stack.push(first * second);
                        break;
                    case "/":
                        stack.push(first / second);
                        break;
                }
            }
        }
        return stack.pop();
    }

  /*
1. stack을 만든다
2. 숫자를 차례대로 넣는다
3. expression이 나오면 stack에서 2개를 꺼내 계산 후 stack에 넣는다
4. 반복
*/

  // 개선된 버전
  /*
  - stack -> deque로 바꿈
  - Integer -> int 박싱/언박싱 줄임
  - 가독성 측면에서 if-else을 줄여 모두 switch문 만으로 표현
  */
  public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            int second;
            int first;

            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first - second);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first / second);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
  }
  
}
