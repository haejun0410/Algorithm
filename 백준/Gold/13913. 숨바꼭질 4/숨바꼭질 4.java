import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        int[] visited = new int[100001];
        Arrays.fill(visited, -1);

        queue.offer(n);
        visited[n] = n;

        while(!queue.isEmpty()) {
            int curr = queue.poll();

            if (curr == k) break;

            for(int next : new int[] {curr * 2, curr + 1, curr - 1}) {
                if (next >= 0 && next <= 100000 && visited[next] == -1) {
                    visited[next] = curr;
                    queue.offer(next);
                }
            }
        }

        int time = 0;
        boolean flag = true;

        Stack<Integer> stack = new Stack<>();
        int next = k;

        while(flag) {
            stack.push(next);
            time++;
            if (next == n) {
                flag = false;
            }
            else {
                next = visited[next];
            }
        }
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(time-1);
        System.out.println(sb);
    }
}
