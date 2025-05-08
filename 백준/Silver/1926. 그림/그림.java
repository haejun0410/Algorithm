import java.io.*;
import java.util.*;

public class Main {

	static int[][] board;
	static boolean[][] visited;
	static int n,m;
	static int count = 0;
	static int maxArea = 0;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		visited = new boolean[n][m];

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if (board[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					bfs(i,j);
					count++;
				}
			}
		}

		System.out.println(count);
		System.out.println(maxArea);
	}

	public static void bfs(int y, int x) {
		int tempCount = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {y, x});

		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			tempCount++;
			for(int i=0; i<4; i++) {
				int ny = current[0] + dy[i];
				int nx = current[1] + dx[i];

				if (ny >= 0 && ny < n && nx >=0 && nx < m && board[ny][nx] == 1) {
					if (!visited[ny][nx]) {
						queue.offer(new int[] {ny, nx});
						visited[ny][nx] = true;
					}
				}
			}
		}

		maxArea = Math.max(maxArea, tempCount);

	}
}

