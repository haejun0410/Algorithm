import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<int[]>> adj;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();

        for (int i = 0; i < n+1; i++) {
            adj.add(new ArrayList<>());
        }

        int max = -1;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            max = Math.max(max, weight);

            adj.get(from).add(new int[] {to, weight});
            adj.get(to).add(new int[] {from, weight});
        }

        st = new StringTokenizer(br.readLine());

        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        distance = new int[n+1];
        Arrays.fill(distance, - 1);

        dijkstra(p1);

        System.out.println(distance[p2]);
    }

    public static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o2[1] - o1[1];
        });

        distance[start] = Integer.MAX_VALUE;
        pq.offer(new int[] {start, Integer.MAX_VALUE});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int index = curr[0];
            int weight = curr[1];

            if (distance[index] > weight) continue;

            for (int[] next : adj.get(index)) {
                int to = next[0];
                int w = next[1];

                if (distance[to] < Math.min(weight, w)) {
                    distance[to] = Math.min(weight, w);
                    pq.offer(new int[] {to, distance[to]});
                }
            }

        }
    }
}