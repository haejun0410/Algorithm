
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
    static int[] distanceStar;
    static int[] distanceMac;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        adj = new ArrayList[v + 1];
        for (int i = 0; i <= v; i++) {
            adj[i] = new ArrayList<>();
        }
        distanceStar = new int[v + 1];
        Arrays.fill(distanceStar, Integer.MAX_VALUE);
        distanceMac = new int[v + 1];
        Arrays.fill(distanceMac, Integer.MAX_VALUE);

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adj[from].add(new Node(to, weight));
            adj[to].add(new Node(from, weight));
        }

        st = new StringTokenizer(br.readLine());
        int numMac = Integer.parseInt(st.nextToken());
        int isMac = Integer.parseInt(st.nextToken());
        HashSet<Integer> macSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numMac; i++) {
            macSet.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int numStar = Integer.parseInt(st.nextToken());
        int isStar = Integer.parseInt(st.nextToken());
        HashSet<Integer> starSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numStar; i++) {
            starSet.add(Integer.parseInt(st.nextToken()));
        }

        dijkstra(starSet, distanceStar);
        dijkstra(macSet, distanceMac);

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= v; i++) {
            if (!macSet.contains(i) && !starSet.contains(i)) {
                if (distanceMac[i] <= isMac && distanceStar[i] <= isStar) {
                    int val = distanceMac[i] + distanceStar[i];
                    min = Math.min(min, val);
                }
            }
        }

        System.out.print(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void dijkstra(HashSet<Integer> set, int[] distance) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Integer num : set) {
            pq.offer(new Node(num, 0));
            distance[num] = 0;
        }

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (distance[curr.idx] < curr.dist) {
                continue;
            }

            for (Node next : adj[curr.idx]) {

                if (distance[next.idx] > curr.dist + next.dist) {
                    distance[next.idx] = curr.dist + next.dist;
                    pq.offer(new Node(next.idx, distance[next.idx]));
                }
            }
        }
    }

}
