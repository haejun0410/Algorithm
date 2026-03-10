import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    public static class Edge implements Comparable<Edge>{
        int x;
        int y;
        int z;

        Edge(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Edge o) {
            return this.z - o.z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if (m == 0 && n ==0) break;
            int before = 0;
            Edge[] edges = new Edge[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                edges[i] = new Edge(x, y, z);
                before += z;
            }

            Arrays.sort(edges);

            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            int after = 0;
            int count = 0;
            for (Edge edge : edges) {
                // 사이클이 생기는지 체크
                int rootX = find(edge.x);
                int rootY = find(edge.y);

                if (rootX != rootY) {
                    union(rootX, rootY);
                    after += edge.z;
                    count++;
                    if (count == m-1) break;
                }
            }

            sb.append(before - after).append("\n");

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
}