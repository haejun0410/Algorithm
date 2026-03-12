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
		
		private void build(long[] arr, int node, int start, int end) {
			if (start == end) {
				tree[node] = arr[start];
				return;
			}
			
			int mid = (start + end) / 2;
			
			build(arr, node * 2, start, mid);
			build(arr, node * 2 + 1, mid + 1, end);
			
			tree[node] = tree[node * 2] + tree[node * 2 + 1];
		}
		
		private void push(int node, int start, int end) {
			if (lazy[node] == 0) return;
			
			tree[node] += lazy[node] * (end - start + 1);
			
			if (start != end) {
				lazy[node * 2] += lazy[node];
				lazy[node * 2 + 1] += lazy[node];
			}
			
			lazy[node] = 0;
		}
		
		public void updateRange(int l, int r, long val) {
			updateRangeHelper(1, 0, n-1, l, r, val);
		}
		
		private void updateRangeHelper(int node, int start, int end, int l, int r , long val) {
			push(node, start, end);
			
			// 범위를 벗어남
			if (start > r || end < l) return;
			// 범위와 완전히 겹침
			if (start >= l && end <= r) {
				lazy[node] += val;
				push(node, start, end);
				return;
			}
			// 그외
			int mid = (start + end) / 2;
			
			updateRangeHelper(node * 2, start, mid, l, r, val);
			updateRangeHelper(node * 2 + 1, mid + 1, end, l, r, val);
			
			tree[node] = tree[node * 2] + tree[node * 2 + 1];
		}
		
		public long query(int idx) {
			return queryHelper(1, 0, n-1, idx);
		}
		
		private long queryHelper (int node, int start, int end, int idx) {
			push(node, start, end);
			if (start == end) {
				return tree[node];
			}
			
			int mid = (start + end) / 2;
			
			if (idx <= mid) {
				return queryHelper(node * 2, start, mid, idx);
			}
			else {
				return queryHelper(node * 2 + 1, mid +1, end, idx);
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		long[] arr = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		LazySegmentTree lazySegTree = new LazySegmentTree(arr);
		
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			
			// update
			if (a == 1) {
				int b = Integer.parseInt(st.nextToken()) -1;
				int c = Integer.parseInt(st.nextToken()) -1;
				long d = Long.parseLong(st.nextToken());
				lazySegTree.updateRange(b, c, d);
			}
			// query
			else if (a == 2) {
				int x = Integer.parseInt(st.nextToken()) -1;
				sb.append(lazySegTree.query(x)).append("\n");
			}
		}
		
		System.out.print(sb);
	}
}