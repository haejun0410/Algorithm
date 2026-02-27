import java.io.*;
import java.util.*;

public class Main {

    public static class Node implements Comparable<Node> {
        int idx, dist;

        Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    static ArrayList<Node>[] adj;
    static int[] distance;
    static int[] parent; // 최단 경로 추적 배열
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
            adj[v].add(new Node(u, w));
        }

        // 다익스트라 실행 -> 최단 경로를 찾기
        parent = new int[N + 1];
        dijkstra(-1, -1); 

        // 최단 경로에 포함된 간선들을 리스트에 담기
        List<int[]> shortestPathEdges = new ArrayList<>();
        int curr = N;
        while (curr != 1) {
            shortestPathEdges.add(new int[]{parent[curr], curr});
            curr = parent[curr];
        }

        // 최단 경로 상의 간선을 하나씩 부수며 최대 최단 거리 찾기
        int maxDist = 0;
        for (int[] edge : shortestPathEdges) {
            // edge[0] - edge[1] 사이의 다리를 부쉈을 때의 다익스트라
            int res = dijkstra(edge[0], edge[1]);
            if (res != Integer.MAX_VALUE) {
                maxDist = Math.max(maxDist, res);
            }
        }

        System.out.println(maxDist);
    }

    public static int dijkstra(int excludeU, int excludeV) {
        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        distance[1] = 0;
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.dist > distance[curr.idx]) continue;

            for (Node next : adj[curr.idx]) {
                // 부순 다리라면 건너지 않음
                if ((curr.idx == excludeU && next.idx == excludeV) || 
                    (curr.idx == excludeV && next.idx == excludeU)) continue;

                if (distance[next.idx] > distance[curr.idx] + next.dist) {
                    distance[next.idx] = distance[curr.idx] + next.dist;
                    // 처음 실행할 때만(부순 다리가 없을 때) 경로를 기록
                    if (excludeU == -1) parent[next.idx] = curr.idx;
                    pq.offer(new Node(next.idx, distance[next.idx]));
                }
            }
        }
        return distance[N];
    }
}