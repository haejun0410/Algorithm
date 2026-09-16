import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int work : works) {
            pq.offer(work);
        }
        
        while(n != 0 && !pq.isEmpty()) {
            int work = pq.poll();
            work--;
            n--;
            if (work != 0) {
                pq.offer(work);
            }
        }
        
        long Ssum = 0;
        while(!pq.isEmpty()) {
            int num = pq.poll();
            Ssum += num * num;
        }
        
        return Ssum;
    }
}