import java.io.*;
import java.util.*;

public class Main {
	static Character[][] board;
	static int r,c;
	static boolean[] alpha;
	static int max = 0;

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		board = new Character[r][c];

		for (int i=0; i<r; i++) {
			String arr = br.readLine();
			for (int j=0; j<c; j++) {
				board[i][j] = arr.charAt(j);
			}
		}
		alpha = new boolean[26];
		dfs(0, 0, 1);
		System.out.println(max);

	}

	public static void dfs(int y, int x, int count) {
		alpha[board[y][x] - 'A'] = true;
		max = Math.max(max, count);

		for (int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny >= 0 && ny < r && nx >= 0 && nx < c) {
				if (alpha[board[ny][nx] - 'A'] == false) {
					dfs(ny, nx, count+1);
					alpha[board[ny][nx] - 'A'] = false;
				}
			}
		}
	}
}
