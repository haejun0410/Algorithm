import java.util.*;
import java.io.*;

public class Main {

    public static class Node implements Comparable<Node>{
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

    static ArrayList<ArrayList<Node>> adj;
    static int[] distance;
    static int[] before;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // n개의 컴퓨터
        int n = Integer.parseInt(st.nextToken());
        // m개의 회선
        int m = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj.get(a).add(new Node(b, c));
            adj.get(b).add(new Node(a, c));
        }

        distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        before = new int[n+1];

        dijkstra(1);

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            if (before[i] != 0) {
                count++;
                sb.append(i).append(" ").append(before[i]).append("\n");
            }
        }

        System.out.println(count);
        System.out.print(sb.toString());
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Node curr = pq.poll();

            if (distance[curr.idx] < curr.dist) continue;

            for(Node next : adj.get(curr.idx)) {
                if (distance[next.idx] > curr.dist + next.dist) {
                    distance[next.idx] = curr.dist + next.dist;
                    pq.offer(new Node(next.idx, distance[next.idx]));
                    before[next.idx] = curr.idx;
                }
            }
        }
    }
}