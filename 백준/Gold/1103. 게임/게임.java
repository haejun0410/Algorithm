import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static char[][] board;
    static boolean[][] visited;
    static int[][] record;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        for(int i=0; i<n; i++) {
            String arr = br.readLine();
            for(int j=0; j<m; j++) {
                board[i][j] = arr.charAt(j);
            }
        }

        visited = new boolean[n][m];
        record = new int[n][m];

        System.out.println(search(0, 0));
	}

    public static int search(int y, int x) {

        if ((y < 0 || y >= n || x < 0 || x >= m) || board[y][x] == 'H') {
            return 0;
        }

        // 무한 루프 체크
        if (visited[y][x]) {
            System.out.println("-1");
            System.exit(0);
        }

        if (record[y][x] != 0) {
            return record[y][x];
        }

        visited[y][x] = true;
        int maxMove = 0;
        int move = board[y][x] - '0';

        for(int i=0; i<4; i++) {
            int ny = y + dy[i] * move;
            int nx = x + dx[i] * move;

            maxMove = Math.max(maxMove, search(ny, nx) + 1);
        }

        record[y][x] = maxMove;
        visited[y][x] = false;

        return maxMove;
    }
	
}
