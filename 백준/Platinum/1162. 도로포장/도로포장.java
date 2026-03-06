import java.io.*;
import java.util.*;

public class Main {

    public static class Node implements Comparable<Node>{
        int idx;
        long dist;
        int paveCount;

        Node(int idx, long dist) {
            this.idx = idx;
            this.dist = dist;
            this.paveCount = 0;
        }

        Node (int idx, long dist, int paveCount) {
            this.idx = idx;
            this.dist = dist;
            this.paveCount = paveCount;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.dist, o.dist);
        }

    }

    static ArrayList<Node>[] adj;
    static long[][] distance;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 도시의 수
        n = Integer.parseInt(st.nextToken());
        // 도로의 수
        int m = Integer.parseInt(st.nextToken());
        // 포장할 도로의 수
        k = Integer.parseInt(st.nextToken());

        // 도로 정보
        adj = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }
        // 1번째 인덱스개의 포장을 했을 때 0번째 인덱스 도시까지의 거리
        distance = new long[n+1][k+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(distance[i], Long.MAX_VALUE);
        }

        System.out.println(dijkstra());
    }

    public static long dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[0][0] = 0;
        pq.offer(new Node(1, 0, 0));

        while(!pq.isEmpty()) {
            Node curr = pq.poll();

            if (distance[curr.idx][curr.paveCount] < curr.dist) continue;

            for (Node next : adj[curr.idx]) {
                // 포장을 한다
                if (curr.paveCount != k) {
                    if (distance[next.idx][curr.paveCount+1] > curr.dist) {
                        distance[next.idx][curr.paveCount+1] = curr.dist;
                        pq.offer(new Node(next.idx, distance[next.idx][curr.paveCount+1], curr.paveCount+1));
                    }
                }
                // 포장을 하지 않는다.
                if (distance[next.idx][curr.paveCount] > curr.dist + next.dist) {
                    distance[next.idx][curr.paveCount] = curr.dist + next.dist;
                    pq.offer(new Node(next.idx, distance[next.idx][curr.paveCount], curr.paveCount));
                }
            }
        }

        long minVal = Long.MAX_VALUE;
        for (int i = 0; i < k+1; i++) {
            minVal = Math.min(minVal, distance[n][i]);
        }

        return minVal;
    }
}