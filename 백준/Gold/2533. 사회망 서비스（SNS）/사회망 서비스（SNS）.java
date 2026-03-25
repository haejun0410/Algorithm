import java.util.*;
import java.io.*;

public class Main {
    
    static ArrayList<Integer>[] adj;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        dp = new int[n + 1][2];
        visited = new boolean[n + 1];

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            
            adj[from].add(to);
            adj[to].add(from);
        }

        dfs(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int u) {
        visited[u] = true;
        
        dp[u][0] = 0;
        dp[u][1] = 1;

        for (int v : adj[u]) {
            if (!visited[v]) {
                dfs(v);
                
                // 내가 얼리어답터가 아니면, 자식 v는 무조건 얼리어답터여야 함
                dp[u][0] += dp[v][1];
                
                // 내가 얼리어답터면, 자식 v는 뭐든 상관없음
                dp[u][1] += Math.min(dp[v][0], dp[v][1]);
            }
        }
    }
}