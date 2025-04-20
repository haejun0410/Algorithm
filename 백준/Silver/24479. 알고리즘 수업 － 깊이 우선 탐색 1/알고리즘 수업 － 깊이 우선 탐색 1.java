import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<Integer>[] map;
	static int n,m;
	static int visited[];
	static int order = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		map = new ArrayList[n+1];
		for (int i=1; i<=n; i++) {
			map[i] = new ArrayList<>();
		}

		visited = new int[n+1];

		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int e1 = Integer.parseInt(st.nextToken());
			int e2 = Integer.parseInt(st.nextToken());
			map[e1].add(e2);
			map[e2].add(e1);
		}
		

		for (int i=1; i<n+1; i++) {
			Collections.sort(map[i]);
		}

		dfs(start);

		for (int i=1; i<n+1; i++) {
			System.out.println(visited[i]);
		}
        
    }

	public static void dfs(int point) {
		visited[point] = order++;
		for (int i=0; i<map[point].size(); i++) {
			if (visited[map[point].get(i)] == 0) {
				dfs(map[point].get(i));
			}
		}
	}

}