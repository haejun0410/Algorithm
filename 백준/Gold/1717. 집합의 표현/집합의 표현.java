import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        rank = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 0) {
                union(a, b);
            } else {
                sb.append(find(a) == find(b) ? "YES" : "NO").append("\n");
            }
        }
        System.out.print(sb);
    }

    public static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else {
                parent[rootB] = rootA;
                if (rank[rootA] == rank[rootB]) {
                    rank[rootA]++;
                }
            }
        }
    }
}