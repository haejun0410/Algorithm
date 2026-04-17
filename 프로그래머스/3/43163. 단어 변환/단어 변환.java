import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(begin);
        boolean[] visited = new boolean[words.length];
        
        int step = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int k = 0; k < size; k++) {
                String curr = queue.poll();
                if (curr.equals(target)) {
                    return step;
                }

                for (int i = 0; i < words.length; i++) {
                    if (!visited[i]) {
                        int diffCount = 0;
                        for (int idx = 0; idx < curr.length(); idx++) {
                            if (curr.charAt(idx) != words[i].charAt(idx)) {
                                diffCount++;
                            }
                        }

                        if (diffCount == 1) {
                            queue.offer(words[i]);
                            visited[i] = true;
                        }
                    }
                }
            }
            
            step++;
        }
        
        return 0;
        
    }
}