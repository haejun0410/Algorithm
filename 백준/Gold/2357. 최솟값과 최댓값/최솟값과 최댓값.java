import java.io.*;
import java.util.*;

public class Main {

    public static class SegmentTree {
        int[][] tree;
        int n;

        SegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[4 * n][2];
            build(arr, 1, 0, n - 1);
        }

        private void build(int[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node][0] = arr[start]; // 최솟값
                tree[node][1] = arr[start]; // 최댓값
                return;
            }

            int mid = (start + end) / 2;
            build(arr, 2 * node, start, mid);
            build(arr, 2 * node + 1, mid + 1, end);

            tree[node][0] = Math.min(tree[node * 2][0], tree[node * 2 + 1][0]);
            tree[node][1] = Math.max(tree[node * 2][1], tree[node * 2 + 1][1]);
        }

        // 최솟값 쿼리
        public int minQuery(int l, int r) {
            return minQueryHelper(1, 0, n - 1, l, r);
        }

        private int minQueryHelper(int node, int start, int end, int l, int r) {
            if (start > r || end < l) {
                return Integer.MAX_VALUE;
            }
            if (l <= start && end <= r) {
                return tree[node][0];
            }
            int mid = (start + end) / 2;
            return Math.min(minQueryHelper(node * 2, start, mid, l, r),
                    minQueryHelper(node * 2 + 1, mid + 1, end, l, r));
        }

        // 최댓값 쿼리
        public int maxQuery(int l, int r) {
            return maxQueryHelper(1, 0, n - 1, l, r);
        }

        private int maxQueryHelper(int node, int start, int end, int l, int r) {
            if (start > r || end < l) {
                return Integer.MIN_VALUE;
            }
            if (l <= start && end <= r) {
                return tree[node][1];
            }
            int mid = (start + end) / 2;
            return Math.max(maxQueryHelper(node * 2, start, mid, l, r),
                    maxQueryHelper(node * 2 + 1, mid + 1, end, l, r));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        SegmentTree stree = new SegmentTree(arr);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken()) - 1;

            sb.append(stree.minQuery(left, right))
                    .append(" ")
                    .append(stree.maxQuery(left, right))
                    .append("\n");
        }
        System.out.print(sb);
    }
}