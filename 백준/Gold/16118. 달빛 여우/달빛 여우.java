import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Node>[] adj;
    static int[] distanceFox;
    static int[][] distanceWolf;

    public static class Node implements Comparable<Node>{
        int to;
        int dist;
        int run;

        Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
            this.run = 0;
        }
        Node(int to, int dist, int run) {
            this.to = to;
            this.dist = dist;
            this.run = run;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i <m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken()) * 2;

            adj[from].add(new Node(to, dist));
            adj[to].add(new Node(from, dist));
        }

        distanceFox = new int[n+1];
        // 0 : 느리게, 1 : 빠르게
        distanceWolf = new int[n+1][2];
        Arrays.fill(distanceFox, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) {
            Arrays.fill(distanceWolf[i], Integer.MAX_VALUE);
        }

        dijkstraFox();
        dijkstraWolf();

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (distanceFox[i] < Math.min(distanceWolf[i][0], distanceWolf[i][1])) count++;
        }

        System.out.println(count);
    }

    public static void dijkstraFox() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        distanceFox[1] = 0;
        pq.offer(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int to = curr.to;
            int dist = curr.dist;

            if (distanceFox[to] < dist) continue;

            for (Node next : adj[to]) {
                int nextTo = next.to;
                int nextDist = next.dist;

                if (distanceFox[nextTo] > dist + next.dist) {
                    distanceFox[nextTo] = dist + next.dist;
                    pq.offer(new Node(nextTo, distanceFox[nextTo]));
                }
            }
        }

    }

    public static void dijkstraWolf() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        distanceWolf[1][0] = 0;
        //distanceWolf[1][1] = 0;
        pq.offer(new Node(1, 0,0));

        while(!pq.isEmpty()) {
            Node curr = pq.poll();

            int to = curr.to;
            int dist = curr.dist;
            int run = curr.run;

            if (distanceWolf[to][run] < dist) continue;

            for (Node next : adj[to]) {
                int nextTo = next.to;
                int nextDist = next.dist;
                int nextRun = 1 - run;

                int val = dist + (run == 0 ? nextDist / 2 : nextDist * 2);
                if (distanceWolf[nextTo][nextRun] > val) {
                    distanceWolf[nextTo][nextRun] = val;
                    pq.offer(new Node(nextTo, distanceWolf[nextTo][nextRun], nextRun));
                }
            }
        }

    }
}