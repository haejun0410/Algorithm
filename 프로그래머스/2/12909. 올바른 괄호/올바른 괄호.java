import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push('(');
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.poll();
            }
        }
        
        if (!stack.isEmpty()) {
            return false;
        }
        
        return true;
    }
}