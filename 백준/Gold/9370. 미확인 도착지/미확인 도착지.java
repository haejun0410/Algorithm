import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Node>[] adj;
    static int n;

    public static class Node implements Comparable<Node> {
        int idx;
        int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= TC; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            adj = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }

            int ghDist = 0;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                adj[a].add(new Node(b, d));
                adj[b].add(new Node(a, d));
                
                if ((a == g && b == h) || (a == h && b == g)) {
                    ghDist = d;
                }
            }

            int[] candidates = new int[t];
            for (int i = 0; i < t; i++) {
                candidates[i] = Integer.parseInt(br.readLine());
            }
            
            int[] distS = dijkstra(s);
            int[] distG = dijkstra(g);
            int[] distH = dijkstra(h);

            Arrays.sort(candidates);

            for (int target : candidates) {
                if (distS[target] == Integer.MAX_VALUE) continue;

                // 1. s -> g -> h -> target
                long path1 = (long) distS[g] + ghDist + distH[target];
                // 2. s -> h -> g -> target
                long path2 = (long) distS[h] + ghDist + distG[target];

                // 둘 중 하나라도 s -> target 최단 거리와 같다면 정답
                if (distS[target] == path1 || distS[target] == path2) {
                    sb.append(target).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    
    public static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (distance[curr.idx] < curr.dist) continue;

            for (Node next : adj[curr.idx]) {
                if (distance[next.idx] > distance[curr.idx] + next.dist) {
                    distance[next.idx] = distance[curr.idx] + next.dist;
                    pq.offer(new Node(next.idx, distance[next.idx]));
                }
            }
        }
        return distance;
    }
}