import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n : 가수의 수
        int n = Integer.parseInt(st.nextToken());
        // m : 보조 pd의 수
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();
        int[] indegree = new int[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int curr =  Integer.parseInt(st.nextToken());
            for (int idx = 0; idx < p-1; idx++) {
                int next = Integer.parseInt(st.nextToken());
                adj[curr].add(next);
                indegree[next]++;
                curr = next;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < n+1; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;
            sb.append(curr).append("\n");

            for (int next : adj[curr]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        if (count == n) {
            System.out.println(sb);
        }
        else {
            System.out.println(0);
        }

    }
}