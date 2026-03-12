import java.util.*;
import java.io.*;

public class Main {
	
	public static class SegmentTree {
		long[] tree;
		long[] arr;
		int n;
		
		SegmentTree(int num) {
			n = num;
			arr = new long[n];
			tree = new long[4*n];
		}
		
		public void update(int idx, long val) {
			long diff = val - arr[idx];
			arr[idx] = val;
			updateHelper(1, 0, n-1, idx, diff);
		}
		
		private void updateHelper(int node, int start, int end, int idx, long diff) {
			
			if (idx < start || idx > end) return;
			
			tree[node] += diff;
			
			if (start != end) {
				int mid = (start + end) / 2;
				updateHelper(node * 2, start, mid, idx, diff);
				updateHelper(node * 2 + 1, mid + 1, end, idx, diff);
			}
			
		}
		
		public long query(int l, int r) {
			return queryHelper(1, 0, n-1, l, r);
		}
		
		private long queryHelper(int node, int start, int end, int l, int r) {
			// 범위 밖임
			if (start > r || end < l) return 0;
			// 범위에 포함됨
			if (start >= l && end <= r) return tree[node];
			// 그외 -> 자식 확인
			
			int mid = (start + end) / 2;
			long left = queryHelper(node * 2, start, mid, l, r);
			long right = queryHelper(node * 2 + 1, mid + 1, end, l, r);
			
			return left + right;
		}
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		SegmentTree segTree = new SegmentTree(n);
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			
			// sum
			if (a == 0) {
				int b = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken())-1;
				
				sb.append(segTree.query(Math.min(b,  c), Math.max(c,  b))).append("\n");
			}
			// modify (update)
			else if (a == 1) {
				int b = Integer.parseInt(st.nextToken());
				long c = Integer.parseInt(st.nextToken());
				segTree.update(b-1, c);
			}
		}
		
		System.out.print(sb);
		
		
		
	}
}