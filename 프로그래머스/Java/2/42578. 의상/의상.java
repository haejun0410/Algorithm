import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] set : clothes) {
            String type = set[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        for(Integer count : map.values()) {
            answer *= (count + 1);
        }
        return answer-1;
    }
}