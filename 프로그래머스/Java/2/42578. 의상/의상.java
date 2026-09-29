import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> count = new HashMap<>();
        
        for (String[] c : clothes) {
            String type = c[1];
            count.put(type, count.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        
        for (int n : count.values()) {
            answer *= (n+1);
        }
        
        return answer-1;
    }
}