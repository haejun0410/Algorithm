import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<int[]>> adj;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adj.get(from).add(new int[] {to, weight});
        }

        distance = new int[v + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            sb.append(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        distance[start] = 0;
        pq.offer(new int[] {start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currNode = current[0];
            int currDist = current[1];

            if (distance[currNode] < currDist) continue;

            for (int[] edge : adj.get(currNode)) {
                int nextNode = edge[0];
                int nextWeight = edge[1];

                if (distance[nextNode] > distance[currNode] + nextWeight) {
                    distance[nextNode] = distance[currNode] + nextWeight;
                    pq.offer(new int[] {nextNode, distance[nextNode]});
                }
            }
        }
    }
}