import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;
    static int[] cost;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        cost = new int[n+1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < n+1; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int sum = 0;
        for (int i = 1; i < n+1; i++) {
            if (parent[i] == i) {
                sum += cost[i];
            }
        }

        System.out.println(sum <= k ? sum : "Oh no");


    }

    public static int find(int a) {
        if (parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            if (cost[rootA] < cost[rootB]) {
                parent[rootB] = rootA;
            }
            else {
                parent[rootA] = rootB;
            }
        }
    }
}