import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        
        int idx = 0;
        for (int[] command : commands) {
            int start = command[0]-1;
            int end = command[1];
            int k = command[2]-1;
            
            int[] temp = Arrays.copyOfRange(array, start, end);
            Arrays.sort(temp);
            answer[idx++] = temp[k];
        }
        
        return answer;
    }
}