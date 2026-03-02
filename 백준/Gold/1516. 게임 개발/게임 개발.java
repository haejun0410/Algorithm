import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();

        int[] buildingTime = new int[n + 1];
        int[] indegree = new int[n + 1];
        int[] totalTime = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildingTime[i] = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int prev = Integer.parseInt(st.nextToken());
                if (prev == -1) break;
                adj[prev].add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                totalTime[i] = buildingTime[i];
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : adj[curr]) {
                indegree[next]--;
                
                totalTime[next] = Math.max(totalTime[next], totalTime[curr]);

                if (indegree[next] == 0) {
                    totalTime[next] += buildingTime[next];
                    queue.offer(next);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(totalTime[i]).append("\n");
        }
        System.out.print(sb);
    }
}