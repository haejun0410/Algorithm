import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            adj.get(e1).add(e2);
            adj.get(e2).add(e1);
        }

        for(int i=0; i<n; i++) {
            Collections.sort(adj.get(i));
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        int[] order = new int[n+1];
        int cnt = 1;
        queue.offer(r);
        visited[r] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            order[current] = cnt;
            cnt++;

            for(Integer node : adj.get(current)) {
                if (!visited[node]) {
                    queue.offer(node);
                    visited[node] = true;
                }
            }
        }

        for(int i=1; i<=n; i++) {
            System.out.println(order[i]);
        }

    }
}

