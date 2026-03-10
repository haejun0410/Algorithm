import java.io.*;
import java.util.*;

public class Main {

    public static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(x, y);
        }

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(i, j, calculateDist(nodes[i], nodes[j])));
            }
        }

        Collections.sort(edges);

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) -1;
            int b = Integer.parseInt(st.nextToken()) -1;
            union(find(a), find(b));
        }

        double dist = 0;
        int count = 0;
        for (Edge edge : edges) {
            int rootA = find(edge.p1);
            int rootB = find(edge.p2);

            if (rootA != rootB) {
                union(rootA, rootB);
                count++;
                dist += edge.dist;

                if (count == n-1) break;
            }
        }

        System.out.print(String.format("%.2f", dist));
    }

    public static double calculateDist(Node a, Node b) {
        return Math.sqrt((Math.pow((a.x - b.x), 2)) + (Math.pow((a.y - b.y), 2)));
    }

    public static int find(int a) {
        if (parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    public static void union(int rootA, int rootB) {
        parent[rootA] = rootB;
    }
}