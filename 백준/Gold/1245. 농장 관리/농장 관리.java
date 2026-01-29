import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] board;
	static int n,m;
	static int[] dy = {-1, 0, 1, 0, -1, -1, 1, 1};
	static int[] dx = {0, -1, 0, 1, -1, 1, -1, 1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
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
		
		
		int answer = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if (!visited[i][j] && isPick(i, j)) {
					answer++;
				}
			}
		}
		
		System.out.println(answer);
		
		
	}
	
	public static boolean isPick(int y, int x) {
		Queue<int[]> queue = new ArrayDeque<>();
		//visited = new boolean[n][m];
		queue.offer(new int[] {y, x});
		visited[y][x] = true;
		boolean flag = true;
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int cy = curr[0];
			int cx = curr[1];
			
			for(int i=0; i<8; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				
				if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
					if (board[ny][nx] != 0) {
						if (board[ny][nx] == board[cy][cx] && !visited[ny][nx]) {
							queue.offer(new int[] {ny, nx});
							visited[ny][nx] = true;
						}
						else if (board[ny][nx] > board[cy][cx]) {
							flag = false;
						}
					}
				}
			}
		}
		
		return flag;
	}
}
