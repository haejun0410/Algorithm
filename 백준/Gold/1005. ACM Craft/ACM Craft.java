import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= TC; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // n : 건물의 수
            int n = Integer.parseInt(st.nextToken());
            // k : 규칙의 개수
            int k = Integer.parseInt(st.nextToken());
            int[] times = new int[n+1];

            // i번째 건물을 짓는데 걸리는 시간
            st= new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }

            LinkedList<Integer>[] adj = new LinkedList[n+1];
            for (int i = 0; i <= n; i++) adj[i] = new LinkedList<>();
            int[] indegree = new int[n+1];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adj[from].add(to);
                indegree[to]++;
            }

            // 건설할 목표 건물
            int w = Integer.parseInt(br.readLine());

            // 완공까지 걸리는 시간 저장
            int[] endTime = new int[n+1];

            // 0 : 건물 번호, 1: 완공 시점
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
                return o1[1] - o2[1];
            });

            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0) {
                    pq.offer(new int[] {i, times[i]});
                    endTime[i] = times[i];
                }
            }

            while(!pq.isEmpty()) {
                int[] curr = pq.poll();
                int num = curr[0];
                int time = curr[1];

                if (num == w) {
                    sb.append(endTime[num]).append("\n");
                    break;
                }

                for (int next : adj[num]) {
                    indegree[next]--;
                    endTime[next] = Math.max(endTime[next], time + times[next]);

                    if (indegree[next] == 0) {
                        pq.offer(new int[] {next, endTime[next]});
                    }
                }
            }
        }
        System.out.println(sb);
    }
}