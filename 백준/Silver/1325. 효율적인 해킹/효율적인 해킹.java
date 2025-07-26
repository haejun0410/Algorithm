import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> computers;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        computers = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            computers.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            computers.get(B).add(A);
        }

        int[] result = new int[n + 1];
        int maxCount = 0;
        
        for (int i = 1; i <= n; i++) {
            int cnt = bfs(i);
            result[i] = cnt;
            maxCount = Math.max(maxCount, cnt);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (result[i] == maxCount) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static int bfs(int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : computers.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        return count;
    }
}
