import java.io.*;
import java.util.*;

public class Main {

    static class Info implements Comparable<Info> {
        int deadline, num;

        public Info(int d, int n) {
            this.deadline = d;
            this.num = n;
        }

        @Override
        public int compareTo(Info o) {
            return o.num - this.num; 
        }
    }

    static int[] parent;

    static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        parent[x] = y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Info> pq = new PriorityQueue<>();
        int maxDeadline = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            pq.offer(new Info(d, num));
            maxDeadline = Math.max(maxDeadline, d);
        }

        parent = new int[maxDeadline + 1];
        for (int i = 0; i <= maxDeadline; i++) {
            parent[i] = i;
        }

        int answer = 0;

        while (!pq.isEmpty()) {
            Info cur = pq.poll();
            int available = find(cur.deadline);

            if (available > 0) {
                answer += cur.num;
                union(available, available - 1); 
            }
        }

        System.out.println(answer);
    }
}
