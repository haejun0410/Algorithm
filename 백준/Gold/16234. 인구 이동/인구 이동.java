import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int n, l, r;
	static int[] dx = {0, 0, -1, 1}; 
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;
		while (true) {
			visited = new boolean[n][n];
			boolean isMoved = false;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						if (bfs(i, j)) isMoved = true;
					}
				}
			}
			if (!isMoved) break;
			result++;
		}
		System.out.println(result);
	}

	public static boolean bfs(int y, int x) {
		Queue<int[]> q = new LinkedList<>();
		List<int[]> union = new ArrayList<>();

		q.offer(new int[]{y, x});
		union.add(new int[]{y, x});
		visited[y][x] = true;

		int sum = map[y][x];

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int cy = now[0], cx = now[1];

			for (int d = 0; d < 4; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];

				if (ny >= 0 && ny < n && nx >= 0 && nx < n && !visited[ny][nx]) {
					int diff = Math.abs(map[cy][cx] - map[ny][nx]);
					if (diff >= l && diff <= r) {
						q.offer(new int[]{ny, nx});
						union.add(new int[]{ny, nx});
						visited[ny][nx] = true;
						sum += map[ny][nx];
					}
				}
			}
		}

		if (union.size() <= 1) return false;

		int avg = sum / union.size();
		for (int[] u : union) {
			map[u[0]][u[1]] = avg;
		}
		return true;
	}
}
