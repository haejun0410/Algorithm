import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        int max = times[times.length-1];

        long left = 1, right = (long) max * n;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            long count = 0;
            for (int time : times) {
                count += mid / time;
            }

            if (count < n) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        return answer;
    }
}