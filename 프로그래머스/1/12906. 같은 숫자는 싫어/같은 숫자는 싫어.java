import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Stack<Integer> stack = new Stack<>();
        
        for(int num : arr) {
            if (stack.isEmpty() || stack.peek() != num) {
                stack.push(num);
            }
        }
        
        answer = new int[stack.size()];
        for(int i=0; i<stack.size(); i++) {
            answer[i] = stack.get(i);
        }

        return answer;
    }
}