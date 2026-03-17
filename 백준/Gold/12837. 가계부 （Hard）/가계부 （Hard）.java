import java.util.*;
import java.io.*;

public class Main {

    public static class SegmentTree {
        long[] tree;
        int n;

        SegmentTree(int N) {
            n = N;
            tree = new long[4*n];
        }

        public void update(int idx, int diff) {
            updateHelper(1, 0, n-1, idx, diff);
        }

        public void updateHelper(int node, int start, int end, int idx, int diff) {
            if (idx < start || idx > end) return;

            tree[node] += diff;

            if (start == end) return;

            int mid = (start + end) / 2;

            if (idx <= mid) {
                updateHelper(node * 2, start, mid, idx, diff);
            }
            else {
                updateHelper(node * 2 + 1, mid+1, end, idx, diff);
            }

        }

        public long query(int p, int q) {
            return queryHelper(1, 0, n-1, p, q);
        }
        public long queryHelper(int node, int start, int end, int p, int q) {
            if (q < start || p > end) return 0;

            if (start >= p && end <= q) return tree[node];

            int mid = (start + end) / 2;
            long left = queryHelper(2 * node, start, mid, p, q);
            long right = queryHelper(2*node + 1, mid+1 , end, p, q);

            return left + right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        SegmentTree segTree = new SegmentTree(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st= new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                segTree.update(b-1, c);
            }
            else {
                sb.append(segTree.query(b-1, c-1)).append("\n");
            }
        }

        System.out.println(sb);
    }
}