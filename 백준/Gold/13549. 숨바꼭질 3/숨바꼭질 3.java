import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] visited = new int[100001];
        Arrays.fill(visited, -1);

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(n);
        visited[n] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current * 2 <= 100000 && visited[current * 2] == -1) {
                visited[current * 2] = visited[current];
                queue.offerFirst(current * 2);
            }

            if (current - 1 >= 0 && visited[current - 1] == -1) {
                visited[current - 1] = visited[current] + 1;
                queue.offerLast(current - 1);
            }

            if (current + 1 <= 100000 && visited[current + 1] == -1) {
                visited[current + 1] = visited[current] + 1;
                queue.offerLast(current + 1);
            }
        }

        System.out.println(visited[m]);
    }
}
