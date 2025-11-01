import java.util.Stack;

class Valid_Parenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || 
                   (c == ')' && stack.pop() != '(') || 
                   (c == '}' && stack.pop() != '{') || 
                   (c == ']' && stack.pop() != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}


// class Solution {
//     public boolean isValid(String s) {
//         String[] bracket = s.split("");
//         Stack<String> stack = new Stack<>();
//         ArrayList<String> open = new ArrayList<>(Arrays.asList("(", "[", "{"));
//         ArrayList<String> close = new ArrayList<>(Arrays.asList(")", "]", "}"));

//         for (String str : bracket) {
//             if (open.contains(str)) {
//                 stack.push(str);
//             } else if (close.contains(str)) {
//                 if (!stack.isEmpty() && stack.peek().equals(open.get(close.indexOf(str)))) {
//                     stack.pop();
//                 } else {
//                     return false;
//                 }
//             }
//         }

//         return stack.isEmpty();
//     }
// }


/* python 구현 추가
def is_correct_parenthesis(string):
    stack = []

    for i in range(len(string)):
        if string[i] == '(':
            stack.append("(")
        elif string[i] == ')':
            if len(stack) == 0:
                return False
            stack.pop()

    if len(stack) != 0:
        return False
    else:
        return True

print("정답 = True / 현재 풀이 값 = ", is_correct_parenthesis("(())"))
print("정답 = False / 현재 풀이 값 = ", is_correct_parenthesis(")"))
print("정답 = False / 현재 풀이 값 = ", is_correct_parenthesis("((())))"))
print("정답 = False / 현재 풀이 값 = ", is_correct_parenthesis("())()"))
print("정답 = False / 현재 풀이 값 = ", is_correct_parenthesis("((())"))
*/
