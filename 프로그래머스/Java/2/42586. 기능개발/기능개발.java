
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        int num = progresses.length;

        int count = 1;
        int prev = (int) Math.ceil(
            (double)(100 - progresses[0]) / speeds[0]
        );

        for (int i = 1; i < num; i++) {
            int curr = (int) Math.ceil(
                (double)(100 - progresses[i]) / speeds[i]
            );

            if (curr > prev) {
                list.add(count);
                prev = curr;
                count = 1;
            } else {
                count++;
            }
        }

        list.add(count);

        return list.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}
