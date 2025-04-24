import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] visited = new int[100001];
        int[] count = new int[100001];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n] = 0;
        count[n] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : new int[]{current - 1, current + 1, current * 2}) {
                if (next < 0 || next > 100000) continue;

                if (visited[next] == 0 && next != n) {
                    visited[next] = visited[current] + 1;
                    count[next] = count[current];
                    queue.offer(next);
                } else if (visited[next] == visited[current] + 1) {
                    count[next] += count[current];
                }
            }
        }

        System.out.println(visited[k]);
        System.out.println(count[k]);
    }
}
