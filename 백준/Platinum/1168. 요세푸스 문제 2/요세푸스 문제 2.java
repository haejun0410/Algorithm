import java.util.*;
import java.io.*;

public class Main {
	
	static int[] tree;
	static int n;
	
	public static void init(int num) {
		n = num;
		tree =  new int[4*n];
	}
	
	public static void build(int node, int start, int end) {
		if (start == end) {
			tree[node] = 1;
			return;
		}
		
		int mid = (start + end) / 2;
		build(node * 2, start, mid);
		build(node * 2 + 1, mid + 1, end);
		
		tree[node] = tree[node*2] + tree[node * 2 + 1];
	}
	
	public static int update(int node, int start, int end, int k) {
		tree[node]--;
		if (start == end) return start + 1;
		
		int mid = (start + end) / 2;
		if (tree[node*2] >= k) {
			return update(node * 2, start, mid, k);
		}
		return update(node*2+1, mid + 1, end, k - tree[node*2]);
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		init(n);
		build(1, 0, n-1);
		int pos = 1;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int i = 0; i < n; i++) {
			int size = n-i;
			
			pos = (pos + k - 1) % size;
			if (pos == 0) pos = size;
			int result = update(1, 0, n-1, pos);
			
			sb.append(result);
			sb.append(i == n-1 ? "" : ", ");
		}
		sb.append(">");
		
		System.out.print(sb);
	}
}