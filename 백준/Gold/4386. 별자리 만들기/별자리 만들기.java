import java.io.*;
import java.util.*;

public class Main {

    public static class Star {
        int idx;
        double y;
        double x;

        Star(int idx, double y, double x) {
            this.idx = idx;
            this.y = y;
            this.x = x;
        }
    }

    public static class StarEdge implements Comparable<StarEdge>{
        int p1;
        int p2;
        double dist;

        StarEdge(int p1, int p2, double dist) {
            this.p1 = p1;
            this.p2 = p2;
            this.dist = dist;
        }

        @Override
        public int compareTo(StarEdge o) {
            return Double.compare(this.dist, o.dist);
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Star[] stars = new Star[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            double y = Double.parseDouble(st.nextToken());
            double x = Double.parseDouble(st.nextToken());

            stars[i] = new Star(i, y, x);
        }

        ArrayList<StarEdge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = computeDistance(stars[i], stars[j]);
                edges.add(new StarEdge(i, j, distance));
            }
        }

        Collections.sort(edges);
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        double sum = 0;

        for (StarEdge edge : edges) {
            int s1 = edge.p1;
            int s2 = edge.p2;

            if (find(s1) != find(s2)) {
                sum += edge.dist;
                union(s1, s2);
            }
        }

        System.out.println(String.format("%.2f", sum));

    }

    public static double computeDistance(Star s1, Star s2) {
        return Math.sqrt((Math.pow((s1.y - s2.y), 2)) + (Math.pow((s1.x - s2.x), 2)));
    }

    public static int find(int a) {
        if (parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootA] = rootB;
        }
    }
}