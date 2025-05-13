import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static List<List<Integer>> adj;
    static int[] visited;
    static int order = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        visited = new int[n];

        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;

            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        for(int i=0; i<n; i++) {
            Collections.sort(adj.get(i), Collections.reverseOrder());
        }

        visited[r-1] = order;
        dfs(r-1);

        for(int i=0; i<n; i++) {
            System.out.println(visited[i]);
        }
        
    }

    public static void dfs(int node) {

        for(int next : adj.get(node)) {
            if (visited[next] == 0) {
                visited[next] = ++order;
                dfs(next);
            }
        }
    }
}
