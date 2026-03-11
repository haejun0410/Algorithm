import java.io.*;
import java.util.*;

public class Main {

    public static class SegmentTree {
        int[] tree;
        int[] arr;
        int n;

        SegmentTree(int[] arr) {
            this.arr = arr;
            this.n = arr.length;
            tree = new int[4 * n];
            build(1, 0, n - 1);
        }

        private void build(int node, int start, int end) {
            if (start == end) {
                tree[node] = start; // 인덱스를 저장
                return;
            }

            int mid = (start + end) / 2;
            build(node * 2, start, mid);
            build(node * 2 + 1, mid + 1, end);
            
            // 왼쪽 자식 값(인덱스)의 높이 <= 오른쪽 자식의 높이
            // 둘 중 작은 값을 갖는 자식의 값(인덱스) 저장
            if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) {
                tree[node] = tree[node * 2];
            } else {
                tree[node] = tree[node * 2 + 1];
            }
        }

        public int query(int l, int r) {
            return queryHelper(1, 0, n - 1, l, r);
        }

        private int queryHelper(int node, int start, int end, int l, int r) {
            if (start > r || end < l) return -1;

            if (start >= l && end <= r) return tree[node];

            int mid = (start + end) / 2;
            int leftIdx = queryHelper(node * 2, start, mid, l, r);
            int rightIdx = queryHelper(node * 2 + 1, mid + 1, end, l, r);

            if (leftIdx == -1) return rightIdx;
            if (rightIdx == -1) return leftIdx;

            return arr[leftIdx] <= arr[rightIdx] ? leftIdx : rightIdx;
        }

        public long getMaxArea(int l, int r) {
            int m = query(l, r); // 구간 내 최소 높이의 인덱스

            // 1. 현재 구간의 최소 높이 * 구간 너비
            long area = (long) (r - l + 1) * arr[m];

            // 2. 왼쪽 구간 탐색
            if (l <= m - 1) {
                area = Math.max(area, getMaxArea(l, m - 1));
            }
            // 3. 오른쪽 구간 탐색
            if (m + 1 <= r) {
                area = Math.max(area, getMaxArea(m + 1, r));
            }

            return area;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line, " ");
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            SegmentTree segTree = new SegmentTree(arr);
            sb.append(segTree.getMaxArea(0, n - 1)).append("\n");
        }
        System.out.print(sb);
    }
}