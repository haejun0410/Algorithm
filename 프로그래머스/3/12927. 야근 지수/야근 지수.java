import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works) pq.offer(work);
        
        for(int i = 0; i < n && !pq.isEmpty(); i++) {
            int target = pq.poll();
            target -= 1;
            if (target != 0) {
                pq.offer(target);
            }
        }

        long ans = 0;
        while(!pq.isEmpty()) {
            int time = pq.poll();
            ans += (long) time * time;
        }
        
        return ans;
    }
}