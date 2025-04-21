import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int rootNum = -1;
		visited = new boolean[n];

		arr = new ArrayList[n];
		for (int i=0; i<n; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent == -1) {
				rootNum = i;
			}
			else {
				arr[parent].add(i);
			}
		}

		int remove = Integer.parseInt(br.readLine());
		int answer = dfs(rootNum, remove);

		System.out.println(answer);

	}

	public static int dfs(int node, int ban) {
		int count = 0;
		if (node == ban) {
			return 0;
		}

		if (arr[node].size() == 0) {
			return 1;
		}
		visited[node] = true;
		for (int i=0; i<arr[node].size(); i++) {
			int newNode = arr[node].get(i);
			if (!visited[newNode]) {
				count = count + dfs(newNode, ban);
			}
		}
		if (count == 0) {
			count++;
		}
		return count;
	}
}
