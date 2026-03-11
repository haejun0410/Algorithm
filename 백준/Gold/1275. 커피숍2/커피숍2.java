import java.io.*;
import java.util.*;

public class Main {

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
                tree[node] = arr[start];
                return;
            }

            int mid = (start + end) / 2;
            build(arr,2 * node, start, mid);
            build(arr, 2 * node + 1, mid + 1, end);

            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }

        public void update(int idx, long val) {
            updateHelper(1, 0, n-1, idx, val);
        }

        private void updateHelper(int node, int start, int end, int idx, long val) {
            if (start == end) {
                tree[node] = val;
                return;
            }

            int mid = (start + end) / 2;

            // 왼쪽 자식 업데이트
            if (idx <= mid) {
                updateHelper(node * 2, start, mid, idx, val);
            }
            // 오른쪽 자식 업데이트
            else if (idx > mid) {
                updateHelper(2 * node + 1, mid + 1, end, idx, val);
            }

            tree[node] = tree[node * 2] + tree[node * 2 + 1];

        }

        public long query(int l, int r) {
            return queryHelper(1, 0, n-1, l, r);
        }

        private long queryHelper(int node, int start, int end, int l, int r) {
            // 1. 구간이 겹치지 않음
            if (start > r || end < l) {
                return 0;
            }

            // 2. 완전히 겹침
            if (start >= l && end <= r) {
                return tree[node];
            }
            // 3. 그 외
            int mid = (start + end) / 2;

            long left = queryHelper(node * 2, start, mid, l, r);
            long right = queryHelper(node * 2 + 1, mid + 1, end, l, r);

            return left + right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        SegmentTree segTree = new SegmentTree(arr);

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken())- 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            long b = Long.parseLong(st.nextToken());

            sb.append(segTree.query(Math.min(x, y), Math.max(x, y))).append("\n");
            segTree.update(a, b);

        }

        System.out.print(sb);
    }
}