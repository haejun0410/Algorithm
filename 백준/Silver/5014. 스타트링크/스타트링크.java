import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] visited = new int[f+1];

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(s);
        visited[s] = 1;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            if (current == g) break;

            for(int diff:new int[] {u, -d}) {
                int next = current + diff;
                if (next >=1 && next <= f && visited[next] == 0) {
                    visited[next] = visited[current] + 1;
                    queue.offer(next);
                }
            }   
        }

        if (visited[g] == 0) {
            System.out.println("use the stairs");
        }
        else {
            System.out.println(visited[g] - 1);
        }
	}
}

