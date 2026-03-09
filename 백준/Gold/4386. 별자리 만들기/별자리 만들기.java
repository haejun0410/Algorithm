import java.io.*;
import java.util.*;

public class Main {

    // 별의 좌표 정보만 저장 (idx는 배열 인덱스로 대체 가능)
    static class Star {
        double y, x;
        Star(double y, double x) {
            this.y = y;
            this.x = x;
        }
    }

    // 간선 정보를 담는 클래스
    static class Edge implements Comparable<Edge> {
        int start, end;
        double dist;

        Edge(int start, int end, double dist) {
            this.start = start;
            this.end = end;
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
        int n = Integer.parseInt(br.readLine());

        Star[] stars = new Star[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double y = Double.parseDouble(st.nextToken());
            double x = Double.parseDouble(st.nextToken());
            stars[i] = new Star(y, x);
        }

        // 모든 간선을 우선순위 큐에 삽입 (정렬 효과)
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pq.add(new Edge(i, j, computeDistance(stars[i], stars[j])));
            }
        }

        // Union-Find 초기화
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        double sum = 0;
        int count = 0; // 선택된 간선 수

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int root1 = find(edge.start);
            int root2 = find(edge.end);

            if (root1 != root2) {
                union(root1, root2);
                sum += edge.dist;
                count++;
                
                // MST 완성 조건: 간선 수가 (정점 - 1)개가 되면 종료
                if (count == n - 1) break;
            }
        }

        System.out.printf("%.2f\n", sum);
    }

    public static double computeDistance(Star s1, Star s2) {
        return Math.sqrt(Math.pow(s1.y - s2.y, 2) + Math.pow(s1.x - s2.x, 2));
    }

    public static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]); // Path Compression
    }

    // 이미 찾은 root 값을 사용하여 중복 연산 제거
    public static void union(int root1, int root2) {
        if (root1 < root2) parent[root2] = root1;
        else parent[root1] = root2;
    }
}