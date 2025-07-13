import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static long[] nums;
    static long[] tree;
    static int S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        S = 1;
        while (S < N) {
            S *= 2;
        }

        nums = new long[N];
        tree = new long[S * 2];

        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }

        init();

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int idx = Integer.parseInt(st.nextToken());
                long val = Long.parseLong(st.nextToken());
                long diff = val - tree[S + idx - 1];
                update(1, S, 1, idx, diff);
            } else {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                System.out.println(query(1, S, 1, from, to));
            }
        }
        br.close();

    }

    private static void init() {
        for (int i = 0; i < N; i++) {
            tree[S + i] = nums[i];
        }
        
        for (int i = S - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    static long query(int left, int right, int node, int queryLeft, int queryRight) {
        if (queryRight < left || right < queryLeft) { 
            return 0;
        } else if (queryLeft <= left && right <= queryRight) { 
            return tree[node];
        } else { 
            int mid = (left + right) / 2;
            return query(left, mid, node * 2, queryLeft, queryRight)
                    + query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
        }
    }

    static void update(int left, int right, int node, int target, long diff) {

        if (target < left || right < target) {
            return;
        } else { 
            tree[node] += diff;
            if (left != right) {
                int mid = (left + right) / 2;
                update(left, mid, node * 2, target, diff);
                update(mid + 1, right, node * 2 + 1, target, diff);
            }
        }
    }
}