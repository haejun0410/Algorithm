import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] stageCount = new int[N + 2];
        for (int stage : stages) {
            stageCount[stage]++;
        }

        int totalPlayers = stages.length;
        double[] failRate = new double[N + 1];

        for (int i = 1; i <= N; i++) {
            if (totalPlayers == 0) {
                failRate[i] = 0;
            } else {
                failRate[i] = (double) stageCount[i] / totalPlayers;
                totalPlayers -= stageCount[i];
            }
        }

        Integer[] order = new Integer[N];
        for (int i = 0; i < N; i++) order[i] = i + 1;

        Arrays.sort(order, (a, b) -> {
            if (failRate[b] == failRate[a])
                return a - b;
            else
                return Double.compare(failRate[b], failRate[a]);
        });

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = order[i];
        }

        return answer;
    }
}
