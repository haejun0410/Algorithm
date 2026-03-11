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
			build(arr, 2*node, start, mid);
			build(arr, 2*node+1, mid + 1, end);
			
			tree[node] = tree[2*node] + tree[2*node + 1];
		}
		
		private void push(int node, int start, int end) {
			if (lazy[node] == 0) return;
			
			tree[node] += (end - start + 1) * lazy[node];
			
			if (start != end) {
				lazy[2 * node] += lazy[node];
				lazy[2 * node + 1] += lazy[node];
			}
			
			lazy[node] = 0;
		}
		
		public void updateRange(int l, int r, long val) {
			updateRangeHelper(1, 0, n-1, l, r, val);
		}
		private void updateRangeHelper(int node, int start, int end, int l, int r, long val) {
			push(node, start, end);
			
			// 범위를 벗어남
			if (start > r || end < l) return;
			// 범위가 포함됨
			if (start >= l && end <= r) {
				lazy[node] += val;
				push(node, start, end);
				return;
			}
			
			// 범위가 일부 포함
			int mid = (start + end) / 2;
			updateRangeHelper(2*node, start, mid, l, r, val);
			updateRangeHelper(2*node+1, mid + 1, end, l, r, val);
			
			tree[node] = tree[2*node] + tree[2*node+1];
		}
		
		public long query(int x) {
			return queryHelper(1, 0, n-1, x);
		}
		
		private long queryHelper(int node, int start, int end, int x) {
			push(node, start, end);
			
			if (start == end) {
				return tree[node];
			}
			
			int mid = (start + end) / 2;
			if (x <= mid) {
				return queryHelper(node * 2, start, mid, x);
			}
			else {
				return queryHelper(node * 2 + 1, mid + 1, end, x);
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		LazySegmentTree lazySegTree = new LazySegmentTree(arr);
		
		int m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			
			
			// 업데이트 
			if (a == 1) {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				long d = Long.parseLong(st.nextToken());
				
				lazySegTree.updateRange(b-1, c-1, d);
			}
			// 쿼리
			else if (a == 2) {
				int x = Integer.parseInt(st.nextToken());
				sb.append(lazySegTree.query(x-1)).append("\n");
			}
		}
		
		System.out.print(sb);
	}
}
