import java.io.*;
import java.util.*;

public class Main {

    public static class Edge implements Comparable<Edge>{
        int p1;
        int p2;
        int dist;

        Edge(int p1, int p2, int dist) {
            this.p1 = p1;
            this.p2 = p2;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[] info = new char[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            info[i] = st.nextToken().charAt(0);
        }

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (info[a] != info[b]) {
                edges.add(new Edge(a, b, c));
            }
        }
        
        Collections.sort(edges);

        parent = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            parent[i] = i;
        }

        int answer = 0;
        int count = 0;

        for(Edge edge : edges) {
            int rootA = find(edge.p1);
            int rootB = find(edge.p2);

            if (rootA != rootB) {
                answer+=edge.dist;
                count++;
                union(rootA, rootB);
            }
        }

        System.out.println(count == n-1 ? answer : -1);
    }

    public static int find(int a) {
        if (parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    public static void union(int rootA, int rootB) {
        parent[rootA] = rootB;
    }
}