import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) {
            pq.offer(s);
        }
        
        int count = 0;
        
        while(pq.peek() < K && pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int make = first + 2*second;
            count++;
            pq.offer(make);
        }
        
        return pq.peek() < K ? -1 : count;
    }
}