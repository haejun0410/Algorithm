import java.io.*;
import java.util.*;

public class Main {
    static int MAX = 100001;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
            System.out.println(n);
            return;
        }

        int[] dist = new int[MAX];
        int[] prev = new int[MAX];
        boolean[] visited = new boolean[MAX];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n] = true;
        dist[n] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (next < 0 || next >= MAX) continue;

                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[now] + 1;
                    prev[next] = now;
                    queue.offer(next);

                    if (next == k) {
                        break;
                    }
                }
            }
        }

        System.out.println(dist[k]);

        Stack<Integer> stack = new Stack<>();
        int curr = k;
        while (curr != n) {
            stack.push(curr);
            curr = prev[curr];
        }
        stack.push(n);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
