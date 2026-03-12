import java.util.*;
import java.io.*;

public class Main {
	
	public static class SegmentTree {
		// 맛의 강도 범위
		long[] tree;
		int n;
		
		SegmentTree() {
			n = 1_000_001;
			tree = new long[4*n];
		}
		
		public void update(int b, long c) {
			updateHelper(1, 0, n-1, b, c);
		}
		
		private  void updateHelper(int node, int start, int end, int b, long c) {
			
			if (b < start || b > end) return;
			
			tree[node] += c;
			
			if (start != end) {
				int mid = (start + end) / 2;
				updateHelper(node * 2, start, mid, b, c);
				updateHelper(node * 2 + 1, mid + 1, end, b, c);
			}
		}
		
		public int query(int b) {
			return queryHelper(1, 0, n-1, b);
		}
		
		private int queryHelper(int node, int start, int end, long b) {
			if (start == end) {
				return start;
			}
			
			int mid = (start + end) / 2;
			
			// 맛이 더 좋은 쪽
			long leftCount = tree[node * 2];
			
			if ( b <= leftCount ) {
				return queryHelper(node * 2, start, mid, b);
			}
			else {
				return queryHelper(node * 2 + 1, mid + 1, end, b - leftCount);
			}
			
		}
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		SegmentTree segTree = new SegmentTree();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			
			// 꺼내기
			if (a == 1) {
				int b = Integer.parseInt(st.nextToken());
				int idx = segTree.query(b);
				sb.append(idx).append("\n");
				segTree.update(idx, -1);
			}
			// 넣기
			else if (a == 2) {
				int b = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				
				segTree.update(b,  c);
			}
		}
		
		System.out.print(sb);
	}
}