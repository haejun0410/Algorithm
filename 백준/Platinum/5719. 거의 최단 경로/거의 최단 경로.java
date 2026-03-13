import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static List<Edge>[] adj;
    static List<Edge>[] revAdj;
    static int[] dist;
    static boolean[][] isShortestEdge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            adj = new ArrayList[n];
            revAdj = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
                revAdj[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                adj[u].add(new Edge(v, p));
                revAdj[v].add(new Edge(u, p)); // 역방향 저장
            }

            isShortestEdge = new boolean[n][n];
            dist = new int[n];
            
            // 1. 최단 거리 찾기
            dijkstra(s, d, n);
            
            // 2. 최단 경로에 포함된 모든 간선 마킹
            backtrack(d, s);
            
            // 3. 마킹된 간선을 제외하고 최단 거리 찾기
            int result = dijkstra(s, d, n);
            System.out.println(result == Integer.MAX_VALUE ? -1 : result);
        }
    }

    // 역추적
    static void backtrack(int end, int start) {
        if (end == start) return;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(end);
        boolean[] visited = new boolean[dist.length];

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == start) continue;

            for (Edge prev : revAdj[curr]) {
                // (이전 노드까지의 거리 + 현재 간선 가중치 == 현재 노드까지의 거리)라면 최단 경로에 포함된 간선임
                if (dist[prev.to] + prev.weight == dist[curr]) {
                    if (!isShortestEdge[prev.to][curr]) {
                        isShortestEdge[prev.to][curr] = true;
                        queue.add(prev.to);
                    }
                }
            }
        }
    }

    static int dijkstra(int start, int end, int n) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (dist[curr.to] < curr.weight) continue;
            for (Edge next : adj[curr.to]) {
            	if (isShortestEdge[curr.to][next.to]) continue;
                if (dist[next.to] > dist[curr.to] + next.weight) {
                    dist[next.to] = dist[curr.to] + next.weight;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }
        }
        
        return dist[end];
    }
}