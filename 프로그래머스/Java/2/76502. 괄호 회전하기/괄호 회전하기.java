import java.util.*;

class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = 0;

        for (int i = 0; i < len; i++) {
            if (isCorrect(i, len, s)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isCorrect(int start, int length, String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < length; i++) {
            char c = s.charAt((start + i) % length);

            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
                continue;
            }
            
            if (stack.isEmpty()) {
                return false;
            }

            char top = stack.pop();

            if (c == ']' && top != '[') {
                return false;
            }

            if (c == '}' && top != '{') {
                return false;
            }

            if (c == ')' && top != '(') {
                return false;
            }
        }

        return stack.isEmpty();
    }
}