import java.util.*;
import java.io.*;

public class Main {
	
	static int[] arr;
	static int[] tree;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		tree = new int[4*n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		build(1, 0, n-1);
		
		int m = Integer.parseInt(br.readLine());
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			
			// update
			if (a==1) {
				int idx = Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				update(1, 0, n-1, idx-1, val);
			}
			// query
			else {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				sb.append(query(1, 0, n-1, from-1, to-1)+1).append("\n");
			}
		}
		
		System.out.println(sb);
		
		
	}
	
	public static void build(int node, int start, int end) {
		if (start == end) {
			tree[node] = start;
			return;
		}
		
		int mid = (start + end) / 2;
		build(node * 2, start, mid);
		build(node * 2 + 1, mid + 1, end);
		
		if (arr[tree[node *2]] <= arr[tree[node*2+1]]) {
			tree[node] = tree[node*2];
		}
		else {
			tree[node] = tree[node*2+1];
		}
	}
	
	public static void update(int node, int start, int end, int index, int newValue) {
	    if (index < start || index > end) {
	        return;
	    }

	    if (start == end) {
	        arr[index] = newValue;
	        return;
	    }

	    int mid = (start + end) / 2;
	    update(node * 2, start, mid, index, newValue);
	    update(node * 2 + 1, mid + 1, end, index, newValue);

	    if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) {
	        tree[node] = tree[node * 2];
	    } else {
	        tree[node] = tree[node * 2 + 1];
	    }
	}
	
	public static int query(int node, int start, int end, int left, int right) {
	    if (left > end || right < start) {
	        return -1;
	    }
	    
	    if (left <= start && end <= right) {
	        return tree[node];
	    }
	    
	    int mid = (start + end) / 2;
	    int leftIdx = query(node * 2, start, mid, left, right);
	    int rightIdx = query(node * 2 + 1, mid + 1, end, left, right);
	    
	    if (leftIdx == -1) return rightIdx;
	    if (rightIdx == -1) return leftIdx;
	    
	    if (arr[leftIdx] <= arr[rightIdx]) {
	        return leftIdx;
	    } else {
	        return rightIdx;
	    }
	}
}