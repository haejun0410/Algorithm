import java.io.*;
import java.util.*;

public class Main {
	static int n,m;

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	static Character[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new Character[n][m];

		for (int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		int maxDistance = -1;

		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (map[i][j] == 'L') {
					int temp = bfs(i, j);
					maxDistance = Math.max(temp, maxDistance);
				}
			}
		}

		System.out.println(maxDistance);
	}

	public static int bfs(int y, int x) {
		int answer = -1;
		int[][] visited = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = -1;
			}
		}
		Queue<node> queue = new LinkedList<>();
		queue.offer(new node(y, x));
		visited[y][x] = 0;
		while (!queue.isEmpty()) {
			node current = queue.poll();
			for(int i=0; i<4; i++) {
				int ny = current.y + dy[i];
				int nx = current.x + dx[i];

				if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
					if (visited[ny][nx] == -1 && map[ny][nx] == 'L') {
						visited[ny][nx] = visited[current.y][current.x] + 1;
						answer = Math.max(visited[ny][nx], answer);
						queue.offer(new node(ny, nx));
					}
				}
			}
		}

		return answer;
	}

	public static class node {
		int y, x;

		public node (int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
