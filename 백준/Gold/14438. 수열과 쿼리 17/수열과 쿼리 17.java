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
		
		public void build(int[] arr, int node, int start, int end) {
			if (start == end) {
				tree[node] = arr[start];
				return;
			}
			
			int mid = (start + end) / 2;
			build(arr, node * 2, start, mid);
			build(arr, node * 2 + 1, mid + 1, end);
			
			tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
		}
		
		public void update(int idx, int val) {
			updateHelper(1, 0, n-1, idx, val);
		}
		
		public void updateHelper(int node, int start, int end, int idx, int val) {
			if (start == end) {
				tree[node] = val;
				return;
			}
			
			int mid = (start + end) / 2;
			
			if (idx <= mid) {
				updateHelper(node * 2, start, mid, idx, val);
			}
			else {
				updateHelper(node * 2 + 1, mid + 1, end, idx, val);
			}
			
			tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
		}
		
		public int query(int i, int j) {
			return queryHelper(1, 0, n-1, i, j);
		}
		
		public int queryHelper(int node, int start, int end, int i, int j) {
			// 범위 밖
			if (start > j || end < i) return Integer.MAX_VALUE;
			// 완전히 겹침
			if (start >= i && end <= j) {
				return tree[node];
			}
			// 그 외
			int mid = (start + end) / 2;
			int left = queryHelper(node * 2, start, mid, i, j);
			int right = queryHelper(node * 2 + 1, mid + 1, end, i, j);
			
			return Math.min(left, right);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		SegmentTree segTree = new SegmentTree(arr);
		
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if ( a == 1) {
				segTree.update(b-1, c);
			}
			else {
				sb.append(segTree.query(b-1,  c-1)).append("\n");
			}
		}
		
		System.out.println(sb);
		

	}

}
