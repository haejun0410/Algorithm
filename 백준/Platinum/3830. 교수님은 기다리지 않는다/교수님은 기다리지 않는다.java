import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;
    static int[] weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) break;

            parent = new int[n+1];
            weight = new int[n+1];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 0;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                char command = st.nextToken().charAt(0);

                // 무게 차이를 기록
                if (command == '!') {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    union(a, b, c);
                }
                // 무게 차이를 계산
                else if (command == '?') {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    // 같은 집합 안에 없다면 계산 불가능
                    if (find(a) != find(b)) {
                        sb.append("UNKNOWN").append("\n");
                    }
                    else {
                        sb.append(weight[b] - weight[a]).append("\n");
                    }

                }
            }

        }

        System.out.print(sb);
    }

    public static int find(int a) {
        if (parent[a] == a) return a;

        int root = find(parent[a]);
        weight[a] += weight[parent[a]];
        return parent[a] = root;
    }

    public static void union(int a, int b, int w) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
            weight[rootB] = weight[a] - weight[b] + w;
        }
    }
}