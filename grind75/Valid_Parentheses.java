import java.util.Stack;

class Valid_Parentheses {
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
