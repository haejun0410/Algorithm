import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Integer>> adj;
    static boolean[] visited;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            dfs(i, 1);
            if (found) break;
        }

        System.out.println(found ? 1 : 0);
    }

    static void dfs(int node, int depth) {
        if (depth == 5) { 
            found = true;
            return;
        }

        visited[node] = true;

        for (int next : adj.get(node)) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }

        visited[node] = false;
    }
}
