import java.util.*;
import java.io.*;

public class Main {
    static int N, M, islandIdx = 0, minTotal = Integer.MAX_VALUE;
    static int[][] map;
    static List<Edge> allBridges = new ArrayList<>();
    static boolean[] selected;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

    static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) { this.u = u; this.v = v; this.w = w; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) markIsland(i, j, ++islandIdx, visited);
            }
        }
        
        Map<String, Integer> bridgeMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) findBridges(i, j, map[i][j], bridgeMap);
            }
        }
        for (String key : bridgeMap.keySet()) {
            String[] split = key.split(",");
            allBridges.add(new Edge(Integer.parseInt(split[0]), Integer.parseInt(split[1]), bridgeMap.get(key)));
        }
        
        selected = new boolean[allBridges.size()];
        backtrack(0, 0);

        System.out.println(minTotal == Integer.MAX_VALUE ? -1 : minTotal);
    }

    static void backtrack(int idx, int currentSum) {
        if (currentSum >= minTotal) return;

        if (idx == allBridges.size()) {
            if (isConnected()) {
                minTotal = Math.min(minTotal, currentSum);
            }
            return;
        }
        
        selected[idx] = true;
        backtrack(idx + 1, currentSum + allBridges.get(idx).w);
        
        selected[idx] = false;
        backtrack(idx + 1, currentSum);
    }

    static boolean isConnected() {
        if (islandIdx == 0) return true;
        List<Integer>[] adj = new ArrayList[islandIdx + 1];
        for (int i = 1; i <= islandIdx; i++) adj[i] = new ArrayList<>();

        int count = 0;
        for (int i = 0; i < selected.length; i++) {
            if (selected[i]) {
                Edge e = allBridges.get(i);
                adj[e.u].add(e.v);
                adj[e.v].add(e.u);
                count++;
            }
        }
        if (count < islandIdx - 1) return false;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean[] v = new boolean[islandIdx + 1];
        v[1] = true;
        int visitedCount = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : adj[cur]) {
                if (!v[next]) {
                    v[next] = true;
                    visitedCount++;
                    q.add(next);
                }
            }
        }
        return visitedCount == islandIdx;
    }
    
    static void markIsland(int r, int c, int id, boolean[][] v) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        v[r][c] = true;
        map[r][c] = id;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d], nc = cur[1] + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 1 && !v[nr][nc]) {
                    v[nr][nc] = true;
                    map[nr][nc] = id;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }

    static void findBridges(int r, int c, int startId, Map<String, Integer> bMap) {
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d], nc = c + dc[d], len = 0;
            while (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (map[nr][nc] == startId) break;
                if (map[nr][nc] > 0) {
                    if (len >= 2) {
                        int u = Math.min(startId, map[nr][nc]);
                        int v = Math.max(startId, map[nr][nc]);
                        String key = u + "," + v;
                        bMap.put(key, Math.min(bMap.getOrDefault(key, 100), len));
                    }
                    break;
                }
                nr += dr[d]; nc += dc[d]; len++;
            }
        }
    }
}