import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] used;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int dist1 = bfs(S, E, new boolean[N + 1]);

        used = new boolean[N + 1];
        int temp = parent[E];
        while (temp != S) {
            used[temp] = true;
            temp = parent[temp];
        }

        int dist2 = bfs(E, S, used);

        System.out.println(dist1 + dist2);
    }

    static int bfs(int start, int end, boolean[] isVisited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        isVisited[start] = true;
        parent = new int[N + 1];

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int dist = curr[1];

            if (node == end) return dist;

            for (int next : adj[node]) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    parent[next] = node;
                    q.add(new int[]{next, dist + 1});
                }
            }
        }
        return 0;
    }
}