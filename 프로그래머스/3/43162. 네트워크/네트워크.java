import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int count = 0;
        boolean[] visited = new boolean[n];
        
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                visited[i] = true;
                queue.offer(i);
                while(!queue.isEmpty()) {
                    int curr = queue.poll();
                    for (int j = 0; j < n; j++) {
                        if (computers[curr][j] == 1 && !visited[j]) {
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