import java.util.*;
import java.io.*;

public class Main {
	
	static int[] parent;
	static int[] count;
	static int id;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		HashMap<String, Integer> map = new HashMap<>();
		parent = new int[200001];
		count = new int[200001];
		
		int TC = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= TC; testCase++) {
			// 초기화
			map.clear();
			id = 1;
			for (int i = 0; i < 200001; i++) {
				parent[i] = i;
				count[i] = 1;
			}
			
			int f = Integer.parseInt(br.readLine());
			for (int i = 0 ; i < f; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				String name1 = st.nextToken();
				String name2 = st.nextToken();
				
				map.computeIfAbsent(name1, k -> id++);
				map.computeIfAbsent(name2, k -> id++);
				
				int id1 = map.get(name1);
				int id2 = map.get(name2);
				
				sb.append(union(id1, id2)).append("\n");
				
				
			}
			
		}
		
		System.out.print(sb);
	}
	
	public static int find(int a) {
		if (parent[a] == a) return a;
		
		return parent[a] = find(parent[a]);
	}
	
	public static int union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA != rootB) {
			parent[rootA] = rootB;
			count[rootB] += count[rootA];
		}
		
		return count[rootB];
	}
}