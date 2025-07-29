import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(int[] command : commands) {
            int[] sliced = Arrays.copyOfRange(array, command[0]-1, command[1]);
            Arrays.sort(sliced);
            answer.add(sliced[command[2]-1]);
        }
        
        int[] result = answer.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}