import java.util.*;
import java.io.*;

public class Main {
	
	public static class SegmentTree {
		// (start ~ end) 인덱스에 해당하는 수들의 합
		long[] tree;
		int n;
		
		SegmentTree() {
			n = 2_000_001;
			tree = new long[4*n];
		}
		
		public void update(int idx, int diff) {
			updateHelper(1, 0, n-1, idx, diff);
		}
		
		private void updateHelper(int node, int start, int end, int idx, int diff) {
			
			if (idx < start || idx > end) return;
			
			tree[node] += diff;
			
			if (start != end) {
				int mid = (start + end) / 2;
				updateHelper(node * 2, start, mid, idx, diff);
				updateHelper(node * 2 + 1, mid + 1, end, idx, diff);
			}
			
		}
		
		public int query(long idx) {
			return queryHelper(1, 0, n-1, idx);
		}
		
		private int queryHelper(int node, int start, int end, long idx) {
			if (start == end) {
				return start;
			}
			
			int mid = (start + end) / 2;
			long leftSum = tree[node*2];
			
			if (idx <= leftSum) {
				return queryHelper(2*node, start, mid, idx);
			}
			else {
				return queryHelper(2*node+1, mid + 1, end, idx - leftSum);
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		SegmentTree segTree = new SegmentTree();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			
			// update
			if (a==1) {
				int b = Integer.parseInt(st.nextToken());
				segTree.update(b, 1);
			}
			// query
			else if (a==2) {
				long b = Long.parseLong(st.nextToken());
				int idx = segTree.query(b);
				segTree.update(idx, -1);
				sb.append(idx).append("\n");
			}
		}
		
		System.out.print(sb);
	}
}