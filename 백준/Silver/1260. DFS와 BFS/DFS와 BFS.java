import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> adj;
    static int n,m;
    static ArrayList<Integer> bfsList = new ArrayList<>();
    static ArrayList<Integer> dfsList = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for(int i=0; i<n+1; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        for(int i=0; i<n+1; i++) {
            Collections.sort(adj.get(i));
        }

        visited = new boolean[n + 1];
        dfs(v);
        for (int node : dfsList) System.out.print(node + " ");
        System.out.println();

        visited = new boolean[n + 1];
        bfs(v);
        for (int node : bfsList) System.out.print(node + " ");
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            bfsList.add(curr);
            for(int next : adj.get(curr)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }

    public static void dfs(int curr) {
        visited[curr] = true;
        dfsList.add(curr);

        for(int next : adj.get(curr)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
