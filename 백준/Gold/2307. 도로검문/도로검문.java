
import java.io.*;
import java.util.*;

public class Main {

    public static class Node implements Comparable<Node> {

        int idx;
        int dist;

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
    static int n;
    static int[] root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adj[from].add(new Node(to, weight));
            adj[to].add(new Node(from, weight));
        }

        root = new int[n + 1];
        Arrays.fill(root, -1);
        int before = dijkstra(-1, -1);

        int idx = n;
        int max = -1;
        while (root[idx] != -1) {
            int next = root[idx];
            int val = dijkstra(idx, next);
            idx = next;

            max = Math.max(val, max);
        }
        System.out.println(max == Integer.MAX_VALUE ? -1 : max - before);
    }

    public static int dijkstra(int banStart, int banEnd) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[1] = 0;
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (distance[curr.idx] < curr.dist) {
                continue;
            }

            for (Node next : adj[curr.idx]) {
                if ((curr.idx == banStart && next.idx == banEnd)
                        || (curr.idx == banEnd && next.idx == banStart)) {
                    continue;
                }

                if (distance[next.idx] > curr.dist + next.dist) {
                    distance[next.idx] = curr.dist + next.dist;
                    if (banStart == -1) {
                        root[next.idx] = curr.idx;
                    }
                    pq.offer(new Node(next.idx, distance[next.idx]));
                }
            }
        }

        return distance[n];
    }
}
