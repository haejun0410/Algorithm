import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        
        for (int size : tangerine) {
            countMap.put(size, countMap.getOrDefault(size, 0) + 1);
        }
        
        List<Integer> counts = new ArrayList<>(countMap.values());
        counts.sort(Collections.reverseOrder());
        
        int answer = 0;
        
        for (int count : counts) {
            k -= count;
            answer++;
            if (k <= 0) break;
        }
        
        return answer;
    }
}