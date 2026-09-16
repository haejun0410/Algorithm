import java.util.*;
import java.io.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        int wordLen = words[0].length();
        
        int targetIndex = -1;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                targetIndex = i;
                break;
            }
        }
        if (targetIndex == -1) return 0;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                String word1 = words[i];
                String word2 = words[j];
                int count = 0;
                for (int k = 0; k < wordLen; k++) {
                    if (word1.charAt(k) == word2.charAt(k)) {
                        count++;
                    }
                }
                
                if (count == wordLen -1) {
                    adj.get(j).add(i);
                    adj.get(i).add(j);
                }
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int k = 0; k < wordLen; k++) {
                if (begin.charAt(k) == words[i].charAt(k)) {
                    count++;
                }
            }
            if (count == wordLen - 1) {
                queue.offer(i);
                dist[i] = 1;
            }
        }
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            if (curr == targetIndex) {
                return dist[curr];
            }
            
            for (int next : adj.get(curr)) {
                if (dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    queue.offer(next);
                }
            }
        }
        
        return 0;
        
        
    }
}