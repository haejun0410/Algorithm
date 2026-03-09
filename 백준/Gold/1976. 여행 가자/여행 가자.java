import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            parent[i] = i;
        }

        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < n+1; j++) {
                int w = Integer.parseInt(st.nextToken());

                if (w == 1) {
                    union(i, j);
                }
            }
        }

        int root = -1;
        int count = -1;

        StringTokenizer st = new StringTokenizer(br.readLine(), " " );
        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (root != find(a)) {
                root = find(a);
                count++;
            }
            if (count > 0) break;
        }

        System.out.println(count == 0 ? "YES" : "NO");

    }

    public static int find(int a) {
        if (parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}