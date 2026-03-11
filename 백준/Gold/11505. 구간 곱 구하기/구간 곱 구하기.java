import java.io.*;
import java.util.*;

public class Main {

    static int MODULO = 1_000_000_007;

    public static class SegmentTree {
        long[] tree;
        int n;

        SegmentTree(long[] arr) {
            n = arr.length;
            tree = new long[4*n];
            build(arr, 1, 0, n-1);
        }

        private void build(long[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start] % MODULO;
                return;
            }

            int mid = (start + end) / 2;
            build(arr, node * 2, start, mid);
            build(arr, node * 2 + 1, mid + 1, end);

            tree[node] = (tree[2*node] * tree[2*node+1]) % MODULO;
        }

        public void update(int idx, long val) {
            updateHelper(1, 0, n-1, idx, val);
        }

        public void updateHelper(int node, int start, int end, int idx, long val) {
            if (start == end) {
                tree[node] = val % MODULO;
                return;
            }

            int mid = (start + end) / 2;

            if (idx <= mid) {
                updateHelper(node * 2, start, mid, idx, val);
            }
            if (idx > mid) {
                updateHelper(node * 2 + 1, mid + 1, end, idx, val);
            }

            tree[node] = (tree[2 * node] * tree[2 * node + 1]) % MODULO;
        }


        public long query(int l, int r) {
            return queryHelper(1, 0, n-1, l, r);
        }
        private long queryHelper(int node, int start, int end, int l, int r) {
            //1. 구간을 벗어남
            if (start > r || end < l) {
                return 1;
            }

            // 2. 완전히 겹침
            if (start >= l && end <= r) {
                return tree[node];
            }

            // 3. 그 외
            int mid = (start + end) / 2;
            long left = queryHelper(2*node, start, mid, l, r);
            long right = queryHelper(2*node + 1, mid +1, end, l, r);

            return left * right % MODULO;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        SegmentTree segTree = new SegmentTree(arr);

        for (int i = 0; i < m+k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            // update
            if (a == 1) {
                segTree.update(b-1, c);
            }
            // query
            else if (a == 2) {
                sb.append(segTree.query(b-1, (int) c-1)).append("\n");
            }

        }

        System.out.print(sb);
    }
}