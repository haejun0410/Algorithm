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

        // 구축
        private void build(long[] arr, int node, int start, int end) {
            // 리프 노드이면 -> 값 설정
            if (start == end) {
                tree[node] = arr[start];
                return;
            }

            int mid = (start + end) / 2;
            // 왼쪽 자식
            build(arr, 2 * node, start, mid);
            // 오른쪽 자식
            build(arr, 2 * node + 1, mid + 1, end);
            // 합
            tree[node] = tree[node *2] + tree[node * 2 + 1];
        }

        // 업데이트
        public void update(int idx, long val) {
            updateHelper(1, 0, n-1, idx, val);
        }

        private void updateHelper(int node, int start, int end, int idx, long val) {
            // 리프 노드이면 업데이트
            if (start == end) {
                tree[node] = val;
                return;
            }

            int mid = (start + end) / 2;
            // idx가 왼쪽 자식에 존재
            if (idx <= mid) {
                updateHelper(2 * node, start, mid, idx, val);
            }
            // idx가 오른쪽 자식에 존재
            else {
                updateHelper(2 * node + 1, mid + 1, end , idx, val);
            }

            // 변경된 자식을 통해 업데이트
            tree[node] = tree[2*node] + tree[2*node+1];
        }

        // 쿼리
        public long query(int l, int r) {
            return queryHelper(1, 0, n-1, l, r);
        }

        private long queryHelper(int node, int start, int end, int l, int r) {
            // 1. 구간 밖이면 0
            if (end < l || start > r) return 0;
            // 2. 완전히 포함되면 반환
            if (start >= l && end <= r) return tree[node];
            // 3. 일부만 포함되면 재귀
            int mid = (start + end) / 2;
            // 왼쪽 자식
            long leftSum = queryHelper(2 * node, start, mid, l, r);
            // 오른쪽 자식
            long rightSum = queryHelper(2 * node + 1, mid + 1, end, l, r);

            return leftSum + rightSum;
        }


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 수의 갯수
        int n = Integer.parseInt(st.nextToken());
        // 변경이 일어나는 횟수
        int m = Integer.parseInt(st.nextToken());
        // 구간 합을 구하는 횟수
        int k = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        SegmentTree segmentTree = new SegmentTree(arr);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                segmentTree.update(b-1, c);
            }
            else {
                sb.append(segmentTree.query(b-1, (int)c-1)).append("\n");
            }
        }

        System.out.print(sb);
    }
}