import java.util.*;
import java.io.*;

public class Main {
	
	public static class SegmentTree {
		int[] tree;
		int n;
		
		SegmentTree(int[] arr) {
			n = arr.length;
			tree = new int[4*n];
			build(arr, 1, 0, n-1);
		}
		
		private void build(int[] arr, int node, int start, int end) {
			if (start == end) {
				tree[node] = arr[start];
				return;
			}
			
			int mid = (start + end) / 2;
			build(arr, node * 2, start, mid);
			build(arr, node * 2 + 1, mid + 1, end);
			
			tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
		}
		
		public int query(int l, int r) {
			return queryHelper(1, 0, n-1, l, r);
		}
		
		private int queryHelper(int node, int start, int end, int l, int r) {
			// 겹치지 않음
			if (start > r || end < l) {
				return Integer.MAX_VALUE;
			}
			
			// 완전히 겹침
			if (start >= l && end <= r) {
				return tree[node];
			}
			
			// 일부 겹침
			int mid = (start + end) / 2;
			int left = queryHelper(node * 2, start, mid, l, r);
			int right = queryHelper(node * 2 + 1, mid + 1, end, l, r);
			
			return Math.min(left, right);

		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		SegmentTree segTree = new SegmentTree(arr);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(segTree.query(a-1, b-1)).append("\n");
			
		}
		
		System.out.println(sb);
	}
}