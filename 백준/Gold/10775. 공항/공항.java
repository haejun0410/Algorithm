import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int g = Integer.parseInt(br.readLine());
        parent = new int[g+1];
        for (int i = 0; i < g+1; i++) {
            parent[i] = i;
        }

        int p = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < p; i++) {
            int n = Integer.parseInt(br.readLine());
            int root = find(n);

            if (root == 0) break;
            count++;
            union(root, find(root-1));
        }

        System.out.print(count);
    }

    public static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) parent[a] = b;
    }
}