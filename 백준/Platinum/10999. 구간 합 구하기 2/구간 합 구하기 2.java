import java.util.*;
import java.io.*;


public class Main {

    public static class LazySegmentTree {
        long[] tree;
        long[] lazy;
        int n;

        LazySegmentTree(long[] arr) {
            n = arr.length;
            tree = new long[4*n];
            lazy = new long[4*n];
            build(arr, 1, 0, n-1);
        }

        public void build(long[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
                return;
            }

            int mid = (start + end) / 2;
            build(arr, 2*node, start, mid);
            build(arr, 2 * node + 1, mid + 1, end);

            tree[node] = tree[node * 2] + tree[node * 2 + 1];

        }

        public void push(int node, int start, int end) {
            if (lazy[node] == 0) return;

            tree[node] += lazy[node] * (end - start + 1);

            if (start != end) {
                lazy[2*node] += lazy[node];
                lazy[2*node+1] += lazy[node];
            }

            lazy[node] = 0;
        }

        public void updateRange(int l, int r, long val) {
            updateRangeHandler(1, 0, n-1, l, r, val);
        }

        public void updateRangeHandler(int node, int start, int end, int l, int r, long val) {
            push(node, start, end);

            // 범위 밖
            if (start > r || end < l) return;
            // 완전히 포함됨
            if (start >= l && end <= r) {
                lazy[node] += val;
                push(node, start, end);
                return;
            }
            // 일부가 포함됨
            int mid = (start + end) / 2;
            updateRangeHandler(node * 2, start, mid, l, r, val);
            updateRangeHandler(node * 2 + 1, mid + 1, end, l, r, val);

            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }

        public long query(int l, int r) {
            return queryHelper(1, 0, n-1, l, r);
        }

        public long queryHelper(int node, int start, int end, int l, int r) {
            push(node, start, end);

            // 범위 밖
            if (start > r || end < l) return 0;
            // 완전히 포함
            if (start >= l && end <= r) {return tree[node];}
            // 일부만 포함
            int mid = (start + end) / 2;
            long leftSum = queryHelper(node * 2, start, mid, l, r);
            long rightSum = queryHelper(node * 2 + 1, mid + 1, end, l, r);

            return leftSum + rightSum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        LazySegmentTree lazySegTree = new LazySegmentTree(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                long d = Long.parseLong(st.nextToken());
                lazySegTree.updateRange(b-1, c-1, d);
            }
            else if (a == 2) {
                sb.append(lazySegTree.query(b-1, c-1)).append("\n");
            }
        }

        System.out.println(sb);
    }
}