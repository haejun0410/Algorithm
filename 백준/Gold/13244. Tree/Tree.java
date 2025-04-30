import java.io.*;
import java.util.*;

public class Main {
    static int n,m;

    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) {
            // 노드의 수
            int n = Integer.parseInt(br.readLine());
            // 간선의 수
            int m = Integer.parseInt(br.readLine());

            adj = new ArrayList[n+1];

            for(int i=1; i<n+1; i++) {
                adj[i] = new ArrayList<>();
            }
            visited = new boolean[n+1];

            for(int i=0; i<m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());

                adj[node1].add(node2);
                adj[node2].add(node1);
            }

            int cnt = 0;
            for(int i=1; i<=n; i++) {
                if (!visited[i]) {
                    dfs(i);
                    cnt++;
                }
            }

            if (cnt == 1 && (n-m) == 1) {
                sb.append("tree").append("\n");
            }
            else {
                sb.append("graph").append("\n");
            }


        }

        System.out.println(sb);
        
    }

    public static void dfs(int start) {
        visited[start] = true;

        for( int node:adj[start] ) {
            if(!visited[node]) {
                dfs(node);
            }
        }
    }
}
