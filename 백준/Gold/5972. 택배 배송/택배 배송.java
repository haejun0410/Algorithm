import java.util.*;
import java.io.*;

public class Main {

    public static class Edge implements Comparable<Edge> {
        int idx;
        int dist;

        Edge(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
    }

    static int n, m;
    static ArrayList<Edge>[] adj;
    static int[] distance;

    public static void main(String[] arsg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[from].add(new Edge(to, cost));
            adj[to].add(new Edge(from, cost));
        }

        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        dijkstra();

        System.out.println(distance[n]);

    }

    public static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));
        distance[1] = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (distance[curr.idx] < curr.dist)
                continue;

            for (Edge next : adj[curr.idx]) {
                if (distance[next.idx] > curr.dist + next.dist) {
                    distance[next.idx] = curr.dist + next.dist;
                    pq.offer(new Edge(next.idx, distance[next.idx]));
                }
            }
        }
    }
}