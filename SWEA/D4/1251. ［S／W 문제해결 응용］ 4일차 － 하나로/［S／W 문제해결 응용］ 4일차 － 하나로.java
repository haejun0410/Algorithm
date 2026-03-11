import java.io.*;
import java.util.*;

public class Solution {

    public static class Edge implements Comparable<Edge>{
        int p;
        double dist;

        Edge(int p, double dist) {
            this.p = p;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.dist, o.dist);
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= TC; testCase++) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer stX = new StringTokenizer(br.readLine());
            StringTokenizer stY = new StringTokenizer(br.readLine());

            int[][] nodes = new int[n][2];

            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(stX.nextToken());
                int y = Integer.parseInt(stY.nextToken());

                nodes[i] = new int[] {x, y};
            }

            double rate = Double.parseDouble(br.readLine());
            ArrayList<Edge>[] adj = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                for (int j = i +1; j < n; j++) {
                    adj[i].add(new Edge(j, calculateCost(nodes[i], nodes[j], rate)));
                    adj[j].add(new Edge(i, calculateCost(nodes[i], nodes[j], rate)));
                }
            }

            boolean[] visited = new boolean[n+1];
            PriorityQueue<Edge> pq = new PriorityQueue<>();

            visited[0] = true;
            pq.addAll(adj[0]);

            double answer = 0;
            int count = 0;

            while(!pq.isEmpty() && count < n-1) {
                Edge edge = pq.poll();

                if (visited[edge.p]) continue;

                visited[edge.p] = true;
                answer += edge.dist;
                count++;

                for (Edge next : adj[edge.p]) {
                    if (!visited[next.p]) {
                        pq.offer(next);
                    }
                }
            }

            sb.append("#").append(testCase).append(" ").append(Math.round(answer)).append("\n");
        }

        System.out.print(sb);
    }


    public static double calculateCost(int[] p1, int[] p2, double rate) {
        long xDiff = p1[0] - p2[0];
        long yDiff = p1[1] - p2[1];

        return (xDiff*xDiff + yDiff*yDiff) * rate;
    }
}