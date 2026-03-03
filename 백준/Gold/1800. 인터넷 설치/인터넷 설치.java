import java.util.*;
import java.io.*;

public class Main {
    static int n, p, k;
    static ArrayList<Node>[] adj;
    static int[] count;

    static class Node implements Comparable<Node> {
        int to, weight;
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        int maxWeight = 0;
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
            maxWeight = Math.max(maxWeight, c);
        }

        int left = 0;
        int right = maxWeight;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (dijkstra(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }

    static boolean dijkstra(int limit) {
        count = new int[n + 1];
        Arrays.fill(count, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        count[1] = 0;
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (count[curr.to] < curr.weight) continue;

            for (Node next : adj[curr.to]) {
                int cost = next.weight > limit ? 1 : 0;
                
                if (count[next.to] > count[curr.to] + cost) {
                    count[next.to] = count[curr.to] + cost;
                    pq.offer(new Node(next.to, count[next.to]));
                }
            }
        }
        return count[n] <= k;
    }
}