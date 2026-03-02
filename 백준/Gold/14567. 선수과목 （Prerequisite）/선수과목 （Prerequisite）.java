import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        // n :  과목의 수
        int n = Integer.parseInt(st.nextToken());
        // m : 선수 조건의 수
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        int[] indegree = new int[n+1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            indegree[b]++;
        }

        int[] total = new int[n+1];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(new int[] {i, 1});
                total[i] = 1;
            }
        }

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int next : adj[curr[0]]) {
                indegree[next]--;

                total[next] = Math.max(total[next], curr[1]);
                if (indegree[next] == 0) {
                    total[next]++;
                    queue.offer(new int[] {next, total[next]});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(total[i]).append(" ");
        }

        System.out.println(sb);


    }
}