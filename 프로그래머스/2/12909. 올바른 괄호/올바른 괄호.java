import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(') {
                stack.push(current);
            }
            else {
                if (stack.isEmpty() || stack.peek() == ')') {
                    return false;
                }
                stack.pop();
            }
        }
        
        if (!stack.isEmpty()) {
            return false;
        }

        return answer;
    }
}