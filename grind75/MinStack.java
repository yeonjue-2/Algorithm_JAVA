class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if (!minStack.isEmpty()) {
            int min = minStack.peek();
            if (min >= val) {
                minStack.push(val);
            }
        } else {
            minStack.push(val);
        }
    }

    public void pop() {
        int pop = stack.pop();

        if (pop == minStack.peek()) minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

// 단일 스택으로 구성하는 방법도 있음
