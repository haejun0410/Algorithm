import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();

        Queue<Integer> daysQueue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int day = (int) Math.ceil((double) remain / speeds[i]);
            daysQueue.offer(day);
        }

        while (!daysQueue.isEmpty()) {
            int current = daysQueue.poll();
            int count = 1;

            while (!daysQueue.isEmpty() && daysQueue.peek() <= current) {
                daysQueue.poll();
                count++;
            }

            result.add(count);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
