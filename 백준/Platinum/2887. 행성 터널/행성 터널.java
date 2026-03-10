import java.io.*;
import java.util.*;

public class Main {

    public static class Planet {
        int id;
        int x;
        int y;
        int z;

        Planet(int id, int x, int y, int z) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static class Edge implements Comparable<Edge>{
        int p1;
        int p2;
        int cost;

        Edge(int p1, int p2, int cost) {
            this.p1 = p1;
            this.p2 = p2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Planet[] planets = new Planet[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            planets[i] = new Planet(i, x, y, z);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int axis = 0; axis < 3; axis++) {
            int idx = axis;
            Arrays.sort(planets, (o1, o2) -> {
                // x축 기준 정렬
                if (idx==0) return o1.x - o2.x;
                // y축 기준 정렬
                else if (idx == 1) return o1.y - o2.y;
                // z축 기준 정렬
                else return o1.z - o2.z;
            });

            for (int i = 0; i < n-1; i++) {
                pq.offer(new Edge(planets[i].id, planets[i+1].id, calculateCost(planets[i], planets[i+1])));
            }
        }

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int sum = 0;
        int count = 0;
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int rootA = find(edge.p1);
            int rootB = find(edge.p2);

            if (rootA != rootB) {
                sum += edge.cost;
                count++;
                union(rootA, rootB);

                if (count == n-1) break;
            }
        }

        System.out.println(sum);

    }

    public static int calculateCost(Planet a, Planet b) {
        int temp = Math.min(Math.abs(a.x - b.x), Math.abs(a.y - b.y));
        return Math.min(temp,  Math.abs(a.z - b.z));
    }

    public static int find(int a) {
        if (parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    public static void union(int rootA, int rootB) {
        parent[rootA] = rootB;
    }
}