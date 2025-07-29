import java.util.*;

class Solution {
    
    public int solution(int n, int[][] computers) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[computers[0].length];
        
        int count = 0;
        
        for(int i=0; i<computers[0].length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                count++;
                queue.offer(i);
                while(!queue.isEmpty()) {
                    int current = queue.poll();
                    for(int j=0; j<computers[0].length; j++) {
                        if (j != current && computers[current][j] == 1 && !visited[j]) {
                            visited[j] = true;
                            queue.offer(j);
                        }
                    }
                }
            }
        }
        
        return count;
    }
}