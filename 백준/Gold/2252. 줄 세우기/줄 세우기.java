import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        // N명의 학생
        int n = Integer.parseInt(st.nextToken());
        // m번의 배교
        int m = Integer.parseInt(st.nextToken());

        int[] indegrees = new int[n+1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adj.get(from).add(to);
            indegrees[to]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!queue.isEmpty()) {
                int curr = queue.poll();
                sb.append(curr).append(" ");

                for (int next : adj.get(curr)) {
                    indegrees[next]--;

                    if (indegrees[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

        System.out.println(sb);
    }
}