import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int t = 0; t<commands.length; t++) {
            int s = commands[t][0];
            int e = commands[t][1];
            int k = commands[t][2];
            
            int cnt = 0;
            ArrayList<Integer> subArr = new ArrayList<>();
            for (int i=s-1; i<e; i++) {
                subArr.add(array[i]);
            }
            
            Collections.sort(subArr);
            answer[t] = subArr.get(k-1);
            
        }
        
        return answer;
    }
}