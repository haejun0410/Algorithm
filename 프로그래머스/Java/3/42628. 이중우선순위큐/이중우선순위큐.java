import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        
        HashMap<Integer, Integer> counts = new HashMap<>();
        
        for (String operation : operations) {
            String[] commands = operation.split(" ");
            String command = commands[0];
            int target = Integer.parseInt(commands[1]);
            
            if (command.equals("I")) {
                counts.put(target, counts.getOrDefault(target, 0) + 1);
                minPq.offer(target);
                maxPq.offer(target);
            } else if (command.equals("D")) {
                PriorityQueue<Integer> targetPq = (target == 1) ? maxPq : minPq;
                removeValidNode(targetPq, counts);
            }
        }
        
        int[] answer = new int[2];
        
        while (!maxPq.isEmpty() && counts.getOrDefault(maxPq.peek(), 0) == 0) {
            maxPq.poll();
        }
        if (!maxPq.isEmpty()) {
            answer[0] = maxPq.peek();
        }
        
        while (!minPq.isEmpty() && counts.getOrDefault(minPq.peek(), 0) == 0) {
            minPq.poll();
        }
        if (!minPq.isEmpty()) {
            answer[1] = minPq.peek();
        }
        
        return answer;
    }
    
    private void removeValidNode(PriorityQueue<Integer> pq, HashMap<Integer, Integer> counts) {
        while (!pq.isEmpty()) {
            int num = pq.poll();
            if (counts.getOrDefault(num, 0) > 0) {
                counts.put(num, counts.get(num) - 1);
                break;
            }
        }
    }
}