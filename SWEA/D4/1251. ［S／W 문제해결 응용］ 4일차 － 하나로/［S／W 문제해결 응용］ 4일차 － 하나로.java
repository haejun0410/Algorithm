import java.io.*;
import java.util.*;

public class Solution {
    

    public static class Edge implements Comparable<Edge>{
        int p1;
        int p2;
        double dist;

        Edge(int p1, int p2, double dist) {
            this.p1 = p1;
            this.p2 = p2;
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
            ArrayList<Edge> edges = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = i +1; j < n; j++) {
                    edges.add(new Edge(i, j, calculateCost(nodes[i], nodes[j], rate)));
                }
            }

            Collections.sort(edges);
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

            double answer = 0;
            int count = 0;

            for (Edge edge : edges) {
                int rootA = find(edge.p1);
                int rootB = find(edge.p2);

                if (rootA != rootB) {
                    union(rootA, rootB);
                    answer += edge.dist;
                    count++;

                    if (count == n-1) break;
                }
            }

            sb.append("#").append(testCase).append(" ").append(Math.round(answer)).append("\n");
        }

        System.out.print(sb);
    }

    public static int find(int a) {
        if (parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    public static void union(int rootA, int rootB) {
        parent[rootA] = rootB;
    }

    public static double calculateCost(int[] p1, int[] p2, double rate) {
        long xDiff = p1[0] - p2[0];
        long yDiff = p1[1] - p2[1];

        return (xDiff*xDiff + yDiff*yDiff) * rate;
    }
}