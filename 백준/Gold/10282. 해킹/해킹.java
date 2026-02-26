import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Node>> adj;
    static int[] distance;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= TC; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }

            distance = new int[n + 1];
            Arrays.fill(distance, INF);

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                adj.get(from).add(new Node(to, time));
            }

            dijkstra(start);

            int count = 0;
            int maxTime = 0;
            for (int i = 1; i <= n; i++) {
                if (distance[i] != INF) {
                    count++;
                    maxTime = Math.max(maxTime, distance[i]);
                }
            }
            System.out.println(count + " " + maxTime);
        }
    }

    public static class Node implements Comparable<Node> {
        int to;
        int dist;

        Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node other) {
            return this.dist - other.dist;
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int currTo = curr.to;
            int currDist = curr.dist;

            // 이미 처리된 적이 있고, 현재 기록된 거리가 더 짧다면 스킵
            if (distance[currTo] < currDist) continue;

            for (Node next : adj.get(currTo)) {

                if (distance[next.to] > distance[currTo] + next.dist) {
                    distance[next.to] = distance[currTo] + next.dist;
                    pq.offer(new Node(next.to, distance[next.to]));
                }
            }
        }
    }
}